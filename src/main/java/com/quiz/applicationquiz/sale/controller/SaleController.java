package com.quiz.applicationquiz.sale.controller;


import com.quiz.applicationquiz.sale.service.SaleService;
import com.quiz.applicationquiz.sale.controller.dto.SaleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("sale")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping("/all")
    List<SaleDTO> fetchAll() {
        return service.fetchAll().stream().map(SaleDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/create")
    SaleDTO create(@RequestBody SaleDTO saleDTO) {
        return new SaleDTO(service.createFromDTO(saleDTO));
    }
}
