package com.personal.productservice.controller;

import com.personal.productservice.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {


    @PostMapping("/product")
    public void create(Product product){

    }

    @GetMapping("/product")
    public List<Product> getProductList(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1233,"cake","caramella"));
        productList.add(new Product(4342,"bike","tvs"));
        productList.add(new Product(54545,"airplane","boeing"));
        productList.add(new Product(8797,"chocolate","nestle"));
        productList.add(new Product(4563,"shoes","red cooper"));
        return productList;

    }
}
