package com.quiz.applicationquiz.sale.service;


import com.quiz.applicationquiz.client.Client;
import com.quiz.applicationquiz.client.ClientRepository;
import com.quiz.applicationquiz.employee.Salesperson;
import com.quiz.applicationquiz.employee.SalespersonRepository;
import com.quiz.applicationquiz.sale.controller.dto.SaleDTO;
import com.quiz.applicationquiz.sale.model.Sale;
import com.quiz.applicationquiz.sale.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SalespersonRepository salespersonRepository;

    public List<Sale> fetchAll() {
        return repository.findAll();
    }

    public Sale createFromDTO(SaleDTO saleDTO) {
        Client client = clientRepository.getOne(saleDTO.getClientID());
        Salesperson salesperson = salespersonRepository.getOne(saleDTO.getSalespersonID());
        Sale sale = new Sale()
                .setClient(client)
                .setSalesperson(salesperson);
        return create(sale);
    }

    public Sale create(Sale sale) {
        return repository.save(sale);
    }


    public Sale getSale(long saleID) {
        return repository.getOne(saleID);
    }

    public Sale update(Sale sale) {
        if (repository.existsById(sale.getID())) repository.save(sale);
        return sale;
    }
}
