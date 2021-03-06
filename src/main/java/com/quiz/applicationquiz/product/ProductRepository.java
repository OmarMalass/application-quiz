package com.quiz.applicationquiz.product;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    <S extends Product> boolean exists(Example<S> example);
}