package com.example.shop.repository;

import com.example.shop.entity.InvoiceLineItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceLineItemRepository extends JpaRepository<InvoiceLineItem,Long> {
}
