package com.example.shop.service;

import com.example.shop.dto.InvoiceDTO;

public interface InvoiceService {
    boolean saveInvoice(InvoiceDTO request);
}
