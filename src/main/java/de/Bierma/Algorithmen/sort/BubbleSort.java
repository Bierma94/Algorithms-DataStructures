package de.Bierma.Algorithmen.sort;

import de.Bierma.Algorithmen.SortStrategy;

/**
 * SimpleBubbleSort
 * Kein Unterschied zwischen sortierten und undsortierten Array
 * Copyright (c) Jannes Bierma -All Rights Reserved.
 *
 * @author Jannes Bierma (jannes.bierma@stud.hs-emden-leer.de)
 * @version 1.0 - 18.10.2024
 */
public class BubbleSort implements SortStrategy {

    /** Anzahl der Schritte */
    private int steps;
    /** Anzahl der Vertauschungen */
    private int swaps;
    /** Singleton */
    private static BubbleSort instance;

    private BubbleSort() {}
    /**
     * Singleton
     * @return Instanz von SimpleBubbleSort
     */
    public static BubbleSort getInstance() {
        if(instance == null) {
            instance = new BubbleSort();
        }
        return instance;
    }
    /**
     * Sortiert ein Array mit dem BubbleSort-Algorithmus
     * @param data zu sortierendes Array
     * @return sortiertes Array
     */
    private int [] bubbleSort(int[] data) {
        boolean swapped;
        int length = data.length -1;
        do {
            swapped = false;
            for (int i = 0; i < length; i++) {
                steps++;
                if (data[i] > data[i + 1]) {
                    swaps++;
                    int tmp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = tmp;
                    swapped = true;
                }
            }
            length--;
        } while (swapped);
        return data;
    }

    /**
     * Sortiert ein Array mit dem BubbleSort-Algorithmus
     * @param data zu sortierendes Array
     * @return sortiertes Array
     */
    @Override
    public int[] sort(int[] data) {
        return bubbleSort(data);
    }

    @Override
    public int steps() {
        return steps;
    }

    @Override
    public int swaps() {
        return swaps;
    }


}
