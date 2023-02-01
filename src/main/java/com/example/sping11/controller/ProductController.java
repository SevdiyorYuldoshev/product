package com.example.sping11.controller;

import com.example.sping11.entity.Product;
import com.example.sping11.entity.ResponseDto;
import com.example.sping11.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;


    @PostMapping
    public ResponseDto<Void> saveProduct(@RequestBody Product product){
        return service.add(product);
    }

    @GetMapping("/{id}")
    ResponseDto<Product> get(@PathVariable Integer id){
        return service.getById(id);
    }
}
