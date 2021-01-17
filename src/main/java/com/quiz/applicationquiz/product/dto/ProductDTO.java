package com.quiz.applicationquiz.product.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.quiz.applicationquiz.product.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
public class ProductDTO {

    @JsonProperty(value = "id")
    long ID;

    private String name;

    private String description;

    private String category;

    @JsonProperty("created_at")
    Date createdAt;

    public ProductDTO(Product product){
        ID = product.getID();
        name = product.getName();
        description = product.getDescription();
        category = product.getCategory();
        createdAt = product.getCreatedAt();
    }

    public Product toEntity(){
        return new Product(ID, name, description, category, new ArrayList<>(), createdAt);
    }
}
