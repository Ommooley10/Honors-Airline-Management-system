package com.example.project_om.services;

import com.example.project_om.dto.Flight;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {
    private final List<Flight> flightList = new ArrayList<>();

    public FlightService() {
        flightList.add(new Flight("FL123", "SkyWays", "Mumbai", "London", "10:00 AM", "07:00 PM",
                List.of("2025-03-23", "2025-03-24"), 250, Duration.ofHours(9), 45000.0, true));

        flightList.add(new Flight("FL456", "Air India", "Delhi", "Dubai", "02:00 PM",
                "05:00 PM", List.of("2025-04-10", "2025-04-15"), 180, Duration.ofHours(3), 15000.0, false));
    }

    public List<Flight> getAllFlights() {
        return flightList;
    }

    public Flight findFlightById(String flightId) {
        return flightList.stream()
                .filter(flight -> flight.getFlightId().equals(flightId))
                .findFirst()
                .orElse(null);
    }

    public List<String> getFlightDates(String flightId) {
        Flight flight = findFlightById(flightId);
        return (flight != null) ? flight.getAvailableDates() : null;
    }
}
