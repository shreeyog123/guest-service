package com.myhotel.guestservice.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    @ApiModelProperty(notes = "building Name", required = false)
    private String buildingName;

    @ApiModelProperty(notes = "city", required = true)
    private String city;

    @ApiModelProperty(notes = "state", required = false)
    private String state;

    @ApiModelProperty(notes = "country", required = false)
    private String country;

    @ApiModelProperty(notes = "pin", required = true)
    private Integer pin;



}
