package com.myhotel.guestservice.contract.guestdetails;

import com.myhotel.guestservice.model.request.GuestDetailsRequest;
import com.myhotel.guestservice.model.response.GuestDetails;
import com.myhotel.guestservice.service.guestdetails.GuestDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("guest")
public class GuestDetailsController implements GuestDetailsContract{

    private final GuestDetailsService guestDetailsService;

    public GuestDetailsController(GuestDetailsService guestDetailsService) {
        this.guestDetailsService = guestDetailsService;
    }

    @Override
    @GetMapping(value = "/details/{guestId}")
    public ResponseEntity<GuestDetails> getGuestDetails(@PathVariable("guestId") final Long guestId){

        log.info("fetch guest details for guest-id {} ", guestId);

        GuestDetails guestDetails = guestDetailsService.getGuestDetails(guestId);

        log.info("guest details found for guest-id {} and details {} ", guestId, guestDetails);
        return ResponseEntity.ok().body(guestDetails);
    }

    @Override
    @PostMapping(value = "/add")
    public ResponseEntity<String> addGuest(@RequestBody final GuestDetailsRequest guestDetailsRequest) {

        String message = guestDetailsService.addGuest(guestDetailsRequest);

        return ResponseEntity.ok().body(message);
    }
}
