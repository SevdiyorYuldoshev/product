package com.example.sping11.service;

import com.example.sping11.entity.Product;
import com.example.sping11.entity.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    List<Product> productDTO = new ArrayList<>();

    public ResponseDto<Void> add(Product newDto) {

        if(productDTO.stream().anyMatch(t -> t.getId().equals(newDto.getId()))){
            return ResponseDto.<Void>builder()
                    .code(1)
                    .message("Product ID already exists")
                    .build();
        }

        productDTO.add(newDto);

        return ResponseDto.<Void>builder()
                .success(true)
                .message("OK")
                .build();

    }

    public ResponseDto<Product> getById(Integer id) {

        Optional<Product> optionalProduct = productDTO.stream().filter(t -> t.getId().equals(id)).findFirst();

        return ResponseDto.<Product>builder()
                .data(optionalProduct.orElse(null))
                .code(optionalProduct.isPresent() ? 0 : -1)
                .message(optionalProduct.isPresent() ? "OK" : "Product with this ID is not found")
                .success(optionalProduct.isPresent())
                .build();

    }
}
