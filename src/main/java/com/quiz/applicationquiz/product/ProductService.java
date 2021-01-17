package com.quiz.applicationquiz.product;

import com.quiz.applicationquiz.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product create(Product product) {
        return repository.save(product);
    }

    private void updateNonNull(Product product, ProductDTO productDTO) {
        if (productDTO.getName() != null)
            product.setName(productDTO.getName());
        if (productDTO.getCategory() != null)
            product.setCategory(productDTO.getCategory());
        if (productDTO.getDescription() != null)
            product.setDescription(productDTO.getDescription());
    }

    public Product update(ProductDTO productDTO) {
        Product product = repository.findById(productDTO.getID()).orElse(null);
        if (product != null) {
            updateNonNull(product, productDTO);
            repository.save(product);
        }
        return product;
    }

    public Product getProduct(long productID) {
        return repository.getOne(productID);
    }
}