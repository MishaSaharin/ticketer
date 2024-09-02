package com.saccharine.ticketer.util;

import com.saccharine.ticketer.model.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TicketsWrapperTest {

    @Test
    public void testTicketsWrapperNonEmptyList() {
        List<Ticket> tickets = Arrays.asList(
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
                new Ticket("VVO",
                        "Владивосток",
                        "TLV",
                        "Тель-Авив",
                        "13.05.18",
                        "17:20",
                        "13.05.18",
                        "23:50",
                        "S7",
                        1,
                        13100)
        );
        TicketsWrapper wrapper = new TicketsWrapper(tickets);
        Assertions.assertNotNull(wrapper.getTickets(), "This can't be null");
        Assertions.assertEquals(
                2,
                wrapper.getTickets().size(),
                "The number of tickets must match the number of transferred objects");
    }

    @Test
    public void testTicketsWrapperEmptyList() {
        List<Ticket> emptyTickets = Collections.emptyList();
        TicketsWrapper wrapper = new TicketsWrapper(emptyTickets);
        Assertions.assertNotNull(wrapper.getTickets(), "This can't be null");
        Assertions.assertTrue(wrapper.getTickets().isEmpty(), "The ticket list must be empty");
    }

    @Test
    public void testTicketsWrapperNullList() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new TicketsWrapper(null);
        }, "NullPointerException expected when passing null to constructor");
    }

    @Test
    public void testGetTickets() {
        List<Ticket> tickets = List.of(
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
                        12400)
        );
        TicketsWrapper wrapper = new TicketsWrapper(tickets);
        List<Ticket> retrievedTickets = wrapper.getTickets();
        Assertions.assertEquals(
                tickets,
                retrievedTickets,
                "The returned list of tickets must match the original one");
    }
}