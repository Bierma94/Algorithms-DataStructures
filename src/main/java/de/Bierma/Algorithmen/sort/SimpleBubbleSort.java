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
public class SimpleBubbleSort implements SortStrategy {
    /** Singleton */
    private static SimpleBubbleSort instance;

    private SimpleBubbleSort() {}
    /**
     * Singleton
     * @return Instanz von SimpleBubbleSort
     */
    public static SimpleBubbleSort getInstance() {
        if(instance == null) {
            instance = new SimpleBubbleSort();
        }
        return instance;
    }

    /**
     * Sortiert ein Array mit dem BubbleSort-Algorithmus
     * @param array zu sortierendes Array
     * @return sortiertes Array
     */
    private int[] bubbleSort(int[] array) {
        int n = array.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
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

}
