package com.saccharine.ticketer.service;

import com.saccharine.ticketer.model.Ticket;
import com.saccharine.ticketer.util.FlightTimeCalculator;
import com.saccharine.ticketer.util.MedianCalculator;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TicketProcessor {
    public static final Logger LOGGER = Logger.getLogger(TicketProcessor.class);
    private final List<Ticket> tickets;

    public TicketProcessor(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void processTickets() {
        Map<String, Long> minFlightTime = new HashMap<>();
        List<Integer> prices;
        if (tickets != null) {
            prices = tickets.stream()
                    .filter(ticket -> "VVO".equals(ticket.getOrigin()) && "TLV".equals(ticket.getDestination()))
                    .map(Ticket::getPrice)
                    .collect(Collectors.toList());
            for (Ticket ticket : tickets) {
                if ("VVO".equals(ticket.getOrigin()) && "TLV".equals(ticket.getDestination())) {
                    String carrier = ticket.getCarrier();
                    long flightDuration = FlightTimeCalculator.calculateFlightTime(ticket.getDepartureTime(), ticket.getArrivalTime());
                    minFlightTime.merge(carrier, flightDuration, Math::min);
                }
            }
        } else {
            throw new RuntimeException("Tickets were null");
        }
        LOGGER.info("The minimum flight time: ");
        for (Map.Entry<String, Long> entry : minFlightTime.entrySet()) {
            LOGGER.info("Carrier: " + entry.getKey() + ", The flight time: " + entry.getValue() + " minutes");
        }
        double averagePrice = prices.stream().mapToInt(Integer::intValue).average().orElse(0);
        double medianPrice = MedianCalculator.calculateMedian(prices);
        LOGGER.info("The difference between the average price and the median: " + Math.abs(averagePrice - medianPrice));
    }
}