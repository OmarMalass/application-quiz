package com.quiz.applicationquiz.product;

import com.quiz.applicationquiz.sale.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


@Table(name = "PRODUCT")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private long ID;

    private String name;
    private String description;
    private String category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Transaction> transactions = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;
}
