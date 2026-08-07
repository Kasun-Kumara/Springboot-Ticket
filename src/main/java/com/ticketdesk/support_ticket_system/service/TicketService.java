package com.ticketdesk.support_ticket_system.service;

import com.ticketdesk.support_ticket_system.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    private List<Ticket> tickets = new ArrayList<>();
    public List<Ticket> getTickets(){
        return tickets;
    }
    public Ticket createTicket(Ticket ticket) {
        tickets.add(ticket);
        return ticket;
    }
    public Ticket getTicketById(Long id) {
        for (Ticket ticket : tickets){
            if(ticket.getId().equals(id)){
                return ticket;
            }
        }
        return null;
    }
    public Ticket updateTicket(Long id, Ticket updatedTicket) {

        for (Ticket ticket : tickets) {

            if (ticket.getId().equals(id)) {

                ticket.setTitle(updatedTicket.getTitle());
                ticket.setDescription(updatedTicket.getDescription());
                ticket.setStatus(updatedTicket.getStatus());

                return ticket;
            }
        }

        return null;
    }
}