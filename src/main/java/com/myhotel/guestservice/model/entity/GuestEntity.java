package com.myhotel.guestservice.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="GUEST_TABLE")
@Builder
public class GuestEntity {

    @Id
    @Column(name="GUEST_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer guestId;

    @Column(name="FULL_NAME")
    private String fullName;

    @Column(name="PHONE_NUMBER")
    private Long phoneNumber;


}
