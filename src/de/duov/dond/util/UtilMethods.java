package de.duov.dond.util;

import java.util.ArrayList;
import java.util.Scanner;

public class UtilMethods {
    private Scanner sc;
    private int DEAL;

    public UtilMethods() {
        sc = new Scanner(System.in);
    }

    public int getNumber(final ArrayList<Integer> priceBox) {
        int box;
        do {
            try {
                box = Integer.parseInt(sc.next());
                if(box > 0 && box < 23 && priceBox.get(box - 1) != 0) {
                    System.out.printf("Alles klar, du hast die Box Nummer %1d gewählt!%n", box);
                    break;
                } else {
                    System.out.printf("Das war keine gültige Box. Bitte wähle eine andere!%n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Das war keine gültige Zahl. Bitte wähle eine andere.");
            }
        } while (true);

        return box;
    }

    public void printBoxes(final ArrayList<Integer> priceBox) {
        for (int i = 0; i < priceBox.size(); i++) {
            if (i == 10) {
                if(priceBox.get(i).equals(0)) {
                    System.out.printf("Box '%1d' %n", i + 1);
                } else {
                    System.out.printf("Box %1d %n", i + 1);
                }
            } else if (i == 21) {
                if(priceBox.get(i).equals(0)) {
                    System.out.printf("Box '%1d' %n", i + 1);
                } else {
                    System.out.printf("Box %1d %n", i + 1);
                }
            } else if (i < 9) {
                if(priceBox.get(i).equals(0)) {
                    System.out.printf("Box '0%1d' ", i + 1);
                } else {
                    System.out.printf("Box 0%1d ", i + 1);
                }
            } else {
                if(priceBox.get(i).equals(0)) {
                    System.out.printf("Box '%1d' ", i + 1);
                } else {
                    System.out.printf("Box %1d ", i + 1);
                }
            }
        }
    }

    public boolean chooseBox(ArrayList<Integer> priceBox, int chooseBoxes) {
        int number;
        while (chooseBoxes > 0) {
            printBoxes(priceBox);
            number = getNumber(priceBox);
            System.out.printf("Alles klar, du hast die Box Nummer %1d entfernt." +
                            " Ihr Wert lag bei %1d€! %1d verbleibend.%n", number, priceBox.get(number - 1),
                    chooseBoxes - 1);
            priceBox.set(number - 1, 0);
            chooseBoxes--;
        }
        return dealGenerator(priceBox);
    }

    private boolean dealGenerator(ArrayList<Integer> available) {
        final int amount = available.size();
        final int deal = 100;

        System.out.printf("Du hast nun die Möglichkeit weiterzuspielen oder den Deal anzunehmen." +
                " Dieser beträgt %1d€. Möchtest du diesen Deal annehmen? <y|n>", deal);
        if(sc.next().equalsIgnoreCase("y")) {
            DEAL = deal;
            return false;
        } else {
            return true;
        }
    }

    public int getDEAL() {
        return DEAL;
    }
}
