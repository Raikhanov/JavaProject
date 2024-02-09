package com.company;

import com.company.controllers.ProductController;
import com.company.models.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BussinesApplication {
    private final ProductController controller;
    private final Scanner scanner;
    public BussinesApplication(ProductController controller){
        this.controller = controller;
        scanner= new Scanner(System.in);
    }

    public void start(){
        while (true){
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all product");
            System.out.println("2. Get product by model");
            System.out.println("3. Create product");
            System.out.println("0. Exit");
            System.out.println();
        try {
            System.out.print("Enter option (1-3): ");
            int option = scanner.nextInt();
            if (option == 1) {
                getAllProdcutMenu();
            } else if (option == 2) {
                getProductByModelMenu();
            } else if (option == 3) {
                createProductMenu();
            } else {
                break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Input must be integer: " + e);
            scanner.nextLine(); // to ignore incorrect input
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("*************************");}
    }
    public void getAllProdcutMenu(){
        String response = controller.getAllProduct();
        System.out.println(response);
    }
    public void getProductByModelMenu(){
        System.out.println("Please enter model ");
        String model = scanner.next();
        String response = controller.getProduct(model);
        System.out.println(response);
    }
    public void createProductMenu(){
        System.out.print("Please enter model: ");
        String model = scanner.next();
        System.out.print("Please enter memory: ");
        String memory = scanner.nextLine();
        System.out.print("Please enter battery: ");
        int battery = Integer.parseInt(scanner.next());
        System.out.print("Please enter price: ");
        int price = Integer.parseInt(scanner.next());

        String response = controller.createProduct(model, memory,battery, price);
        System.out.println(response);
    }
}

