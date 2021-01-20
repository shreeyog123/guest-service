package com.myhotel.guestservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingHistory {

    private String hotelName;
    private String roomType;
    private LocalDate bookingStartDate;
    private LocalDate bookingEndDate;
    private String bookingStatus;
}
