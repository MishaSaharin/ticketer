package com.saccharine.ticketer.repository;

import com.saccharine.ticketer.model.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

public class TicketFileReaderTest {

    private static final String RESOURCES_PATH = Paths.get("resources").toString();

    @Test
    public void testReadTicketsSuccess() {
        String filePath = Paths.get(RESOURCES_PATH, "test-tickets.json").toString();
        TicketFileReader reader = new TicketFileReader();
        List<Ticket> tickets = reader.readTickets(filePath);
        Assertions.assertNotNull(tickets, "Ticket list must not be null");
        Assertions.assertEquals(2, tickets.size(), "2 tickets must be counted");
        Ticket firstTicket = tickets.get(0);
        Assertions.assertEquals("VVO", firstTicket.getOrigin(), "The departure point of the first ticket must be 'VVO'");
        Assertions.assertEquals("TK", firstTicket.getCarrier(), "The carrier of the first ticket must be 'TK'");
        Assertions.assertEquals(12400, firstTicket.getPrice(), "The price of the first ticket should be 12400");
    }

    @Test
    public void testReadTicketsFileNotFound() {
        String filePath = Paths.get(RESOURCES_PATH, "nonexistent.json").toString();
        TicketFileReader reader = new TicketFileReader();
        List<Ticket> tickets = reader.readTickets(filePath);
        Assertions.assertNull(tickets, "The ticket list must be null");

    }

    @Test
    public void testReadTicketsInvalidJson() {
        String filePath = Paths.get(RESOURCES_PATH, "invalid-invalid-tickets.json").toString();
        TicketFileReader reader = new TicketFileReader();
        List<Ticket> tickets = reader.readTickets(filePath);
        Assertions.assertNull(tickets, "The ticket list must be null");
    }
}