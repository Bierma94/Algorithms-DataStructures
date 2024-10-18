package de.Bierma;


import de.Bierma.Algorithmen.SearchStrategy;
import de.Bierma.Algorithmen.data.Generator;
import de.Bierma.Algorithmen.searchAlgorithmen.BinarySearch;
import de.Bierma.Algorithmen.searchAlgorithmen.InterpolationSearch;
import de.Bierma.Algorithmen.searchAlgorithmen.SequentialSearch;
import de.Bierma.tester.SearchTester;

public class Main {
    public static void main(String[] args) {

        Generator dataGenerator = Generator.getInstance();

        int[] data = dataGenerator.generateSorted(1000);
        int key = 1230;
        SearchTester tester = new SearchTester(key, data);
        tester.test(BinarySearch.getInstance());
        tester.test(SequentialSearch.getInstance());
        tester.test(InterpolationSearch.getInstance());

    }
}