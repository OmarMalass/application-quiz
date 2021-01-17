package com.quiz.applicationquiz.employee.dto;

import com.quiz.applicationquiz.employee.Salesperson;
import com.quiz.applicationquiz.sale.model.Sale;
import com.quiz.applicationquiz.sale.model.Transaction;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

public class SalespersonDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long ID;

    String name;

    @Column(name = "last_name")
    String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "salesperson")
    List<Long> sales;

    public SalespersonDTO(Salesperson entity) {
        ID = entity.getID();
        name = entity.getName();
        lastName = entity.getLastName();
        sales = entity.getSales().stream().map(Sale::getID).collect(Collectors.toList());
    }
}
