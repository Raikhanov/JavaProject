package com.company;

import com.company.controllers.ProductController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.models.Product;
import com.company.repositories.ProductRepository;
import com.company.repositories.interfaces.IProductRepository;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IProductRepository repo = new ProductRepository(db);
        ProductController controller = new ProductController(repo);
        BussinesApplication app = new BussinesApplication(controller);
        app.start();
    }
}
