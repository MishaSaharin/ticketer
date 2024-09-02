package com.saccharine.ticketer.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saccharine.ticketer.model.Ticket;
import com.saccharine.ticketer.util.TicketsWrapper;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TicketFileReader {
    public static final Logger LOGGER = Logger.getLogger(TicketFileReader.class);

    public List<Ticket> readTickets(String filePath) {
        if (filePath != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Ticket> tickets = null;
            try {
                TicketsWrapper wrapper = objectMapper.readValue(new File(filePath), TicketsWrapper.class);
                tickets = wrapper.getTickets();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (tickets != null) {
                LOGGER.info("The list of tickets has length is " + tickets.size());
            }
            return tickets;
        }
        throw new RuntimeException("File path is null");
    }
}