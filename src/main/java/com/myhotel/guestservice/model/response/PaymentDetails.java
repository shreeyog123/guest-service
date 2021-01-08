package com.myhotel.guestservice.model.response;

import lombok.Data;

@Data
public class PaymentDetails {

    private Long cardNumber;
    private String bankName;

}
