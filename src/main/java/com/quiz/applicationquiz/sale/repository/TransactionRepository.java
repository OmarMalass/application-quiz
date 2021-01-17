package com.quiz.applicationquiz.sale.repository;

import com.quiz.applicationquiz.sale.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
