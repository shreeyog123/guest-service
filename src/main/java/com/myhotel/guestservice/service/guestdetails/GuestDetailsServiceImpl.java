package com.myhotel.guestservice.service.guestdetails;

import com.myhotel.guestservice.exception.GuestNotFoundException;
import com.myhotel.guestservice.model.entity.AddressEntity;
import com.myhotel.guestservice.model.entity.GuestEntity;
import com.myhotel.guestservice.model.request.GuestDetailsRequest;
import com.myhotel.guestservice.model.response.Address;
import com.myhotel.guestservice.model.response.BookingHistory;
import com.myhotel.guestservice.model.response.BookingResponse;
import com.myhotel.guestservice.model.response.GuestDetails;
import com.myhotel.guestservice.repository.GuestDetailsRepository;
import com.myhotel.guestservice.serviceproxy.ReservationServiceProxy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuestDetailsServiceImpl implements GuestDetailsService{

    public static final String GUEST_ADD_SUCCESS_MESSAGE = "guest has been added successfully";
    public static final String GUEST_IS_NOT_FOUND = "Guest is not found";

    private final GuestDetailsRepository guestDetailsRepository;
    private final ReservationServiceProxy reservationServiceProxy;

    public GuestDetailsServiceImpl(GuestDetailsRepository guestDetailsRepository, ReservationServiceProxy reservationServiceProxy) {
        this.guestDetailsRepository = guestDetailsRepository;
        this.reservationServiceProxy = reservationServiceProxy;
    }

    @Override
    public GuestDetails getGuestDetails(final Long guestId) {

       final GuestEntity guestEntity = getGuestDetailsByGuestId(guestId);

       BookingResponse booking = reservationServiceProxy.getBookingDetailsByGuestId(guestId);

       return setGuestDetailsResponse(guestEntity, booking);

    }

    @Override
    public String addGuest(final GuestDetailsRequest guestDetailsRequest) {

        saveGuestInDataBase(guestDetailsRequest);

        return GUEST_ADD_SUCCESS_MESSAGE;

    }

    private GuestDetails setGuestDetailsResponse(final GuestEntity guestEntity, BookingResponse bookingResponse) {

        Address address = Address.builder()
                .buildingName(guestEntity.getAddress().getBuildingName())
                .city(guestEntity.getAddress().getCity())
                .state(guestEntity.getAddress().getState())
                .country(guestEntity.getAddress().getCountry())
                .pin(guestEntity.getAddress().getPin())
                .build();

        List<BookingHistory> bookingHistory = new ArrayList<>();

        bookingResponse.getBookings().forEach(b->{
            bookingHistory.add( BookingHistory.builder()
                    .hotelName(b.getHotelName())
                    .roomType(b.getRoomType())
                    .bookingStatus(b.getBookingStatus())
                    .bookingStartDate(b.getBookingStartDate())
                    .bookingEndDate(b.getBookingEndDate())
                    .build());
        });

     return   GuestDetails.builder()
                .guestFirstName(guestEntity.getFirstName())
                .guestLastName(guestEntity.getLastName())
                .phoneNumber(guestEntity.getPhoneNumber())
                .email(guestEntity.getEmail())
                .address(address)
                .bookingHistories(bookingHistory)
                .build();
    }

    private void saveGuestInDataBase(GuestDetailsRequest guestDetailsRequest) {
        AddressEntity address = AddressEntity.builder()
                .buildingName(guestDetailsRequest.getAddress().getBuildingName())
                .city(guestDetailsRequest.getAddress().getCity())
                .state(guestDetailsRequest.getAddress().getState())
                .country(guestDetailsRequest.getAddress().getCountry())
                .pin(guestDetailsRequest.getAddress().getPin())
                .build();

        guestDetailsRepository.save(GuestEntity
                .builder()
                .firstName(guestDetailsRequest.getGuestFirstName())
                .lastName(guestDetailsRequest.getGuestLastName())
                .phoneNumber(guestDetailsRequest.getPhoneNumber())
                .email(guestDetailsRequest.getEmail())
                .address(address)
                .build());
    }

    private GuestEntity getGuestDetailsByGuestId(final Long guestId) {

        if(guestId != null) {
            Optional<GuestEntity> guestEntity = guestDetailsRepository.findById(guestId);
            if (guestEntity.isPresent()) {
                return guestEntity.get();
            } else {
                throw new GuestNotFoundException(GUEST_IS_NOT_FOUND);
            }
        }
        throw new GuestNotFoundException(GUEST_IS_NOT_FOUND);

    }

}
