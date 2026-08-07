package com.ticketdesk.support.controller;

import com.ticketdesk.support_ticket_system.model.Ticket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @GetMapping
    public Ticket getTickets() {
        Ticket ticket =new Ticket(1L,"WiFi not working","Unable to connect to uni WiFi","OPEN");
        return ticket;
    }
}