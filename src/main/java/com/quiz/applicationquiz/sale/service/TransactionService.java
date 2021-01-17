package com.quiz.applicationquiz.sale.service;


import com.quiz.applicationquiz.product.Product;
import com.quiz.applicationquiz.product.ProductService;
import com.quiz.applicationquiz.sale.controller.dto.TransactionDTO;
import com.quiz.applicationquiz.sale.model.Sale;
import com.quiz.applicationquiz.sale.model.Transaction;
import com.quiz.applicationquiz.sale.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    Logger logger = LoggerFactory.getLogger(this.getClass());


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
        logger.info("Created transaction: " + transaction.toString());

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
            logger.info("Deleted transaction: " + ID);
            return true;
        }
        return false;
    }

    private void updateNonNull(Transaction transaction, TransactionDTO transactionDTO) {
        if (transactionDTO.getUnitPrice() != null) transaction.setUnitPrice(transactionDTO.getUnitPrice());
        if (transactionDTO.getQuantity() != null) transaction.setQuantity(transactionDTO.getQuantity());
    }

    public Transaction update(TransactionDTO transactionDTO) {
        Transaction transaction = repository.findById(transactionDTO.getID()).orElse(null);
        if (transaction != null) {
            updateNonNull(transaction, transactionDTO);
            repository.save(transaction);
            logger.info("Updated transaction: " + transaction.toString());
        }
        return transaction;
    }
}
