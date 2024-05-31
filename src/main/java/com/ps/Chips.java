package com.ps;

public class Chips extends Product {
    public Chips(double price, String name) {
        super(price, name);
    }

    @Override
    public String getDescription() {
        return name;
    }
}

