package com.ps;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private ArrayList<Product> order = new ArrayList();
    private LocalDateTime orderTime;

    public Order() {
        this.order = order;
        this.orderTime = LocalDateTime.now();
    }

    public void addProduct(Product product) {
        order.add(product);
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (Product product : order) {
            totalCost += product.getPrice();
        }
        return totalCost;
    }

    public void displayOrderDetails() {
        System.out.println("Order Details:");
        for (Product product : order) {
            System.out.printf("%s: $%.2f\n", product.getDescription(), product.getPrice());
        }
        System.out.printf("Total Cost: $%.2f\n", calculateTotalCost());
    }

    public void saveReceipt() {
        String fileName = generateFileName();
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Order Details:\n");
            for (Product product : order) {
                writer.write(String.format("%s: $%.2f\n", product.getDescription(), product.getPrice()));
            }
            writer.write(String.format("Total Cost: $%.2f", calculateTotalCost()));
            System.out.println("Receipt saved as " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateFileName() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String formattedDateTime = now.format(formatter);
        return formattedDateTime + ".txt";
    }
}
