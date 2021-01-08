package com.myhotel.guestservice.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GuestDetails {

    private int guestId;

    private String guestName;

    private Long phoneNumber;

    private Address address;

    private List<StayHistory> stayHistory;

    private PaymentDetails paymentDetails;







}
