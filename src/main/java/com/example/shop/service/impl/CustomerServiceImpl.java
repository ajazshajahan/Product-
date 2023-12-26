package com.example.shop.service.impl;

import com.example.shop.dto.CustomerDTO;
import com.example.shop.entity.Customer;
import com.example.shop.repository.CustomerRepository;
import com.example.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public boolean customerSaving(CustomerDTO request) {

        try {
            Customer customer = new Customer();

            customer.setName(request.getName());
            customer.setPhoneNumber(request.getPhoneNumber());

            customerRepository.save(customer);
        }catch (Exception ex){
            throw new RuntimeException("Exception in CustomerSaving()",ex);
        }

        return true;
    }
}
