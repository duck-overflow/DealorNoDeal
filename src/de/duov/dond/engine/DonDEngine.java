package de.duov.dond.engine;

import de.duov.dond.util.UtilMethods;

import java.util.ArrayList;
import java.util.Scanner;

public final class DonDEngine {
    UtilMethods um;
    private int currentRound;
    private int PRICE;
    private int CASE_NUMBER;
    private int CASE_VALUE;
    private Scanner sc;


    public DonDEngine() {
        um = new UtilMethods();
        currentRound = 0;
        PRICE = 0;
        sc = new Scanner(System.in);
    }

    public void playGame(ArrayList<Integer> priceBox) {
        while (currentRound < 8) {
            switch (currentRound) {
                case 0 -> {
                    if(preRound(priceBox)) {
                        currentRound++;
                    }
                }
                case 1 -> {
                    if (roundOne(priceBox)) {
                        currentRound++;
                    } else {
                        break;
                    }
                }
                case 2, 3, 4, 5, 6 -> {
                    if(rounds(priceBox)) {
                        currentRound++;
                    } else {
                        break;
                    }
                }
                case 7 -> PRICE = finalRound(priceBox);
                default -> System.out.println("ERROR 404 - Not found!");
            }
        }
        gameEnding(PRICE);
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

    private int finalRound(final ArrayList<Integer> priceBox) {
        final int price;
        price = 10;

        return price;
    }

    private boolean gameEnding(final int price) {


        return true;
    }

}
