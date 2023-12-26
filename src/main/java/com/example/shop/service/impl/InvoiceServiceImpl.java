package com.example.shop.service.impl;

import com.example.shop.dto.InvoiceDTO;
import com.example.shop.dto.InvoiceLineItemDTO;
import com.example.shop.entity.*;
import com.example.shop.repository.*;
import com.example.shop.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final ShopRepository shopRepository;

    private final InvoiceLineItemRepository invoiceLineItemRepository;


    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository,
                              ProductRepository productRepository,
                              CustomerRepository customerRepository,
                              ShopRepository shopRepository,
                              InvoiceLineItemRepository invoiceLineItemRepository) {
        this.invoiceRepository = invoiceRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.shopRepository = shopRepository;
        this.invoiceLineItemRepository = invoiceLineItemRepository;
    }


    @Override
    public boolean saveInvoice(InvoiceDTO request) {


        try {
            Invoice invoice = new Invoice();

            invoice.setSubject(request.getSubject());
            invoice.setStatus(request.getStatus());
            invoice.setDateAndTime(LocalDateTime.now());
            invoice.setInvoiceLineItems(getLineItems(request.getLineItems()));
            invoice.setAmount(getAmount(request.getLineItems()));

            invoiceRepository.save(invoice);
        }catch (Exception ex){
            throw new RuntimeException("Exception in SaveInvoice()",ex);
        }

        return true;
    }

    private double getAmount(List<InvoiceLineItemDTO> lineItems) {


        double total = lineItems.stream()
                .mapToDouble(InvoiceLineItemDTO::getAmount)
                .sum();

        return total;
    }


    private List<InvoiceLineItem> getLineItems(List<InvoiceLineItemDTO> lineItems) {

        List<InvoiceLineItem> invoiceLineItems = new ArrayList<>();

        for (InvoiceLineItemDTO invoiceLineItemDTO : lineItems){

            InvoiceLineItem invoiceLineItem = new InvoiceLineItem();

            invoiceLineItem.setProduct(getProductId(invoiceLineItemDTO.getProductId()));
            invoiceLineItem.setCustomer(getCustomerId(invoiceLineItemDTO.getCustomerId()));
            invoiceLineItem.setShop(getShopId(invoiceLineItemDTO.getShopId()));
            invoiceLineItem.setAmount(invoiceLineItemDTO.getAmount());

            invoiceLineItemRepository.save(invoiceLineItem);

            invoiceLineItems.add(invoiceLineItem);

        }

        return invoiceLineItems;
    }

    private Shop getShopId(Long shopId) {

        Optional<Shop> optionalShop = shopRepository.findById(shopId);

        if (optionalShop.isPresent()){

            Shop  shop = optionalShop.get();

            return shop;
        }

        return null;
    }

    private Customer getCustomerId(Long customerId) {

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isPresent()){

            Customer customer = optionalCustomer.get();

            return customer;
        }

        return null;
    }

    private Product getProductId(Long productId) {

        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()){

            Product product = optionalProduct.get();

            return product;
        }

        return null;
    }
}
