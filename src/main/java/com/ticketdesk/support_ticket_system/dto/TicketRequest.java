package com.ticketdesk.support_ticket_system.dto;

import com.ticketdesk.support_ticket_system.enums.TicketPriority;
import com.ticketdesk.support_ticket_system.enums.TicketStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TicketRequest {

    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 100,
            message = "Title must be between 5 and 100 characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(min = 10, max = 500,
            message = "Description must be between 10 and 500 characters")
    private String description;

    @NotNull(message = "Status is required")
    private TicketStatus status;

    @NotNull(message = "Priority is required")
    private TicketPriority priority;

    public TicketRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public void setPriority(TicketPriority priority) {
        this.priority = priority;
    }
}