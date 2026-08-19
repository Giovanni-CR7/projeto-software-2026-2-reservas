package com.reservas.dto;

import java.time.LocalDateTime;

public class CreateReservationResponse {
    private Long id;
    private String status;
    private String cpf;
    private Long eventId;
    private LocalDateTime createdAt;

    public CreateReservationResponse() {
    }

    public CreateReservationResponse(Long id, String status, String cpf, Long eventId, LocalDateTime createdAt) {
        this.id = id;
        this.status = status;
        this.cpf = cpf;
        this.eventId = eventId;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
