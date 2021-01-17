package com.quiz.applicationquiz.sale.model;

import com.quiz.applicationquiz.client.Client;
import com.quiz.applicationquiz.employee.Salesperson;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SALE")
@Data
@Accessors(chain = true)
public class Sale {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salesperson_id")
    private Salesperson salesperson;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sale")
    private List<Transaction> transactions = new ArrayList<>();

    public double getTotal() {
        return transactions.stream().mapToDouble(transaction ->
                transaction.getQuantity() * transaction.getUnitPrice()
        ).sum();
    }
}
