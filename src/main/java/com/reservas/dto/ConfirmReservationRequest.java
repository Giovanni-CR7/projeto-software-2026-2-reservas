package com.reservas.dto;

public class ConfirmReservationRequest {
    private String paymentType;
    private String paymentData;

    public ConfirmReservationRequest() {
    }

    public ConfirmReservationRequest(String paymentType, String paymentData) {
        this.paymentType = paymentType;
        this.paymentData = paymentData;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(String paymentData) {
        this.paymentData = paymentData;
    }
}
