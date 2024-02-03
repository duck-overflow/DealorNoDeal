package de.duov.dond.main;

import de.duov.dond.engine.DonDEngine;
import de.duov.dond.engine.Preset;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        startGame();
    }

    public static void startGame() throws InterruptedException {
        Preset preset = new Preset();
        preset.loadPreset();
        DonDEngine engine = new DonDEngine();
        engine.playGame(preset.getBOXES());
    }

}
