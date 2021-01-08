package com.myhotel.guestservice.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GuestDetailsRequest {

    private String fullName;
    private String phoneNumber;
    private String address;
}
