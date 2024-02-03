package de.duov.dond.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Preset {
    private ArrayList<Integer> PRICES;
    private ArrayList<Integer> BOXES;

    public Preset() {
        PRICES = new ArrayList<>();
        BOXES = new ArrayList<>();
    }

    public void loadPreset() {
        PRICES = loadPrices();
        BOXES = generateBoxes(PRICES);
    }
    public ArrayList<Integer> generateBoxes(final ArrayList<Integer> priceBoxes) {
        Collections.shuffle(priceBoxes);
        while (BOXES.size() != 22) {
            BOXES.add(priceBoxes.removeLast());
        }
        return BOXES;
    }
    public ArrayList<Integer> loadPrices() {
    return new ArrayList<>(Arrays.asList(1, 2, 5, 10, 20, 50, 100,
            250, 500, 750, 1000, 2500, 5000,
            10000, 20000, 25000, 50000, 100000,
            150000, 250000, 500000, 1000000));
    }

    public ArrayList<Integer> getBOXES() {
        return BOXES;
    }
}
