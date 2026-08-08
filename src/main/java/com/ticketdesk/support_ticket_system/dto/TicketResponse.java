package com.ticketdesk.support_ticket_system.dto;
import com.ticketdesk.support_ticket_system.enums.TicketStatus;

import com.ticketdesk.support_ticket_system.enums.TicketPriority;

public class TicketResponse {

    private Long id;
    private String title;
    private String description;
    private TicketStatus status;
    private TicketPriority priority;

    public TicketResponse() {
    }

    public TicketResponse(
            Long id,
            String title,
            String description,
            TicketStatus status,
            TicketPriority priority) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public TicketPriority getPriority() {
        return priority;
    }
}