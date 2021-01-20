package com.myhotel.guestservice.serviceproxy;

import com.myhotel.guestservice.model.response.BookingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "reservation-service")
public interface ReservationServiceProxy {

    @RequestMapping(value = "/booking/details/{guestId}", method = RequestMethod.GET)
    BookingResponse getBookingDetailsByGuestId(@PathVariable("guestId") Long guestId);



}
