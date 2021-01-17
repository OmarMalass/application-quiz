package com.quiz.applicationquiz.client.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.quiz.applicationquiz.client.Client;
import com.quiz.applicationquiz.sale.model.Sale;
import com.quiz.applicationquiz.sale.model.Transaction;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ClientDTO {


    @JsonProperty("id")
    private long ID;

    private String name;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("mobile_number")
    private String mobileNumber;

    private List<Long> purchases;

    public ClientDTO(Client client) {
        ID = client.getID();
        name = client.getName();
        lastName = client.getLastName();
        mobileNumber = client.getMobileNumber();
        purchases = client.getPurchases().stream().map(Sale::getID).collect(Collectors.toList());
    }

    public Client toEntity() {
        return new Client(ID, name, lastName, mobileNumber, new ArrayList<Sale>());
    }

}
