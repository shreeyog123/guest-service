package com.myhotel.guestservice.model.request;

import com.myhotel.guestservice.model.response.Address;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class GuestDetailsRequest {

    @ApiModelProperty(notes = "first name", required = true)
    @NotNull(message = " first name should not be null")
    @NotEmpty(message = " first name should not be empty")
    private String guestFirstName;

    @ApiModelProperty(notes = "last name", required = false)
    private String guestLastName;

    @ApiModelProperty(notes = "phone number", required = true)
    @NotNull(message = " phone number should not be null")
    @NotEmpty(message = " phone number should not be empty")
    @Pattern(regexp = "\\d{10}", message = "phone number is not valid")
    private long phoneNumber;

    @ApiModelProperty(notes = " email id ", required = false)
    private String email;

    @ApiModelProperty(notes = "address", required = false)
    @Valid
    private Address address;
}
