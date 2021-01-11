package com.myhotel.guestservice.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    private String buildingName;
    private String city;
    private String state;
    private String country;
    private Integer pin;



}
