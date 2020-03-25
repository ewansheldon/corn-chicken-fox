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


}
