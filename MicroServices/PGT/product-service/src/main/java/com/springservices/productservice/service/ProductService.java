package com.springservices.productservice.service;


import com.springservices.productservice.dto.ProductRequest;
import com.springservices.productservice.dto.ProductResponse;
import com.springservices.productservice.model.Product;
import com.springservices.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    @Autowired
    private ModelMapper mapper;

    public void createProduct(ProductRequest productRequest){
        Product product = mapper.map(productRequest,Product.class);

        productRepository.save(product);

        log.info("Product is saved with id : {}",product.getName());

    }


    public List<ProductResponse> getAllProducts() {
        log.info("retrieving all the products from data base");

        List<Product> products = productRepository.findAll();

        return products.stream().map(p->mapper.map(p,ProductResponse.class)).toList();
    }
}
