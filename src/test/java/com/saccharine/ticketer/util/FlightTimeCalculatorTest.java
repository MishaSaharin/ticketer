package com.saccharine.ticketer.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FlightTimeCalculatorTest {

    @Test
    public void testCalculateFlightTimeStandardCase() {
        long flightTime = FlightTimeCalculator.calculateFlightTime("16:20", "22:10");
        Assertions.assertEquals(
                350,
                flightTime,
                "The expected flight time should be 350 minutes");
    }

    @Test
    public void testCalculateFlightTimeCrossMidnight() {
        long flightTime = FlightTimeCalculator.calculateFlightTime("23:50", "01:20");
        Assertions.assertEquals(
                90,
                flightTime,
                "The expected flight time should be 90 minutes, even if crossing midnight");
    }

    @Test
    public void testCalculateFlightTimeZeroDuration() {
        long flightTime = FlightTimeCalculator.calculateFlightTime("10:00", "10:00");
        Assertions.assertEquals(
                0,
                flightTime,
                "The expected flight time should be 0 minutes with the same departure and arrival times");
    }

    @Test
    public void testCalculateFlightTimeNegativeDuration() {
        long flightTime = FlightTimeCalculator.calculateFlightTime("10:00", "09:50");
        Assertions.assertEquals(
                -10,
                flightTime,
                "Flight time must be negative if the arrival time is less than the departure time");
    }

    @Test
    public void testCalculateFlightTimeInvalidTimeFormat() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            FlightTimeCalculator.calculateFlightTime("10:00", "invalid");
        }, "NumberFormatException expected if time format is invalid");
    }

    @Test
    public void testCalculateFlightTimeInvalidTimeFormatBadFormat() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            FlightTimeCalculator.calculateFlightTime("10:00", "10");
        }, "ArrayIndexOutOfBoundsException expected if time format is invalid (invalid time format)");
    }
}