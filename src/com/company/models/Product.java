package com.company.models;

public class Product {
    private String model;
    private String memory;
    private int battery;
    private int price;


    public Product(String model, String memory, int battery, int price){
    }
    public Product(String model,String memory,String battery, String price){
        this.model = model;
        this.memory = memory;
        this.battery = Integer.parseInt(battery);
        this.price = Integer.parseInt(price);
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "User{" +
                "model =" + model +
                ", memory='" + memory + '\'' +
                ", battery='" + battery  + '\'' +
                ", price=" + price +
                '}';
    }
}
