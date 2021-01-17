package com.quiz.applicationquiz.employee;

import com.quiz.applicationquiz.sale.model.Sale;
import com.quiz.applicationquiz.sale.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SALESPERSON")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salesperson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long ID;

    String name;

    @Column(name = "last_name")
    String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "salesperson")
    List<Sale> sales = new ArrayList<>();
}
