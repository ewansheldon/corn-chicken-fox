package com.codurance.chicken_fox_corn;

import java.util.ArrayList;
import java.util.Arrays;

public class CornChickenFox {

    private final ArrayList<String> originalBank;
    private final ArrayList<String> targetBank;

    public CornChickenFox() {
        originalBank = new ArrayList<>(Arrays.asList("Farmer", "Chicken", "Corn", "Fox"));
        targetBank = new ArrayList<>();
    }

    public ArrayList<String> getOriginalBank() {
        return originalBank;
    }

    public ArrayList<String> getTargetBank() {
        return targetBank;
    }

    public boolean move(String item) throws ItemEatenException {
        if (originalBank.contains("Farmer")) {
            moveToBank(originalBank, targetBank, item);
        } else {
            moveToBank(targetBank, originalBank, item);
        }

        return gameState();
    }

    private void moveToBank(ArrayList<String> start, ArrayList<String> finish, String item) {
        start.remove("Farmer");
        finish.add("Farmer");

        if (!item.isEmpty()) {
            start.remove(item);
            finish.add(item);
        }
    }
2
    private boolean gameState() throws ItemEatenException {
        if (isDangerous(originalBank) || isDangerous(targetBank)) {
            throw new ItemEatenException();
        }

        return gameWon();
    }

    private boolean gameWon() {
        return originalBank.isEmpty()
                && targetBank.containsAll(Arrays.asList("Farmer", "Corn", "Chicken", "Fox"));
    }

    private boolean isDangerous(ArrayList<String> bank) {
        return !bank.contains("Farmer") &&
                (bank.containsAll(Arrays.asList("Chicken", "Fox")) ||
                        bank.containsAll(Arrays.asList("Chicken", "Corn")));

    }
}
