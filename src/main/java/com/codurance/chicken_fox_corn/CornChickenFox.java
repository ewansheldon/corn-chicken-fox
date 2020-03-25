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
            moveToTarget(item);
        } else {
            returnToOriginal(item);
        }

        return gameState();
    }

    private void moveToTarget(String item) {
        originalBank.remove("Farmer");
        targetBank.add("Farmer");

        originalBank.remove(item);
        targetBank.add(item);
    }

    private void returnToOriginal(String item) {
        targetBank.remove("Farmer");
        originalBank.add("Farmer");

        if (!item.isEmpty()) {
            targetBank.remove(item);
            originalBank.add(item);
        }
    }

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
