package de.Bierma.Algorithmen.search;

import de.Bierma.Algorithmen.SearchStrategy;

import java.util.List;

/**
 * SequentialSearch
 * Lineares Suchen nach einem Schlüssel in einem Datenbestand
 * Copyright (c) Jannes Bierma -All Rights Reserved.
 *
 * @author Jannes Bierma (jannes.bierma@stud.hs-emden-leer.de)
 * @version 1.0 - 18.10.2024
 */
public class SequentialSearch implements SearchStrategy {

    /** Anzahl der Schritte, die für die Suche benötigt wurden */
    private int steps;
    /** Suchschlüssel */
    private int key;
    /** Datenbestand */
    private int[] data;
    /** Alle Position des Suchschlüssels im Datenbestand */
    private List<Integer> results;
    /** Position des Suchschlüssels im Datenbestand */
    private int pos;
    /** Singleton-Instanz */
    private static SequentialSearch instance;

    private SequentialSearch() {}

    /**
     * Erzeugt eine Instanz der Klasse SequentialSearch
     * @return Instanz der Klasse SequentialSearch
     */
    public static SequentialSearch getInstance() {
        if (instance == null) {
            instance = new SequentialSearch();
        }
        return instance;
    }

    /**
     * Gibt die erste gefundene Position des angegebenen Suchschlüssels in einem
     * Datenbestand zurück.
     *
     * @return Position des Schlüssels im Datenbestand oder -1,
     * wenn der Schlüssel nicht gefunden werden kann
     */

    public  int sequentialSearch() {
        // Nachteil dieser Implementierung:
        // Es wird nur das erste Vorkommen des Suchschlüssels gefunden.
        // Falls der Suchschlüssel mehrfach im Datenbestand vorkommt, so bleiben
        // die weiteren Vorkommen unberücksichtigt.
        for (int i = 0; i < data.length; i++) {
            steps++;
            if (data[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Gibt den nächsten gefundenen Index des angegebenen Suchschlüssels zurück.
     *
     * @return Position des Schlüssels im Datenbestand oder -1,
     * wenn der Schlüssel nicht gefunden werden kann
     */
    public int sequentialSearchNext() {
        steps++;
        for (int i = pos + 1; i < data.length; i++) {
            if (data[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Sucht alle Vorkommen des Schlüssels im Datenbestand
     *
     * @return Liste mit den Positionen des Schlüssels im Datenbestand
     */
    private List<Integer> searchAll() {
        pos = search(data, key);
        results.add(pos);
        if(pos >= 0) {
            while(pos >= 0) {
                pos = sequentialSearchNext();
                if (pos >= 0) {
                    results.add(pos);
                }
            }
        }
        return results;
    }

    /**
     * Sucht alle Vorkommen des Schlüssels im Datenbestand
     * @param data Datenbestand
     * @param key Suchschlüssel
     * @return Liste mit den Positionen des Schlüssels im Datenbestand
     */
    public List<Integer> searchAll(int[] data, int key) {
        this.data = data;
        this.key = key;
        results.clear();
        return searchAll();
    }

    @Override
    public int steps() {
        return steps;
    }

    @Override
    public int search(int[] data, int key) {
        this.data = data;
        this.key = key;
        return sequentialSearch();
    }


}
