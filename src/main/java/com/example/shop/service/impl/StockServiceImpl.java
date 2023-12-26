package com.example.shop.service.impl;

import com.example.shop.dto.StockDTO;
import com.example.shop.entity.Product;
import com.example.shop.entity.Shop;
import com.example.shop.entity.Stock;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.ShopRepository;
import com.example.shop.repository.StockRepository;
import com.example.shop.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository,
                            ProductRepository productRepository,
                            ShopRepository shopRepository) {
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
        this.shopRepository = shopRepository;
    }


    @Override
    public boolean stockSaving(StockDTO request) {

        try {

            Stock stock = new Stock();

            stock.setProduct(getProductId(request.getProductId()));
            stock.setShop(getShopId(request.getShopId()));
            stock.setCount(request.getCount());

            stockRepository.save(stock);
            
        }catch (Exception ex){
            throw new RuntimeException("Exception in StockSaving()",ex);
        }

        return true;
    }

    private Shop getShopId(Long shopId) {

        Optional<Shop> optionalShop = shopRepository.findById(shopId);

        if (optionalShop.isPresent()){

            Shop shop = optionalShop.get();

            return shop;
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
