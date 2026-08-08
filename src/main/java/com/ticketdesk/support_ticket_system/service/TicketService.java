package com.ticketdesk.support_ticket_system.service;

import com.ticketdesk.support_ticket_system.dto.TicketRequest;
import com.ticketdesk.support_ticket_system.dto.TicketResponse;
import com.ticketdesk.support_ticket_system.exception.TicketNotFoundException;
import com.ticketdesk.support_ticket_system.model.Ticket;
import com.ticketdesk.support_ticket_system.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    
    public List<TicketResponse> getTickets() {

        return ticketRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public TicketResponse createTicket(TicketRequest request) {

        Ticket ticket = new Ticket();

        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setStatus(request.getStatus());
        ticket.setPriority(request.getPriority());

        Ticket savedTicket = ticketRepository.save(ticket);

        return mapToResponse(savedTicket);
    }

    public TicketResponse getTicketById(Long id) {
         Ticket ticket = ticketRepository.findById(id)
            .orElseThrow(() -> new TicketNotFoundException(id));

        return mapToResponse(ticket);
    }
        
    public TicketResponse updateTicket(Long id, TicketRequest request) {

        Ticket ticket = ticketRepository.findById(id)
        .orElseThrow(() -> new TicketNotFoundException(id));

        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setStatus(request.getStatus());
        ticket.setPriority(request.getPriority());

        Ticket updatedTicket = ticketRepository.save(ticket);

        return mapToResponse(updatedTicket);
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
                ticket.getStatus(),
                ticket.getPriority()
        );
    }
}