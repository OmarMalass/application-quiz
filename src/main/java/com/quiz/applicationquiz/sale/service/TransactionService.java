package com.quiz.applicationquiz.sale.service;


import com.quiz.applicationquiz.product.Product;
import com.quiz.applicationquiz.product.ProductService;
import com.quiz.applicationquiz.sale.controller.dto.TransactionDTO;
import com.quiz.applicationquiz.sale.model.Sale;
import com.quiz.applicationquiz.sale.model.Transaction;
import com.quiz.applicationquiz.sale.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private SaleService saleService;

    @Autowired
    private ProductService productService;

    public Transaction createFormDTO(TransactionDTO transactionDTO) {
        Sale sale = saleService.getSale(transactionDTO.getSaleID());
        Product product = productService.getProduct(transactionDTO.getProductID());
        Transaction transaction =
                new Transaction()
                        .setSale(sale)
                        .setProduct(product)
                        .setQuantity(transactionDTO.getQuantity())
                        .setUnitPrice(transactionDTO.getUnitPrice());

        repository.save(transaction);
        sale.getTransactions().add(transaction);
        saleService.update(sale);
        return transaction;
    }

    public Transaction getByID(long id) {
        return repository.getOne(id);
    }

    public boolean deleteByID(long ID) {
        if (repository.existsById(ID)) {
            repository.deleteById(ID);
            return true;
        }
        return false;
    }
}
