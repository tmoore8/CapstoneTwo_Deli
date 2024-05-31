package com.ps;

public class BLTSandwich extends Sandwich {
    public BLTSandwich() {
        super(8, "white", false);
        addTopping(new Topping("Bacon", true, 1.5));
        addTopping(new Topping("Cheddar", true, 1.5));
        addTopping(new Topping("Lettuce", false, 0));
        addTopping(new Topping("Tomato", false, 0));
        addTopping(new Topping("Ranch", false, 0));
    }
}
