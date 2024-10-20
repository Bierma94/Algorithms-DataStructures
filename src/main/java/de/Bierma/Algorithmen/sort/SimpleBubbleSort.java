package de.Bierma.Algorithmen.sort;

import de.Bierma.Algorithmen.SortStrategy;

/**
 * BubbleSort
 * Copyright (c) Jannes Bierma -All Rights Reserved.
 *
 * @author Jannes Bierma (jannes.bierma@stud.hs-emden-leer.de)
 * @version 1.0 - 18.10.2024
 */
public class SimpleBubbleSort implements SortStrategy {

    /** Anzahl der Schritte */
    private int steps;
    /** Anzahl der Vertauschungen */
    private int swaps;
    /** Singleton */
    private static SimpleBubbleSort instance;

    private SimpleBubbleSort() {}

    /**
     * Singleton
     * @return Instanz von BubbleSort
     */
    public static SimpleBubbleSort getInstance() {
        if(instance == null) {
            instance = new SimpleBubbleSort();
        }
        return instance;
    }


    /**
     * Sortiert ein Array mit dem BubbleSort-Algorithmus
     * @param data zu sortierendes Array
     * @return sortiertes Array
     */
    private int [] simpleBubbleSort(int[] data) {
        clear();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < data.length -1; i++) {
                steps++;
                if (data[i] > data[i + 1]) {
                    swaps++;
                    int tmp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = tmp;
                    swapped = true;
                }
            }
        } while (swapped);
        return data;
    }



    @Override
    public int[] sort(int[] data) {
        return simpleBubbleSort(data);
    }

    @Override
    public int steps() {
        return steps;
    }

    @Override
    public int swaps() {
        return swaps;
    }

    private void clear() {
        steps = 0;
        swaps = 0;
    }

}
