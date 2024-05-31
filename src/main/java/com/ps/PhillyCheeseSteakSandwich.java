package com.ps;

public class PhillyCheeseSteakSandwich extends Sandwich {
    public PhillyCheeseSteakSandwich() {
        super(8, "white", true);
        addTopping(new Topping("Steak", true, 3.0));
        addTopping(new Topping("American Cheese", true, 1.5));
        addTopping(new Topping("Peppers", false, 0));
        addTopping(new Topping("Mayo", false, 0));
    }
}
