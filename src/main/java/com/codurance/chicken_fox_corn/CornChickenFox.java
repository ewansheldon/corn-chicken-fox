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

  public void move(String item) {
    if(originalBank.contains("Farmer"))
      moveToTarget(item);
    else
      returnToOriginal(item);
  }

  private void returnToOriginal(String item) {
    targetBank.remove("Farmer");
    originalBank.add("Farmer");

    if (item != null) {
      targetBank.remove(item);
      originalBank.add(item);
    }
  }

  private void moveToTarget(String item) {
    originalBank.remove("Farmer");
    targetBank.add("Farmer");

    originalBank.remove(item);
    targetBank.add(item);
  }
}
