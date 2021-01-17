package com.quiz.applicationquiz.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalespersonRepository extends JpaRepository<Salesperson, Long> {
}
