package com.quiz.applicationquiz.product;

import com.quiz.applicationquiz.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/all")
    public List<ProductDTO> fetchAll() {
        return service.findAll().stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/add")
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        Product product = service.create(productDTO.toEntity());
        return new ProductDTO(product);
    }

    @PostMapping("/update")
    public ProductDTO update(@RequestBody ProductDTO productDTO) {
        Product product = service.update(productDTO);
        return new ProductDTO(product);
    }
}