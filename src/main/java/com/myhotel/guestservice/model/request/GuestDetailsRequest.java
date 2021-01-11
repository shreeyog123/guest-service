package com.myhotel.guestservice.model.request;

import com.myhotel.guestservice.model.response.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GuestDetailsRequest {

    private String guestFirstName;
    private String guestLastName;
    private Long phoneNumber;
    private String email;
    private Address address;
}
