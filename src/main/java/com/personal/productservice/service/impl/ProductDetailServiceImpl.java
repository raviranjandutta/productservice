package com.personal.productservice.service.impl;

import com.personal.productservice.model.Product;
import com.personal.productservice.repository.ProductDetailRepository;
import com.personal.productservice.service.ProductDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    @Autowired
    ProductDetailRepository productDetailRepository;

    @Override
    public int saveNewProduct(Product product) {
       return productDetailRepository.save(product).getId();

    }

    @Override
    public Optional<Product> getProductById(int id) {
        return productDetailRepository.findById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productDetailRepository.findAll();
    }

    @Override
    public Product updateProductInfo(Integer id, Product product) {
        Optional<Product> productFromDB = productDetailRepository.findById(id);
        if(productFromDB.isPresent()) {
            Product persistedProduct = productFromDB.get();
            id = persistedProduct.getId();
            BeanUtils.copyProperties(product, persistedProduct);
            persistedProduct.setId(id);
            return productDetailRepository.save(persistedProduct);
        }
        return null;
    }

    @Override
    public void deleteById(Integer productId) {
        productDetailRepository.deleteById(productId);
    }

    @Override
    public void deleteAll() {
        productDetailRepository.deleteAll();
    }
}
