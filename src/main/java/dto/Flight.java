package com.example.project_om.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Duration;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    private String flightId;
    private String airline;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private List<String> availableDates;
    private int totalSeats;
    private Duration travelDuration;
    private double price;
    private boolean isInternational;
}
