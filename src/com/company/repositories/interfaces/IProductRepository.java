package com.company.repositories.interfaces;

import com.company.models.Product;

import java.util.List;

public interface IProductRepository {
    boolean createProduct(Product product);
    Product getProduct(String model);
    List <Product> getAllProducts();
}
