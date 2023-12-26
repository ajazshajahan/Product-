package com.example.shop.controller;

import com.example.shop.dto.StockDTO;
import com.example.shop.service.StockService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StockController {


    private final StockService stockservice;

    @Autowired
    public StockController(StockService stockservice) {
        this.stockservice = stockservice;
    }

    @PostMapping("/stock")
    public boolean saveStock(@RequestBody @Valid StockDTO request){
        return stockservice.stockSaving(request);
    }
}
