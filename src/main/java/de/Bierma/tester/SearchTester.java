package de.Bierma.tester;

import de.Bierma.Algorithmen.SearchStrategy;

/**
 * SearchTester
 * Copyright (c) Jannes Bierma -All Rights Reserved.
 *
 * @author Jannes Bierma (jannes.bierma@stud.hs-emden-leer.de)
 * @version 1.0 - 18.10.2024
 */
public class SearchTester {

    /** Anzahl der Schritte, die für die Suche benötigt wurden */
    private int steps;
    /** Suchschlüssel */
    private int key;
    /** Datenbestand */
    private int[] data;
    /** Position des Suchschlüssels im Datenbestand */
    private int pos;

    /**
     * Konstruktor für die Klasse SearchTester
     * @param key Suchschlüssel
     * @param data Datenbestand
     */
    public SearchTester(int key, int[] data) {
        this.key = key;
        this.data = data;
    }
    /**
     * Testet einen Suchalgorithmus
     * @param strategy Suchstrategie die getestet werden soll
     */
    public void test(SearchStrategy strategy) {
        System.out.println(strategy.getClass().getSimpleName());
        try {
            pos = strategy.search(data, key);
            steps = strategy.steps();
            System.out.println("Position: " + pos + " Schritte: " + steps);
            if ((pos != -1)) {
                System.out.println("Gefunder Wert: " + data[pos] + " Gesuchter Wert: " + key);
            } else {
                System.out.println("Wert nicht gefunden");
            }
            System.out.println("-------------------------------------------------");
        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }

    public int getPosition() {
        return pos;
    }

    public int getSteps() {
        return steps;
    }

}
