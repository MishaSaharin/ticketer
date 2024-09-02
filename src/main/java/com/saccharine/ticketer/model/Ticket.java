package com.saccharine.ticketer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.log4j.Logger;

public class Ticket {
    public static final Logger LOGGER = Logger.getLogger(Ticket.class);
    private final String origin;
    private final String originName;
    private final String destination;
    private final String destinationName;
    private final String departureDate;
    private final String departureTime;
    private final String arrivalDate;
    private final String arrivalTime;
    private final String carrier;
    private final int stops;
    private final int price;

    public Ticket(
            @JsonProperty("origin") String origin,
            @JsonProperty("origin_name") String originName,
            @JsonProperty("destination") String destination,
            @JsonProperty("destination_name") String destinationName,
            @JsonProperty("departure_date") String departureDate,
            @JsonProperty("departure_time") String departureTime,
            @JsonProperty("arrival_date") String arrivalDate,
            @JsonProperty("arrival_time") String arrivalTime,
            @JsonProperty("carrier") String carrier,
            @JsonProperty("stops") int stops,
            @JsonProperty("price") int price) {
        this.origin = origin;
        this.originName = originName;
        this.destination = destination;
        this.destinationName = destinationName;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.carrier = carrier;
        this.stops = stops;
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getCarrier() {
        return carrier;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getPrice() {
        return price;
    }
}