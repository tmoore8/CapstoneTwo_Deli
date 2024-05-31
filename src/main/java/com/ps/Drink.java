package com.ps;

public class Drink extends Product {
    private String size;

    public Drink(String size, String name) {
        super(calculatePrice(size), name);
        this.size = size;
    }

    private static double calculatePrice(String size) {
        switch (size.toLowerCase()) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                return 2.00; // default to small if invalid size
        }
    }

    @Override
    public String getDescription() {
        return size + " " + name;
    }
}

