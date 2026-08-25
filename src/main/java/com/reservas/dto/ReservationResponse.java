package com.reservas.dto;

import java.time.LocalDateTime;

public class ReservationResponse {
    private Long id;
    private Long eventId;
    private String eventName;
    private String cpf;
    private String status;
    private LocalDateTime createdAt;
    private String paymentStatus;

    public ReservationResponse() {
    }

    public ReservationResponse(Long id, Long eventId, String eventName, String cpf, String status, LocalDateTime createdAt, String paymentStatus) {
        this.id = id;
        this.eventId = eventId;
        this.eventName = eventName;
        this.cpf = cpf;
        this.status = status;
        this.createdAt = createdAt;
        this.paymentStatus = paymentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
