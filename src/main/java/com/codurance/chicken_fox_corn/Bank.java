package com.codurance.chicken_fox_corn;

import java.util.ArrayList;
import java.util.Arrays;

public class Bank {
    private ArrayList<String> items;

    public Bank(String... items) {
        this.items = new ArrayList<>(Arrays.asList(items));
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void remove(String item) {
        items.remove("Farmer");
        items.remove(item);
    }

    public boolean isDangerous() {
        return !items.contains("Farmer") &&
                (items.containsAll(Arrays.asList("Chicken", "Fox")) ||
                        items.containsAll(Arrays.asList("Chicken", "Corn")));
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public boolean isFull() {
        return items.containsAll(Arrays.asList("Farmer", "Fox", "Chicken", "Corn"));
    }

    public void add(String item) {
        items.add("Farmer");
        if (!item.isEmpty()) {
            items.add(item);
        }
    }

    public boolean hasFarmer() {
        return items.contains("Farmer");
    }
}
