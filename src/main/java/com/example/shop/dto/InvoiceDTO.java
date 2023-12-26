package com.example.shop.dto;

import java.time.LocalDateTime;
import java.util.List;

public class InvoiceDTO {


    private Long id;

    private String subject;

    private String status;

    private double amount;

    private LocalDateTime dateAndTime;
    private List<InvoiceLineItemDTO> lineItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public List<InvoiceLineItemDTO> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<InvoiceLineItemDTO> lineItems) {
        this.lineItems = lineItems;
    }
}
