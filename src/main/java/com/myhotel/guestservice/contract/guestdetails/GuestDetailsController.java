package com.myhotel.guestservice.contract.guestdetails;

import com.myhotel.guestservice.model.request.GuestDetailsRequest;
import com.myhotel.guestservice.model.response.GuestDetails;
import com.myhotel.guestservice.model.response.GuestResponse;
import com.myhotel.guestservice.service.guestdetails.GuestDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class GuestDetailsController implements GuestDetailsContract{

    private final GuestDetailsService guestDetailsService;

    public GuestDetailsController(GuestDetailsService guestDetailsService) {
        this.guestDetailsService = guestDetailsService;
    }

    @Override
    public ResponseEntity<GuestDetails> getGuestDetails(final Long guestId){

        log.info("fetch guest details for guest-id {} ", guestId);

        final GuestDetails guestDetails = guestDetailsService.getGuestDetails(guestId);
        log.info("guest details found for guest-id {} and details {} ", guestId, guestDetails);

        return ResponseEntity.ok().body(guestDetails);
    }

    @Override
    public ResponseEntity<GuestResponse> addGuest(final GuestDetailsRequest guestDetailsRequest) {

        log.info("request for add new guest profile, guestDetailsRequest{}", guestDetailsRequest);

        final String message = guestDetailsService.addGuest(guestDetailsRequest);
        log.info("new guest has been successfully saved, message {}", message);

        return ResponseEntity.status(HttpStatus.CREATED).body(GuestResponse.builder().message(message).build());
    }
}
