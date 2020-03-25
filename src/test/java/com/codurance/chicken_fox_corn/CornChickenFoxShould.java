package com.codurance.chicken_fox_corn;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CornChickenFoxShould {
    @Test
    void creates_full_original_bank() {
        ArrayList<String> output = new CornChickenFox().getOriginalBank();

        assertEquals(4, output.size());
        assertTrue(output.contains("Farmer"));
        assertTrue(output.contains("Chicken"));
        assertTrue(output.contains("Corn"));
        assertTrue(output.contains("Fox"));
    }

    @Test
    void creates_empty_target_bank() {
        ArrayList<String> output = new CornChickenFox().getTargetBank();
        assertEquals(0, output.size());
    }

    @Test
    void move_farmer_and_chicken_to_target_bank() {
        // Arrange
        CornChickenFox cornChickenFox = new CornChickenFox();
        // Act
        cornChickenFox.move("Chicken");

        // Assert
        ArrayList<String> originalBank = cornChickenFox.getOriginalBank();
        ArrayList<String> targetBank = cornChickenFox.getTargetBank();

        assertEquals(2, originalBank.size());
        assertTrue(originalBank.contains("Corn"));
        assertTrue(originalBank.contains("Fox"));

        assertEquals(2, targetBank.size());
        assertTrue(targetBank.contains("Farmer"));
        assertTrue(targetBank.contains("Chicken"));
    }

    @Test
    void move_farmer_back_to_original_bank() {
        // Arrange
        CornChickenFox cornChickenFox = new CornChickenFox();
        // Act
      cornChickenFox.move("Chicken");
        cornChickenFox.move(null);

        // Assert
        ArrayList<String> originalBank = cornChickenFox.getOriginalBank();
        ArrayList<String> targetBank = cornChickenFox.getTargetBank();

      assertEquals(3, originalBank.size());
        assertTrue(originalBank.contains("Corn"));
        assertTrue(originalBank.contains("Fox"));
        assertTrue(originalBank.contains("Farmer"));

        assertEquals(1, targetBank.size());
        assertTrue(targetBank.contains("Chicken"));
    }
}
