package com.example.shop.service.impl;

import com.example.shop.dto.ShopDTO;
import com.example.shop.entity.Shop;
import com.example.shop.repository.ShopRepository;
import com.example.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }


    @Override
    public boolean shopSaving(ShopDTO request) {

        try {
            Shop shop = new Shop();

            shop.setName(request.getName());
            shop.setLocation(request.getLocation());

            shopRepository.save(shop);
        }catch (Exception ex){
            throw new RuntimeException("Exception in ShopSaving()",ex);
        }

        return true;
    }
}
