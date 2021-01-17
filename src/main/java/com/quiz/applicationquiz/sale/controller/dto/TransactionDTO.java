package com.quiz.applicationquiz.sale.controller.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.quiz.applicationquiz.sale.model.Sale;
import com.quiz.applicationquiz.sale.model.Transaction;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TransactionDTO {

    @JsonProperty("id")
    private long ID;

    private int quantity;

    @JsonProperty("unit_price")
    private double unitPrice;

    @JsonProperty("sale_id")
    private long saleID;

    @JsonProperty("product_id")
    private long productID;

    @JsonProperty("created_at")
    private Date createdAt;

    public TransactionDTO(Transaction transaction) {
        ID = transaction.getID();
        quantity = transaction.getQuantity();
        unitPrice = transaction.getUnitPrice();
        saleID = transaction.getSale().getID();
        productID = transaction.getProduct().getID();
        createdAt = transaction.getCreatedAt();
    }
}
