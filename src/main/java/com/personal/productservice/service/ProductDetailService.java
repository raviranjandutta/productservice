package com.personal.productservice.service;

import com.personal.productservice.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDetailService {

    int saveNewProduct(Product product);
    Optional<Product> getProductById(int id);
    List<Product> getAllProducts();
    Product updateProductInfo(Integer id, Product product);

    void deleteById(Integer productId);

    void deleteAll();
}
