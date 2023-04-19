package com.sparta.myselectshopbeta.service;

import com.sparta.myselectshopbeta.dto.ProductMypriceRequestDto;
import com.sparta.myselectshopbeta.dto.ProductRequestDto;
import com.sparta.myselectshopbeta.dto.ProductResponseDto;
import com.sparta.myselectshopbeta.entity.Product;
import com.sparta.myselectshopbeta.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDto createProduct(ProductRequestDto requestDto) throws SQLException {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto);

        return  productRepository.createProduct(product);
    }

    public List<ProductResponseDto> getProducts() throws SQLException {

        return productRepository.getProducts();
    }

    public Long updateProduct(Long id, ProductMypriceRequestDto requestDto) throws SQLException {
        Product product = productRepository.getProduct(id);

        if(product == null) {
            throw new NullPointerException("해당 상품은 존재하지 않습니다.");
        }

        return productRepository.updateProduct(product.getId(), requestDto);
    }

}