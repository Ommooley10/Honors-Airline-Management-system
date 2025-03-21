package com.example.project_om.controllers;

import com.example.project_om.dto.Ticket;
import com.example.project_om.services.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Ticket> bookTicket(@RequestBody Ticket ticket) {
        if (ticket.getFlightId() == null || ticket.getPassengerName() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ticket.setBookingTime(LocalDateTime.now());

        Ticket newTicket = ticketService.bookTicket(ticket);
        return new ResponseEntity<>(newTicket, HttpStatus.CREATED);
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable String ticketId) {
        Ticket ticket = ticketService.getTicketById(ticketId);
        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<String> cancelTicket(@PathVariable String ticketId) {
        boolean cancelled = ticketService.cancelTicket(ticketId);

        if (cancelled) {
            return new ResponseEntity<>("Ticket successfully cancelled", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Ticket not found", HttpStatus.NOT_FOUND);
        }
    }
}
