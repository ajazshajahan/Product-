package com.example.shop.service.impl;

import com.example.shop.dto.ProductDTO;
import com.example.shop.entity.Product;
import com.example.shop.repository.ProductRepository;
import com.example.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean productSaving(ProductDTO request) {

        try {
            Product product = new Product();

            product.setName(request.getName());
            product.setPrize(request.getPrize());

            productRepository.save(product);
        }catch (Exception ex){
            throw new RuntimeException("Exception in ProductSaving()",ex);
        }

        return true;
    }
}
