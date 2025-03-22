package com.example.project_om.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private String ticketId;
    private String flightId;
    private String passengerName;
    private String email;
    private boolean cancelled;
    private String seatNumber;
    private LocalDateTime bookingTime;
    private double ticketPrice;
    private String travelDate;
    private boolean baggageIncluded;
}
