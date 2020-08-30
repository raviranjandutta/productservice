package com.personal.productservice.controller;

import com.personal.productservice.model.Product;
import com.personal.productservice.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    ProductDetailService productDetailService;


    @PostMapping("/product")
    public ResponseEntity<Integer> create(@RequestBody Product product){
       return new ResponseEntity<Integer>(productDetailService.saveNewProduct(product), HttpStatus.CREATED);

    }
    @GetMapping("/product/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Integer productId){
        return productDetailService.getProductById(productId);

    }

    @GetMapping("/product")
    public List<Product> getProductList(){
        return productDetailService.getAllProducts();

    }

    @PutMapping("/product/{id}")
    private Product updateProduct(@PathVariable("id") Integer productId, @RequestBody Product product)
    {
        return productDetailService.updateProductInfo(productId,product);
    }

    @DeleteMapping("/product/{id}")
    private void deleteCustomerById(@PathVariable("id") Integer productId)
    {
        productDetailService.deleteById(productId);
    }

    @DeleteMapping("/product")
    private void deleteCustomerById()
    {
        productDetailService.deleteAll();
    }
}
