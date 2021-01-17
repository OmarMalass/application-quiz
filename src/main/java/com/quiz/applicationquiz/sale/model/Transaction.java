package com.quiz.applicationquiz.sale.model;

import com.quiz.applicationquiz.client.Client;
import com.quiz.applicationquiz.employee.Salesperson;
import com.quiz.applicationquiz.product.Product;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Table(name = "TRANSACTION")
@Entity
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long ID;

    @Column(name = "unit_price")
    private double unitPrice;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @Override
    public String toString() {
        return "Transaction={ID: " + ID + ", productID:" + product.getID() + ", quantity: " + quantity + ", unitPrice: " + unitPrice + "saleID: " + sale.getID() + "}";
    }
}