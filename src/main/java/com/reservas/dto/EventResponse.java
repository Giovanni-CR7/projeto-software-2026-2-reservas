package com.reservas.dto;

import java.time.LocalDateTime;

public class EventResponse {
    private Long id;
    private String name;
    private LocalDateTime eventDate;
    private Integer totalTickets;
    private Integer availableTickets;
    private Double price;

    public EventResponse() {
    }

    public EventResponse(Long id, String name, LocalDateTime eventDate, Integer totalTickets, Integer availableTickets, Double price) {
        this.id = id;
        this.name = name;
        this.eventDate = eventDate;
        this.totalTickets = totalTickets;
        this.availableTickets = availableTickets;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(Integer availableTickets) {
        this.availableTickets = availableTickets;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
