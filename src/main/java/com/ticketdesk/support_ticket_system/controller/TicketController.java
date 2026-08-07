package com.ticketdesk.support.controller;

import java.util.List;
import com.ticketdesk.support_ticket_system.model.Ticket;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @GetMapping()
    public List<Ticket> getTickets(){
        
        Ticket ticket1 = new Ticket(
                1L,
                "WiFi not working",
                "Unable to connect to university WiFi",
                "OPEN"
        );

        Ticket ticket2 = new Ticket(
                2L,
                "Cannot login",
                "Password is not being accepted",
                "IN_PROGRESS"
        );
        return List.of(ticket1,ticket2);
    }
    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        
        Ticket ticket=new Ticket(id,
            "WiFi not working",
            "Unable to connect to university WiFi",
            "OPEN");
        return ticket;
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticket;
    }
}