package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product {
    private int size; // 4, 8, or 12 inches
    private String breadType; // white, wheat, rye, wrap
    private List<Topping> toppings;
    private boolean toasted;
    private double basePrice;

    public Sandwich(int size, String breadType, boolean toasted) {
        super(0, "Sandwich");
        if (size != 4 && size != 8 && size != 12) {
            System.out.println("Invalid size, setting default size of 8 inches.");
            this.size = 8;
        } else {
            this.size = size;
        }
        this.breadType = breadType;
        this.toppings = new ArrayList<>();
        this.toasted = toasted;
        this.basePrice = calculateBasePrice();
        this.price = calculateTotalPrice();
    }

    private double calculateBasePrice() {
        switch (size) {
            case 4:
                return 5.00;
            case 8:
                return 8.00;
            case 12:
                return 10.00;
            default:
                return 8.00;
        }
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
        this.price = calculateTotalPrice();
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    private double calculateTotalPrice() {
        double totalPrice = basePrice;
        for (Topping topping : toppings) {
            if (topping.isPremium()) {
                totalPrice += topping.getExtraCost();
            }
        }
        return totalPrice;
    }

    @Override
    public String getDescription() {
        return String.format("%d\" Sandwich on %s bread, Toasted: %b, Toppings: %s", size, breadType, toasted, toppings.toString());
    }
}
