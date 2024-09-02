package com.saccharine.ticketer;

import com.saccharine.ticketer.model.Ticket;
import com.saccharine.ticketer.repository.TicketFileReader;
import com.saccharine.ticketer.service.TicketProcessor;
import org.apache.log4j.Logger;

import java.util.List;

public class TicketAnalyzer {
    public static final Logger LOGGER = Logger.getLogger(TicketAnalyzer.class);

    public static void main(String[] args) {
        // Specify the path to your file tickets.json
        String filePath = "src/main/resources/tickets.json";
        TicketFileReader fileReader = new TicketFileReader();
        List<Ticket> tickets = fileReader.readTickets(filePath);
        TicketProcessor processor = new TicketProcessor(tickets);
        processor.processTickets();
        LOGGER.info("All tickets processed successfully");
    }
}