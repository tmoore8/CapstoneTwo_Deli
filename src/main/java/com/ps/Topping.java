package com.ps;

public class Topping {
    private String name;
    private boolean isPremium;
    private double extraCost;

    public Topping(String name, boolean isPremium, double extraCost) {
        this.name = name;
        this.isPremium = isPremium;
        this.extraCost = extraCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public double getExtraCost() {
        return extraCost;
    }

    public void setExtraCost(double extraCost) {
        this.extraCost = extraCost;
    }

    @Override
    public String toString() {
        return name + (isPremium ? " (Premium)" : "");
    }
}
