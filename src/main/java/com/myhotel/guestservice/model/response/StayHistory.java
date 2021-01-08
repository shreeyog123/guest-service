package com.myhotel.guestservice.model.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StayHistory {

    private LocalDate bookingStartDate;
    private LocalDate bookingEndDate;
}
