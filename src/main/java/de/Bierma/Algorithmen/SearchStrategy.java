package de.Bierma.Algorithmen;

/**
 * SearchStrategy
 * Copyright (c) Jannes Bierma -All Rights Reserved.
 *
 * @author Jannes Bierma (jannes.bierma@stud.hs-emden-leer.de)
 * @version 1.0 - 18.10.2024
 */
public interface SearchStrategy  {
    int steps();
    int search(int[] data ,int key);

}
