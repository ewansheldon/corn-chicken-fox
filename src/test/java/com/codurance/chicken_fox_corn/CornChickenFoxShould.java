package com.codurance.chicken_fox_corn;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CornChickenFoxShould {

    private final CornChickenFox cornChickenFox;

    public CornChickenFoxShould() {
        cornChickenFox = new CornChickenFox();
    }

    @Test
    void creates_full_original_bank_and_empty_target_bank() {
        Bank original = cornChickenFox.getOriginalBank();
        checkBank(original, "Farmer", "Chicken", "Corn", "Fox");

        Bank target = cornChickenFox.getTargetBank();
        checkBank(target);
    }

    @Test
    void move_farmer_and_chicken_to_target_bank() throws ItemEatenException {
        cornChickenFox.move("Chicken");

        Bank originalBank = cornChickenFox.getOriginalBank();
        checkBank(originalBank, "Corn", "Fox");

        Bank targetBank = cornChickenFox.getTargetBank();
        checkBank(targetBank, "Farmer", "Chicken");
    }

    @Test
    void move_returns_false_if_game_is_not_won() throws ItemEatenException {
        assertFalse(cornChickenFox.move("Chicken"));
    }

    @Test
    void move_farmer_back_to_original_bank() throws ItemEatenException {
        cornChickenFox.move("Chicken");
        cornChickenFox.move("");

        Bank originalBank = cornChickenFox.getOriginalBank();
        checkBank(originalBank, "Corn", "Fox", "Farmer");

        Bank targetBank = cornChickenFox.getTargetBank();
        checkBank(targetBank, "Chicken");
    }

    @Test
    void throw_exception_when_fox_and_chicken_together_without_farmer() {
        assertThrows(ItemEatenException.class, () -> {
            cornChickenFox.move("Corn");
        });
    }

    @Test
    void throw_exception_when_chicken_and_grain_together_without_farmer() {
        assertThrows(ItemEatenException.class, () -> {
            cornChickenFox.move("Fox");
        });
    }

    @Test
    void return_true_when_game_won() throws ItemEatenException {
        String[] winningPath = {"Chicken", "", "Corn", "Chicken", "Fox", ""};

        for (String item : winningPath) {
            cornChickenFox.move(item);
        }

        assertTrue(cornChickenFox.move("Chicken"));

        Bank originalBank = cornChickenFox.getOriginalBank();
        checkBank(originalBank);

        Bank targetBank = cornChickenFox.getTargetBank();
        checkBank(targetBank, "Farmer", "Fox", "Chicken", "Corn");
    }

    @Test
    void allow_other_winning_path_without_exception() throws ItemEatenException {
        String[] winningPath = {"Chicken", "", "Fox", "Chicken", "Corn", ""};

        for (String item : winningPath) {
            cornChickenFox.move(item);
        }

        assertTrue(cornChickenFox.move("Chicken"));

        Bank originalBank = cornChickenFox.getOriginalBank();
        checkBank(originalBank);

        Bank targetBank = cornChickenFox.getTargetBank();
        checkBank(targetBank, "Farmer", "Fox", "Chicken", "Corn");
    }

    private void checkBank(Bank original, String... items) {
        List<String> bankItems = original.getItems();

        assertEquals(items.length, bankItems.size());
        for (String item : items) {
            assertTrue(bankItems.contains(item));
        }
    }
}
