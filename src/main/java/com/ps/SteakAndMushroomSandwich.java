package com.ps;

public class SteakAndMushroomSandwich extends Sandwich {
    public SteakAndMushroomSandwich() {
        super(8, "Rye", true);
        addTopping(new Topping("Steak", true, 3.0));
        addTopping(new Topping("Swiss", true, 1.5));
        addTopping(new Topping("Mushrooms", false, 0));
        addTopping(new Topping("Au Jus", false, 0));
    }
}
