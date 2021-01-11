package com.myhotel.guestservice.service.guestdetails;

import com.myhotel.guestservice.model.request.GuestDetailsRequest;
import com.myhotel.guestservice.model.response.GuestDetails;

public interface GuestDetailsService {

    GuestDetails getGuestDetails(final Long guestId);

    String addGuest(final GuestDetailsRequest guestDetailsRequest);
}
