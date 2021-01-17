package com.quiz.applicationquiz.sale.controller.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.quiz.applicationquiz.sale.model.Sale;
import com.quiz.applicationquiz.sale.model.Transaction;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class SaleDTO {

    @JsonProperty("id")
    private long ID;

    private double total;

    @JsonProperty("salesperson_id")
    private long salespersonID;

    @JsonProperty("client_id")
    private long clientID;

    @JsonProperty
    private List<Long> transactions;

    public SaleDTO(Sale sale) {
        ID = sale.getID();
        total = sale.getTotal();
        salespersonID = sale.getSalesperson().getID();
        clientID = sale.getClient().getID();
        transactions = sale.getTransactions().stream().map(Transaction::getID).collect(Collectors.toList());
    }
}
