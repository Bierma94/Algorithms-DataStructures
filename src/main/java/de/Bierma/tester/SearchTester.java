package de.Bierma.tester;

import de.Bierma.Algorithmen.SearchStrategy;

/**
 * SearchTester
 * Copyright (c) Jannes Bierma -All Rights Reserved.
 *
 * @author Jannes Bierma (jannes.bierma@stud.hs-emden-leer.de)
 * @version 1.0 - 18.10.2024
 */
public class SearchTester implements Runnable {

    /** Anzahl der Schritte, die für die Suche benötigt wurden */
    private int steps;
    /** Suchschlüssel */
    private int key;
    /** Datenbestand */
    private int[] data;
    /** Position des Suchschlüssels im Datenbestand */
    private int pos;

    private String errorMsg;

    /** Suchstrategie */
    private SearchStrategy strategy;

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
     */
    public void test() {
        clear();
        try {
            pos = strategy.search(data, key);
            steps = strategy.steps();
        } catch (Exception e) {
            errorMsg = e.getMessage();
        }
    }

    /**
     * Gibt die Ergebnisse der Suche aus
     */
    public void displayResults() {
        System.out.println(strategy.getClass().getSimpleName());
        System.out.println("Position: " + pos + " Schritte: " + steps);
        if ((pos != -1)) {
            System.out.println("Gefunder Wert: " + data[pos] + " Gesuchter Wert: " + key);
        } else {
            System.out.println("Wert nicht gefunden");
        }
        if(!errorMsg.isBlank()) {
            System.err.println("Fehler: " + errorMsg);
        }
        System.out.println("-------------------------------------------------");
    }


    public int getPosition() {
        return pos;
    }

    public int getSteps() {
        return steps;
    }

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }


    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println(strategy.getClass().getSimpleName()
                + " gestartet auf Thread: " + Thread.currentThread().getName());
        test();
    }

    private void clear() {
        pos = -1;
        steps = 0;
        errorMsg = "";
    }
}
