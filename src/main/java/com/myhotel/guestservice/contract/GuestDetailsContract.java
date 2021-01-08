package com.myhotel.guestservice.contract;

import com.myhotel.guestservice.model.request.GuestDetailsRequest;
import com.myhotel.guestservice.model.response.GuestDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Api(value = "guest")
public interface GuestDetailsContract {

     @ApiOperation(
             value = "details",
             response =GuestDetails.class,
             produces = MediaType.APPLICATION_JSON_VALUE,
             httpMethod = "GET"
      )
     ResponseEntity<GuestDetails> getGuestDetails(
             @ApiParam(value = "guest id to get guest details") final Integer guestId);


    @ApiOperation(
            value = "add",
            response =Integer.class,
            produces = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "POST"
    )
    ResponseEntity<Integer> addGuest(
            @ApiParam(value = "request for add Guest") final GuestDetailsRequest guestDetailsRequest);
}
