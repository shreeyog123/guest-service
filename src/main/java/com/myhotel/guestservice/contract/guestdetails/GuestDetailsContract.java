package com.myhotel.guestservice.contract.guestdetails;

import com.myhotel.guestservice.model.request.GuestDetailsRequest;
import com.myhotel.guestservice.model.response.GenericErrorResponse;
import com.myhotel.guestservice.model.response.GuestDetails;
import com.myhotel.guestservice.model.response.GuestResponse;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "guest")
@RequestMapping("guest")
public interface GuestDetailsContract {

    @ApiOperation(
            value = "Request for add new guest information",
            response = GuestResponse.class,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Guest information has been successfully added.", response = GuestResponse.class),
            @ApiResponse(code = 400, message = "Business validation fail", response = GenericErrorResponse.class),
            @ApiResponse(code = 401, message = "Authentication failed."),
            @ApiResponse(code = 403, message = "You are not authorized to do this operation."),
            @ApiResponse(code = 404, message = "Resource not found.")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GuestResponse> addGuest(
            @ApiParam(value = "request for add new Guest") @RequestBody final GuestDetailsRequest guestDetailsRequest);

    @ApiOperation(
            value = "Fetch Guest Details ",
            response = GuestDetails.class,
            produces = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Guest information has been successfully added.", response = GuestDetails.class),
            @ApiResponse(code = 400, message = "Business validation fail", response = GenericErrorResponse.class),
            @ApiResponse(code = 401, message = "Authentication failed."),
            @ApiResponse(code = 403, message = "You are not authorized to do this operation."),
            @ApiResponse(code = 404, message = "Resource not found.")
    })
    @GetMapping(value = "/details/{guestId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GuestDetails> getGuestDetails(
            @ApiParam(value = "guest id to get guest details") @PathVariable("guestId") final Long guestId);

}


