package com.myhotel.guestservice.contract;

import com.myhotel.guestservice.model.request.GuestDetailsRequest;
import com.myhotel.guestservice.model.response.GuestDetails;
import com.myhotel.guestservice.service.GuestDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("guest")
public class GuestDetailsController implements GuestDetailsContract{

    private final GuestDetailsService guestDetailsService;

    public GuestDetailsController(GuestDetailsService guestDetailsService) {
        this.guestDetailsService = guestDetailsService;
    }

    @GetMapping(value = "/details/{guestId}")
    public ResponseEntity<GuestDetails> getGuestDetails(@PathVariable("guestId") final Integer guestId){

        GuestDetails guestDetails = guestDetailsService.getGuestDetails(guestId);

        return ResponseEntity.ok().body(guestDetails);
    }

    @Override
    @PostMapping(value = "/add")
    public ResponseEntity<Integer> addGuest(@RequestBody final GuestDetailsRequest guestDetailsRequest) {

        Integer guestId = guestDetailsService.addGuest(guestDetailsRequest);

        return ResponseEntity.ok().body(guestId);
    }
}
