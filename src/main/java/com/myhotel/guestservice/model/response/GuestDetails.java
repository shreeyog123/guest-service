package com.myhotel.guestservice.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GuestDetails {

    private String guestFirstName;

    private String guestLastName;

    private long phoneNumber;

    private String email;

    private Address address;

    private List<StayHistory> stayHistory;

    private PaymentDetails paymentDetails;

}
