package com.ticketdesk.support_ticket_system.controller;

import com.ticketdesk.support_ticket_system.dto.TicketRequest;
import com.ticketdesk.support_ticket_system.dto.TicketResponse;
import com.ticketdesk.support_ticket_system.model.Ticket;
import com.ticketdesk.support_ticket_system.service.TicketService;


import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<TicketResponse> getTickets() {
        return ticketService.getTickets();
    }

    @PostMapping
    public TicketResponse createTicket(
            @Valid @RequestBody TicketRequest request) {

        return ticketService.createTicket(request);
    }

    @GetMapping("/{id}")
    public TicketResponse getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }


    @PutMapping("/{id}")
    public TicketResponse updateTicket(
            @PathVariable Long id,
            @Valid @RequestBody TicketRequest request
    ) {

        return ticketService.updateTicket(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(
            @PathVariable Long id) {

        ticketService.deleteTicket(id);

        return ResponseEntity.noContent().build();
    }
}