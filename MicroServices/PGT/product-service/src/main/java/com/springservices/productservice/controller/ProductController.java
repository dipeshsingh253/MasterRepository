package com.springservices.productservice.controller;

import com.springservices.productservice.dto.ProductRequest;
import com.springservices.productservice.dto.ProductResponse;
import com.springservices.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;
    @PostMapping("/")
    @ResponseStatus(CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }


}
