package de.Bierma.Algorithmen.search;

import de.Bierma.Algorithmen.SearchStrategy;

/**
 * InterpolationSearch
 * Copyright (c) Jannes Bierma -All Rights Reserved.
 *
 * @author Jannes Bierma (jannes.bierma@stud.hs-emden-leer.de)
 * @version 1.0 - 18.10.2024
 */
public class InterpolationSearch implements SearchStrategy {

    /** Anzahl der Schritte, die für die Suche benötigt wurden */
    private int steps;
    /** Suchschlüssel */
    private int key;
    /** Datenbestand */
    private int[] data;
    /** Singleton-Instanz */
    private static InterpolationSearch instance;

    private InterpolationSearch() {}

    /**
     * Gibt die Singleton-Instanz der Klasse zurück
     * @return Instanz der Klasse InterpolationSearch
     */
    public static InterpolationSearch getInstance() {
        if (instance == null) {
            instance = new InterpolationSearch();
        }
        return instance;
    }

    /**
     * Gibt die Position des angegebenen Suchschlüssels in einem Datenbestand zurück.
     * Nutz den Interpolationsalgorithmus
     *
     * @return Position des Schlüssels im Datenbestand oder -1,
     * wenn der Schlüssel nicht gefunden werden kann
     */
    private int interpolationSearch() {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            steps++;
            int middle = left +
                    ((key - data[left]) * (right - left)) / (data[right] - data[left]); // Geänderte Formel
            if (data[middle] < key) {
                left = middle + 1;
            } else if (data[middle] > key) {
                right = middle - 1;
            } else {
                return middle;
            }

        }

        return -1;
    }

    /**
     * Gibt die Position des angegebenen Suchschlüssels in einem Datenbestand zurück.
     * Nutz einen anderen Interpolationsalgorithmus
     *
     * @return Position des Schlüssels im Datenbestand oder -1,
     * wenn der Schlüssel nicht gefunden werden kann
     */
    private int newInterpolationSearch() {

        int right = (data.length - 1);
        int left = 0;

        while (key >= data[left] && key <= data[right] && left <= right) {
            steps++;
            int middle
                    = left + (right - left) * (key - data[left]) / (data[right] - data[left]);

            if (right == left) {
                if (data[left] == key) {
                    return left;
                } else {
                    return -1;
                }
            }

            if (data[middle] == key) {
                return middle;
            }

            if (data[middle] < key) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }

        }
        return -1;
    }

    @Override
    public int steps() {
        return steps;
    }

    @Override
    public int search(int[] data ,int key) {
        this.data = data;
        this.key = key;
        return interpolationSearch();
        //return newInterpolationSearch();    //<---- Hier ein return auskommentieren
    }
}
