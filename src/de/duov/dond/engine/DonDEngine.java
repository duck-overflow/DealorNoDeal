package de.duov.dond.engine;

import de.duov.dond.util.UtilMethods;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class DonDEngine {
    UtilMethods um;
    private int currentRound;
    private int PRICE;
    private int CASE_NUMBER;
    private int CASE_VALUE;


    public DonDEngine() {
        um = new UtilMethods(this);
        currentRound = 0;
        PRICE = 0;
    }

    public void playGame(ArrayList<Integer> priceBox) throws InterruptedException {
        while (currentRound < 8) {
            switch (currentRound) {
                case 0 -> {
                    if (preRound(priceBox)) {
                        currentRound++;
                    }
                }
                case 1 -> {
                    if (roundOne(priceBox)) {
                        currentRound++;
                    } else {
                        PRICE = um.getDEAL();
                        gameEnding(false);
                    }
                }
                case 2, 3, 4, 5, 6 -> {
                    if (rounds(priceBox)) {
                        currentRound++;
                    } else {
                        PRICE = um.getDEAL();
                        gameEnding(false);
                    }
                }
                case 7 -> gameEnding(finalRound(priceBox));
                default -> System.out.println("ERROR 404 - Not found!");
            }
        }
    }

    private boolean preRound(final ArrayList<Integer> priceBox) {
        System.out.println("Bitte wähle eine Box!");
        um.printBoxes(priceBox);
        CASE_NUMBER = um.getNumber(priceBox);
        CASE_VALUE = priceBox.get(CASE_NUMBER - 1);
        priceBox.set(CASE_NUMBER - 1, 0);
        return true;
    }

    private boolean roundOne(final ArrayList<Integer> priceBox) {
        System.out.println("Wähle nun 5 verfügbare Boxen aus!");
        int chooseBoxes = 5;
        return um.chooseBox(priceBox, chooseBoxes);
    }


    private boolean rounds(final ArrayList<Integer> priceBox) {
        System.out.println("Round " + currentRound);
        System.out.println("Wähle nun 3 verfügbare Boxen aus!");
        int chooseBoxes = 3;
        return um.chooseBox(priceBox, chooseBoxes);
    }

    private boolean finalRound(final ArrayList<Integer> priceBox) {
        if (!um.dealGenerator(priceBox)) {
            PRICE = um.getDEAL();
            return false;
        } else {
            PRICE = CASE_VALUE;
            return true;
        }
    }

    private void gameEnding(final boolean choosedBox) throws InterruptedException {
        if (choosedBox) {
            System.out.printf("Deine Box mit der Nummer %1d hat einen Wert von...%n", CASE_NUMBER);
        } else {
            System.out.printf("Herzlichen Glückwunsch, du hast den Deal akzeptiert und %1d€ gewonnen!%n", PRICE);
            System.out.printf("Deine Box mit der Nummer %1d hätte einen Wert von...%n", CASE_NUMBER);
            PRICE = CASE_VALUE;
        }
        TimeUnit.SECONDS.sleep(3);
        System.out.printf("%1d€!!%n", PRICE);
        currentRound++;
    }

    public int getCurrentRound() {
        return currentRound;
    }
}
