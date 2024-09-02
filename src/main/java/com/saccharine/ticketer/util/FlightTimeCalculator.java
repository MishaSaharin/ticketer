package com.saccharine.ticketer.util;

import org.apache.log4j.Logger;

public class FlightTimeCalculator {
    public static final Logger LOGGER = Logger.getLogger(FlightTimeCalculator.class);

    public static long calculateFlightTime(String departureTime, String arrivalTime) {
        String[] depParts = departureTime.split(":");
        String[] arrParts = arrivalTime.split(":");
        int depHours = Integer.parseInt(depParts[0]);
        int depMinutes = Integer.parseInt(depParts[1]);
        int arrHours = Integer.parseInt(arrParts[0]);
        int arrMinutes = Integer.parseInt(arrParts[1]);
        LOGGER.info("The results are " + depHours + ": " + depMinutes + ": " + arrHours + ": " + arrMinutes);
        return (arrHours * 60L + arrMinutes) - (depHours * 60L + depMinutes);
    }
}