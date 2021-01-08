package com.myhotel.guestservice.service;

import com.myhotel.guestservice.model.request.GuestDetailsRequest;
import com.myhotel.guestservice.model.response.GuestDetails;

public interface GuestDetailsService {

    GuestDetails getGuestDetails(final Integer guestId);

    Integer addGuest(GuestDetailsRequest guestDetailsRequest);
}
