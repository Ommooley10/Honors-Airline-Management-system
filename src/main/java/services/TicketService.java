package com.example.project_om.services;

import com.example.project_om.dto.Ticket;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {
    private final List<Ticket> ticketList = new ArrayList<>();

    public List<Ticket> getAllTickets() {
        return ticketList;
    }

    public Ticket getTicketById(String ticketId) {
        return ticketList.stream()
                .filter(ticket -> ticket.getTicketId().equals(ticketId))
                .findFirst()
                .orElse(null);
    }

    public Ticket bookTicket(Ticket ticket) {
        ticketList.add(ticket);
        return ticket;
    }

    public boolean cancelTicket(String ticketId) {
        Optional<Ticket> ticket = ticketList.stream()
                .filter(t -> t.getTicketId().equals(ticketId))
                .findFirst();

        ticket.ifPresent(t -> t.setCancelled(true));
        return ticket.isPresent();
    }

    public List<Ticket> getTicketsByEmail(String email) {
        return ticketList.stream()
                .filter(ticket -> ticket.getEmail().equals(email))
                .collect(Collectors.toList());
    }
}
