package com.myhotel.guestservice.service;

import com.myhotel.guestservice.model.entity.GuestEntity;
import com.myhotel.guestservice.model.request.GuestDetailsRequest;
import com.myhotel.guestservice.model.response.GuestDetails;
import com.myhotel.guestservice.repository.GuestDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuestDetailsServiceImpl implements GuestDetailsService{

   private final GuestDetailsRepository guestDetailsRepository;

    public GuestDetailsServiceImpl(GuestDetailsRepository guestDetailsRepository) {
        this.guestDetailsRepository = guestDetailsRepository;
    }

    @Override
    public GuestDetails getGuestDetails(final Integer guestId) {

        GuestEntity guestEntity = getGuestDetailsByGuestId(guestId);

        return GuestDetails.builder().guestId(guestEntity.getGuestId()).build();
    }

    @Override
    public Integer addGuest(GuestDetailsRequest guestDetailsRequest) {

       GuestEntity guest= guestDetailsRepository.save(GuestEntity.builder()
                .fullName(guestDetailsRequest.getFullName()).build());
        return guest.getGuestId();
    }

    private GuestEntity getGuestDetailsByGuestId(Integer guestId) {

        Optional<GuestEntity> guestEntity = guestDetailsRepository.findById(guestId);

        if(guestEntity.isPresent()) {

            return guestEntity.get();
        }
        else {
            throw new RuntimeException("Guest is not found");
        }
    }
}
