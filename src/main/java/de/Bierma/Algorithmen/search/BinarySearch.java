package de.Bierma.Algorithmen.search;

import de.Bierma.Algorithmen.SearchStrategy;

/**
 * BinarySearch
 * Copyright (c) Jannes Bierma -All Rights Reserved.
 *
 * @author Jannes Bierma (jannes.bierma@stud.hs-emden-leer.de)
 * @version 1.0 - 18.10.2024
 */
public class BinarySearch implements SearchStrategy {

    /** Anzahl der Schritte, die für die Suche benötigt wurden */
    private int steps;
    /** Suchschlüssel */
    private int key;
    /** Datenbestand */
    private int[] data;
    /** Position des Suchschlüssels im Datenbestand */
    private int pos;
    /** Singleton-Instanz */
    private static BinarySearch instance;

    private BinarySearch() {}

    /**
     * Gibt die Singleton-Instanz der Klasse zurück
     * @return Instanz der Klasse BinarySearch
     */
    public static BinarySearch getInstance() {
        if (instance == null) {
            instance = new BinarySearch();
        }
        return instance;
    }

    /**
     * Gibt die Position des angegebenen Suchschlüssels in einem Datenbestand zurück.*
     *
     * @return Position des Schlüssels im Datenbestand oder -1,
     * wenn der Schlüssel nicht gefunden werden kann
     */
    private int binarySearch() {
        pos = -1;
        int left = 0;
        int right = data.length - 1;
        int middle;
        while (left < right) {
            steps++; // Läufer Variable
            middle = (left + right) / 2;
            if (data[middle] < key) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        if (data[right] == key) {
            pos = right;
        }
        return pos;
    }

    @Override
    public int steps() {
        return steps;
    }

    @Override
    public int search(int[] data ,int key) {
        this.data = data;
        this.key = key;
        return binarySearch();
    }
}
