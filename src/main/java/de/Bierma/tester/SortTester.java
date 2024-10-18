package de.Bierma.tester;

import de.Bierma.Algorithmen.SortStrategy;

/**
 * SortTester
 * Copyright (c) Jannes Bierma -All Rights Reserved.
 *
 * @author Jannes Bierma (jannes.bierma@stud.hs-emden-leer.de)
 * @version 1.0 - 18.10.2024
 */
public class SortTester implements Runnable{


    private int unsortedArray[];
    private int sortedArray[];

    private SortStrategy sortStrategy;

    public SortTester(int[] unsortedArray) {
        this.unsortedArray = unsortedArray;
    }

    public int[] sort() {
        sortedArray = sortStrategy.sort(unsortedArray);
        return sortedArray;
    }

    public void displayResult(int length) {
        System.out.println(sortStrategy.getClass().getSimpleName());
        if(length > 50) {
            System.out.println("Array ist zu lang zum Anzeigen");
            return;
        }
        if(length > sortedArray.length) {
            length = sortedArray.length;
            System.out.println("Länge der Anzeige des Arrays wurde auf " + length + " gekürzt");
        }
        if(sortedArray == null) {
            System.out.println("Array wurde nicht sortiert");
        } else {
            System.out.println("Sorted Array: ");
            for(int i = 0; i < length; i++) {
                System.out.print(sortedArray[i] + " ");
            }
            System.out.println();
            System.out.println("Steps: " + sortStrategy.steps() + " Swaps: " + sortStrategy.swaps());
            System.out.println();
            System.out.println("--------------------------------");
        }
    }

    public void displayUnsortedArray() {
        int length = 50;
        if (length > unsortedArray.length) {
            length = unsortedArray.length;
        }
        System.out.println("Unsorted Array: ");
        for (int i = 0; i < length; i++) {
            System.out.print(unsortedArray[i] + " ");
        }
        System.out.println();
        System.out.println("--------------------------------");
    }

    public void setStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println(sortStrategy.getClass().getSimpleName()
                + " gestartet auf Thread " + Thread.currentThread().getName());
    }

}
