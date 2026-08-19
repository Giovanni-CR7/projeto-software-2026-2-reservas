package com.reservas.dto;

public class CreateReservationRequest {
    private String cpf;

    public CreateReservationRequest() {
    }

    public CreateReservationRequest(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
