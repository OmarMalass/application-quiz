package com.quiz.applicationquiz.sale.controller;

import com.quiz.applicationquiz.sale.controller.dto.TransactionDTO;
import com.quiz.applicationquiz.sale.model.Transaction;
import com.quiz.applicationquiz.sale.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {


    @Autowired
    private TransactionService service;

    @GetMapping("/{ID}")
    public TransactionDTO get(@PathVariable long ID) {
        return new TransactionDTO(service.getByID(ID));
    }

    @PostMapping("/create")
    public TransactionDTO create(@RequestBody TransactionDTO transactionDTO) {
        Transaction transaction = service.createFormDTO(transactionDTO);
        return new TransactionDTO(transaction);
    }


    @DeleteMapping("/delete/{ID}")
    public boolean delete(@PathVariable long ID) {
        return service.deleteByID(ID);
    }
}
