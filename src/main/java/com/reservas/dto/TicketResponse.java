package com.reservas.dto;

import java.time.LocalDateTime;

public class TicketResponse {
    private Long id;
    private String cpf;
    private String eventName;
    private LocalDateTime eventDate;
    private Double price;
    private LocalDateTime confirmedAt;

    public TicketResponse() {
    }

    public TicketResponse(Long id, String cpf, String eventName, LocalDateTime eventDate, Double price, LocalDateTime confirmedAt) {
        this.id = id;
        this.cpf = cpf;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.price = price;
        this.confirmedAt = confirmedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(LocalDateTime confirmedAt) {
        this.confirmedAt = confirmedAt;
    }
}
