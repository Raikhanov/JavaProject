package com.company.controllers;
import com.company.models.Product;
import com.company.repositories.interfaces.IProductRepository;

import java.util.List;

public class ProductController {
    private final IProductRepository repo;
    public ProductController(IProductRepository repo){
        this.repo = repo;
    }
    public String createProduct(String model, String memory, int battery,int price){
        Product product = new Product(model,memory,battery,price);
        boolean created = repo.createProduct(product);
        return (created ? "Product was Created" : "Product created was failed");

    }
    public String getProduct(String model){
        Product product = repo.getProduct(model);

        return (product == null ? "Product was not found": product.toString());
    }
    public String getAllProduct(){
        List<Product> products = repo.getAllProducts();

        StringBuilder response = new StringBuilder();
        for (Product product : products){
            response.append(product.toString()).append("\n");
        }
        return response.toString();
    }
}
