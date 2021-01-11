package com.myhotel.guestservice.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentInformationRequest {

    private Long phoneNumber;

    private String cardNumber;

    private String bankName;
}
