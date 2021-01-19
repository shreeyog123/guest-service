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
public class StayHistory {

    private Long hotelId;
    private String hotelName;
    private String bookedRoomCode;
    private LocalDate bookingStartDate;
    private LocalDate bookingEndDate;
}
