package com.reservas.dto;

import java.time.LocalDateTime;

public class CreateEventRequest {
    private String name;
    private LocalDateTime eventDate;
    private Integer totalTickets;
    private Double price;

    public CreateEventRequest() {
    }

    public CreateEventRequest(String name, LocalDateTime eventDate, Integer totalTickets, Double price) {
        this.name = name;
        this.eventDate = eventDate;
        this.totalTickets = totalTickets;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(Integer totalTickets) {
        this.totalTickets = totalTickets;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
