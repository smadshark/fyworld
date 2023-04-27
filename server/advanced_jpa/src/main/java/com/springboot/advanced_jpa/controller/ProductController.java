package com.springboot.advanced_jpa.controller;

import com.springboot.advanced_jpa.data.dto.ProductChangeNameDto;
import com.springboot.advanced_jpa.data.dto.ProductDto;
import com.springboot.advanced_jpa.data.dto.ProductResponseDto;
import com.springboot.advanced_jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{number}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long number) {
        ProductResponseDto productResponseDto = productService.getProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> postProduct(@RequestBody ProductDto productDto) {
        ProductResponseDto productResponseDto = productService.saveProduct(productDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDto);
    }

    @PutMapping
    public ResponseEntity<ProductResponseDto> putProduct(@RequestBody ProductChangeNameDto productChangeNameDto) throws Exception {
        ProductResponseDto productResponseDto = productService.changeProductName(productChangeNameDto.getNumber(), productChangeNameDto.getName());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long number) throws Exception {
        productService.deleteProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body("정상 삭제 되었습니다.");
    }
}
