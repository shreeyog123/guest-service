package com.myhotel.guestservice.service.guestdetails;

import com.myhotel.guestservice.model.request.GuestDetailsRequest;
import com.myhotel.guestservice.model.response.GuestDetails;

public interface GuestDetailsService {

    String GUEST_ADD_SUCCESS_MESSAGE = "guest has been added successfully";
    String GUEST_IS_NOT_FOUND = "Guest is not found";

    GuestDetails getGuestDetails(final Long guestId);

    String addGuest(final GuestDetailsRequest guestDetailsRequest);
}
