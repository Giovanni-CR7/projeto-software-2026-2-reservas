package com.reservas.dto;

import java.time.LocalDateTime;

public class ConfirmReservationResponse {
    private Long id;
    private String status;
    private String cpf;
    private String paymentStatus;
    private LocalDateTime confirmedAt;

    public ConfirmReservationResponse() {
    }

    public ConfirmReservationResponse(Long id, String status, String cpf, String paymentStatus, LocalDateTime confirmedAt) {
        this.id = id;
        this.status = status;
        this.cpf = cpf;
        this.paymentStatus = paymentStatus;
        this.confirmedAt = confirmedAt;
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

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(LocalDateTime confirmedAt) {
        this.confirmedAt = confirmedAt;
    }
}
