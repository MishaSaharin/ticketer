package com.saccharine.ticketer.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.saccharine.ticketer.model.Ticket;
import org.apache.log4j.Logger;

import java.util.List;

public class TicketsWrapper {
    public static final Logger LOGGER = Logger.getLogger(TicketsWrapper.class);
    private final List<Ticket> tickets;

    public TicketsWrapper(@JsonProperty("tickets") List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        LOGGER.info("Total number of tickets: " + tickets.size());
        return tickets;
    }
}