package com.saccharine.ticketer;

import com.saccharine.ticketer.model.Ticket;
import com.saccharine.ticketer.repository.TicketFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

public class TicketAnalyzerTest {

    private String testFilePath;
    private String invalidTestFilePath;
    private String emptyTestFilePath;

    @BeforeEach
    public void setUp() {
        testFilePath = Paths.get("resources", "test-tickets.json").toString();
        invalidTestFilePath = Paths.get("resources", "invalid-tickets.json").toString();
        emptyTestFilePath = Paths.get("resources", "empty-tickets.json").toString();
    }

    @Test
    public void testReadTicketsSuccess() {
        TicketFileReader reader = new TicketFileReader();
        List<Ticket> tickets = reader.readTickets(testFilePath);
        Assertions.assertNotNull(tickets, "This can't be null");
        Assertions.assertFalse(tickets.isEmpty(), "This can't be empty");
        Assertions.assertEquals(
                2,
                tickets.size(),
                "There are two tickets expected on the list");
    }

    @Test
    public void testReadTicketsEmptyFile() {
        TicketFileReader reader = new TicketFileReader();
        List<Ticket> tickets = reader.readTickets(emptyTestFilePath);
        Assertions.assertNotNull(tickets, "This can't be null");
        Assertions.assertTrue(tickets.isEmpty(), "This can't be empty");
    }

    @Test
    public void testReadTicketsInvalidJson() {
        TicketFileReader reader = new TicketFileReader();
        List<Ticket> tickets = reader.readTickets(invalidTestFilePath);
        Assertions.assertNull(tickets, "This can't be null");
    }
}