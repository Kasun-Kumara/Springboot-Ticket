package com.ticketdesk.support_ticket_system.service;

import com.ticketdesk.support_ticket_system.model.Ticket;
import org.springframework.stereotype.Service;
import com.ticketdesk.support_ticket_system.repository.TicketRepository;

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

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }
    
    public Ticket updateTicket(Long id, Ticket updatedTicket) {

        Ticket ticket = ticketRepository.findById(id).orElse(null);

        if (ticket == null) {
            return null;
        }

        ticket.setTitle(updatedTicket.getTitle());
        ticket.setDescription(updatedTicket.getDescription());
        ticket.setStatus(updatedTicket.getStatus());

        return ticketRepository.save(ticket);
    }
    
    public boolean deleteTicket(Long id) {

        if (!ticketRepository.existsById(id)) {
            return false;
        }

        ticketRepository.deleteById(id);

        return true;
}
}