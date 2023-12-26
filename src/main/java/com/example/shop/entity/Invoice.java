package com.example.shop.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Table
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column
    private String subject;

    @Column
    private String status;

    @Column
    private double amount;

    @Column
    private LocalDateTime dateAndTime;

    @ManyToMany
    private List<InvoiceLineItem> invoiceLineItems;

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

    public List<InvoiceLineItem> getInvoiceLineItems() {
        return invoiceLineItems;
    }

    public void setInvoiceLineItems(List<InvoiceLineItem> invoiceLineItems) {
        this.invoiceLineItems = invoiceLineItems;
    }
}
