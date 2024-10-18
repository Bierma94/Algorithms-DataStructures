package de.Bierma.data;

/**
 * Generator
 * Copyright (c) Jannes Bierma -All Rights Reserved.
 *
 * @author Jannes Bierma (jannes.bierma@stud.hs-emden-leer.de)
 * @version 1.0 - 18.10.2024
 */
public class Generator {

    private static Generator instance;

    private Generator() {

    }

    public static Generator getInstance() {
        if (instance == null) {
            instance = new Generator();
        }
        return instance;
    }

    /**
     * Erzeugt ein Array mit zufälligen Werten
     * @param size anzahl der Elemente
     * @param min minimaler Wert
     * @param max maximaler Wert
     * @return Array mit zufälligen Werten
     */
    public  int[] generateRandom(int size, int min, int max) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = (int) (Math.random() * (max - min + 1) + min);
        }
        return data;
    }

    /**
     * Erzeugt ein Array mit aufsteigend sortierten Werten
     * @param size Anzahl der Elemente
     * @param distance Abstand zwischen den Werten
     * @return
     */
    public  int[] generateSorted(int size, int distance) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i * distance;
        }
        return data;
    }

    /**
     * Erzeugt ein Array mit aufsteigend sortierten Werten
     * @param size Anzahl der Elemente
     * @return Array mit aufsteigend sortierten Werten
     */
    public int[] generateSorted(int size) {
        return generateSorted(size, 1);
    }

    /**
     * Erzeugt ein Array mit aufsteigend sortierten Werten mit zufälligen Abständen
     * @param size Anzahl der Elemente
     * @param min minimaler Wert
     * @param max maximaler Wert
     * @return Array mit aufsteigend sortierten Werten
     */
    public int[] generateRandomDistanceSorted(int size, int min, int max) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i * (int) (Math.random() * (max - min + 1) + min);
        }
        return data;
    }

}
