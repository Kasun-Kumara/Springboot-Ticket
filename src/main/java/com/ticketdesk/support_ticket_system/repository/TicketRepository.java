package com.ticketdesk.support_ticket_system.repository;

import com.ticketdesk.support_ticket_system.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}