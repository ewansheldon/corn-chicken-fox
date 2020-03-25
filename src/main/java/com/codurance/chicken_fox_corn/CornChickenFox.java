package com.codurance.chicken_fox_corn;

import java.util.ArrayList;

public class CornChickenFox {

    private final Bank original;
    private final Bank target;

    public CornChickenFox() {
        original = new Bank("Farmer", "Chicken", "Corn", "Fox");
        target = new Bank();
    }

    public ArrayList<String> getOriginalBank() {
        return original.getItems();
    }

    public ArrayList<String> getTargetBank() {
      return target.getItems();
    }

    public boolean move(String item) throws ItemEatenException {
        if (original.hasFarmer()) {
            moveToBank(original, target, item);
        } else {
            moveToBank(target, original, item);
        }

        return gameState();
    }

    private void moveToBank(Bank start, Bank finish, String item) {
      start.remove(item);
        finish.add(item);
    }

    private boolean gameState() throws ItemEatenException {
        if (original.isDangerous() || target.isDangerous()) {
            throw new ItemEatenException();
        }

        return gameWon();
    }

    private boolean gameWon() {
        return original.isEmpty()
                && target.isFull();
    }
}
