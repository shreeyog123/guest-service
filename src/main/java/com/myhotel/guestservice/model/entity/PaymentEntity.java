package com.myhotel.guestservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAYMENT_DETAILS")
public class PaymentEntity {

    @Id
    @Column(name="PHONE_NUMBER")
    private long phoneNumber;

    @Column(name="CARD_NUMBER")
    private String cardNumber;

    @Column(name="BANK_NAME")
    private String bankName;

}
