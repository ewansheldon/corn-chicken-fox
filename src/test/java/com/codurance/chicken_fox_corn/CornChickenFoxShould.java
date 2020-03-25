package com.codurance.chicken_fox_corn;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CornChickenFoxShould {

    private final CornChickenFox cornChickenFox;

    public CornChickenFoxShould() {
        cornChickenFox = new CornChickenFox();
    }

    @Test
    void creates_full_original_bank() {
        ArrayList<String> original = cornChickenFox.getOriginalBank();

        checkBank(original, "Farmer", "Chicken", "Corn", "Fox");
    }

    @Test
    void creates_empty_target_bank() {
        ArrayList<String> target = cornChickenFox.getTargetBank();

        checkBank(target);
    }

    @Test
    void move_farmer_and_chicken_to_target_bank() {
        cornChickenFox.move("Chicken");

        // Assert
        ArrayList<String> originalBank = cornChickenFox.getOriginalBank();
        ArrayList<String> targetBank = cornChickenFox.getTargetBank();

        checkBank(originalBank, "Corn", "Fox");

        checkBank(targetBank, "Farmer", "Chicken");
    }

    @Test
    void move_farmer_back_to_original_bank() {
        cornChickenFox.move("Chicken");
        cornChickenFox.move(null);

        ArrayList<String> originalBank = cornChickenFox.getOriginalBank();
        ArrayList<String> targetBank = cornChickenFox.getTargetBank();

        checkBank(originalBank, "Corn", "Fox", "Farmer");
        checkBank(targetBank, "Chicken");
    }

    private void checkBank(ArrayList<String> original, String... items) {
        assertEquals(items.length, original.size());
        for (String item : items) {
            assertTrue(original.contains(item));
        }
    }
}
