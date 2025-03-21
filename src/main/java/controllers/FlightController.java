package com.example.project_om.controllers;

import com.example.project_om.dto.Flight;
import com.example.project_om.services.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getFlights(@RequestParam(required = false) String sort) {
        List<Flight> flights = flightService.getAllFlights();

        if ("asc".equals(sort)) {
            flights.sort(Comparator.comparing(Flight::getFlightId));
        }

        return flights;
    }

    @GetMapping("/{flightId}")
    public Flight getFlightById(@PathVariable String flightId) {
        return flightService.findFlightById(flightId);
    }

    @GetMapping("/{flightId}/dates")
    public List<String> getFlightDates(@PathVariable String flightId,
                                       @RequestParam(required = false) String filterDate) {
        List<String> availableDates = flightService.getFlightDates(flightId);

        if (filterDate != null && availableDates != null) {
            availableDates = availableDates.stream()
                    .filter(date -> date.contains(filterDate))
                    .toList();
        }
        return availableDates;
    }
}
