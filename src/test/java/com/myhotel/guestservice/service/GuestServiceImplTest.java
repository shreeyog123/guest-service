package com.myhotel.guestservice.service;

import com.myhotel.guestservice.exception.GuestNotFoundException;
import com.myhotel.guestservice.model.entity.AddressEntity;
import com.myhotel.guestservice.model.entity.GuestEntity;
import com.myhotel.guestservice.model.request.GuestDetailsRequest;
import com.myhotel.guestservice.model.response.Address;
import com.myhotel.guestservice.model.response.Booking;
import com.myhotel.guestservice.model.response.BookingResponse;
import com.myhotel.guestservice.model.response.GuestDetails;
import com.myhotel.guestservice.repository.GuestDetailsRepository;
import com.myhotel.guestservice.service.guestdetails.GuestDetailsService;
import com.myhotel.guestservice.service.guestdetails.GuestDetailsServiceImpl;
import com.myhotel.guestservice.serviceproxy.ReservationServiceProxy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class GuestServiceImplTest {

    @Mock
    private GuestDetailsRepository guestDetailsRepository;

    static long guestId = 1231231231;

    private GuestDetailsServiceImpl guestDetailsService;

    @Mock
    private ReservationServiceProxy bookingServiceProxy;

    @Before
    public void setup(){
        initMocks(this);
        guestDetailsService = new GuestDetailsServiceImpl(guestDetailsRepository, bookingServiceProxy);

    }

    @Test(expected = GuestNotFoundException.class)
    public void shouldNotReturnGuestDetails_ifGuestIdIsNull(){

        when(bookingServiceProxy.getBookingDetailsByGuestId(null)).thenReturn(BookingResponse.builder().build());
        when(guestDetailsRepository.findById(guestId)).thenReturn(getGuestDetails());

        guestDetailsService.getGuestDetails(null);

    }

    @Test
    public void shouldReturnGuestDetails(){

        List<Booking> booking = new ArrayList<>();
        Booking book1 = Booking.builder()
                .bookingEndDate(LocalDate.now())
                .bookingStatus("CONFIRMED")
                .build();
        booking.add(book1);

        when(bookingServiceProxy.getBookingDetailsByGuestId(guestId)).thenReturn(BookingResponse.builder()
                .bookings(booking)
                .build());

        when(guestDetailsRepository.findById(guestId)).thenReturn(getGuestDetails());

        GuestDetails guestDetails = guestDetailsService.getGuestDetails(guestId);

        Assert.assertNotNull(guestDetails);
        Assert.assertEquals(guestId, guestDetails.getPhoneNumber());
        Assert.assertNotNull(guestDetails.getBookingHistories());
    }

    @Test(expected = GuestNotFoundException.class)
    public void shouldNotReturnGuestDetails_ifGuestIdNotFound(){

        when(guestDetailsRepository.findById(guestId)).thenReturn(Optional.empty());

        guestDetailsService.getGuestDetails(guestId);

    }

    @Test
    public void shouldGuestAddSuccessfully(){

        when(guestDetailsRepository.save(GuestEntity.builder().build())).thenReturn(GuestEntity.builder().phoneNumber(12345678L).build());

        String string = guestDetailsService.addGuest(GuestDetailsRequest.builder()
                .guestLastName("Will")
                .guestFirstName("Jon")
                .email("jon@xyz.com")
                .phoneNumber(9023453340L)
                .address(Address.builder()
                        .buildingName("ABC")
                        .city("PUNE")
                        .state("MH")
                        .country("INDIA")
                        .pin(444666)
                        .build())
                .build());

        Assert.assertNotNull(string);
        Assert.assertEquals(GuestDetailsService.GUEST_ADD_SUCCESS_MESSAGE, string);

    }

    private Optional<GuestEntity> getGuestDetails() {

        GuestEntity guestEntity = GuestEntity.builder()
                .firstName("Jon")
                .lastName("Watson")
                .email("jon@xyz.com")
                .phoneNumber(guestId)
                .address(AddressEntity.builder()
                        .buildingName("River side Wing")
                        .city("Leeds")
                        .state("Liverpool")
                        .country("UK")
                        .pin(112233)
                        .build()).build();

        return Optional.of(guestEntity);
    }
}
