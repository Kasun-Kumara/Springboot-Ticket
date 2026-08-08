package com.ticketdesk.support_ticket_system.service;

import com.ticketdesk.support_ticket_system.exception.TicketNotFoundException;
import com.ticketdesk.support_ticket_system.model.Ticket;
import org.springframework.stereotype.Service;
import com.ticketdesk.support_ticket_system.repository.TicketRepository;
import com.ticketdesk.support_ticket_system.dto.TicketRequest;
import com.ticketdesk.support_ticket_system.dto.TicketResponse;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    
    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    public TicketResponse createTicket(TicketRequest request) {

        Ticket ticket = new Ticket();

        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setStatus(request.getStatus());

        Ticket savedTicket = ticketRepository.save(ticket);

        return mapToResponse(savedTicket);
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));
    }
        
    public Ticket updateTicket(Long id, Ticket updatedTicket) {

        Ticket ticket = ticketRepository.findById(id)
        .orElseThrow(() -> new TicketNotFoundException(id));

        ticket.setTitle(updatedTicket.getTitle());
        ticket.setDescription(updatedTicket.getDescription());
        ticket.setStatus(updatedTicket.getStatus());

        return ticketRepository.save(ticket);
    }
    
    public void deleteTicket(Long id) {

        if (!ticketRepository.existsById(id)) {
            throw new TicketNotFoundException(id);
        }

        ticketRepository.deleteById(id);
    }

    private TicketResponse mapToResponse(Ticket ticket) {

        return new TicketResponse(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getStatus()
        );
    }
}