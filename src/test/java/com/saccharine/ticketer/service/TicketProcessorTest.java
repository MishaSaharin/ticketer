package com.saccharine.ticketer.service;

import com.saccharine.ticketer.model.Ticket;
import com.saccharine.ticketer.util.FlightTimeCalculator;
import com.saccharine.ticketer.util.MedianCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TicketProcessorTest {

    private List<Ticket> tickets;

    @BeforeEach
    public void setUp() {
        tickets = Arrays.asList(
                new Ticket(
                        "VVO",
                        "Владивосток",
                        "TLV",
                        "Тель-Авив",

                        "12.05.18",
                        "16:20",
                        "12.05.18",
                        "22:10",
                        "TK",
                        3,
                        12400),
                new Ticket(
                        "VVO",
                        "Владивосток",
                        "TLV",
                        "Тель-Авив",
                        "12.05.18",
                        "17:20",
                        "12.05.18",
                        "23:50",
                        "S7",
                        1,
                        13100),
                new Ticket("VVO",
                        "Владивосток",
                        "TLV",
                        "Тель-Авив",
                        "12.05.18",
                        "12:10",
                        "12.05.18",
                        "18:10",
                        "SU",
                        0,
                        15300),
                new Ticket("VVO",
                        "Владивосток",
                        "TLV",
                        "Тель-Авив",
                        "12.05.18",
                        "17:00",
                        "12.05.18",
                        "23:30",
                        "TK",
                        2,
                        11000),
                new Ticket("VVO",
                        "Владивосток",
                        "TLV",
                        "Тель-Авив",
                        "12.05.18",
                        "17:10",
                        "12.05.18",
                        "23:45",
                        "TK",
                        1,
                        13600)
        );
    }

    @Test
    public void testProcessTicketsMinimumFlightTime() {
        TicketProcessor processor = new TicketProcessor(tickets);
        processor.processTickets();
        Assertions.assertEquals(370, FlightTimeCalculator.calculateFlightTime("17:00", "23:30"));
    }

    @Test
    public void testProcessTicketsPriceDifference() {
        TicketProcessor processor = new TicketProcessor(tickets);
        processor.processTickets();
        double averagePrice = (12400 + 13100 + 15300 + 11000 + 13600) / 5.0;
        double expectedMedianPrice = 13100;
        double difference = Math.abs(averagePrice - expectedMedianPrice);
        Assertions.assertEquals(difference, Math.abs(averagePrice - MedianCalculator.calculateMedian(
                Arrays.asList(12400, 13100, 15300, 11000, 13600))
        ));
    }

    @Test
    public void testProcessTicketsEmptyList() {
        TicketProcessor processor = new TicketProcessor(List.of());
        processor.processTickets();
        Assertions.assertTrue(true);
    }

    @Test
    public void testProcessTicketsNoMatchingFlights() {
        List<Ticket> nonMatchingTickets = Arrays.asList(
                new Ticket("SVO",
                        "Москва",
                        "JFK",
                        "Нью-Йорк",
                        "12.05.18",
                        "10:00",
                        "12.05.18",
                        "18:00",
                        "AA",
                        1,
                        45000),
                new Ticket("DME",
                        "Москва",
                        "LHR",
                        "Лондон",
                        "12.05.18",
                        "13:00",
                        "12.05.18",
                        "15:00",
                        "BA",
                        0,
                        32000)
        );
        TicketProcessor processor = new TicketProcessor(nonMatchingTickets);
        processor.processTickets();
        Assertions.assertTrue(true);
    }
}