package com.myhotel.guestservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="GUEST_TABLE")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuestEntity {

    @Id
    @Column(name="PHONE_NUMBER")
    private Long phoneNumber;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "buildingName", column = @Column(name = "BUILDING_NAME")),
            @AttributeOverride( name = "city", column = @Column(name = "CITY")),
            @AttributeOverride( name = "state", column = @Column(name = "STATE")),
            @AttributeOverride( name = "country", column = @Column(name = "COUNTRY")),
            @AttributeOverride( name = "pin", column = @Column(name = "PIN"))
    })
    private AddressEntity address;

}
