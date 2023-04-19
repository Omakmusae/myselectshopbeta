package com.sparta.myselectshopbeta.repository;

import com.sparta.myselectshopbeta.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}