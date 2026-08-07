package com.ticketdesk.support.controller;

import java.util.List;
import java.util.ArrayList;     
import com.ticketdesk.support_ticket_system.model.Ticket;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private List<Ticket> tickets = new ArrayList<>();
    @GetMapping()
    public List<Ticket> getTickets(){
        return tickets;
    }
    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        for (Ticket ticket : tickets){
            if(ticket.getId().equals(id)){
                return ticket;
            }
        }
        return null;
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        tickets.add(ticket);
        return ticket;
    }
}