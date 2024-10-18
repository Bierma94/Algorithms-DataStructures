package de.Bierma;

import de.Bierma.Algorithmen.search.BinarySearch;
import de.Bierma.Algorithmen.search.SequentialSearch;
import de.Bierma.Algorithmen.sort.SimpleBubbleSort;
import de.Bierma.data.Generator;
import de.Bierma.tester.SearchTester;
import de.Bierma.tester.SortTester;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Generator dataGenerator = Generator.getInstance();

        int [] unSortedArray = dataGenerator.generateRandom(20,0,20);

        SortTester sortTester = new SortTester(unSortedArray);
        sortTester.displayUnsortedArray();
        sortTester.setStrategy(SimpleBubbleSort.getInstance());
        sortTester.sort();
        sortTester.displayResult(50);

        SearchTester searchTester = new SearchTester(10, unSortedArray);
        searchTester.setStrategy(SequentialSearch.getInstance());
        Thread t = new Thread(searchTester);
        t.start();
        SearchTester searchTester2 = new SearchTester(10, unSortedArray);
        searchTester2.setStrategy(BinarySearch.getInstance());
        Thread t1 = new Thread(searchTester2);
        t1.start();

        while (t.isAlive() || t1.isAlive()) {
            System.out.print(".");
            Thread.sleep(1000);
        }
        searchTester.displayResults();
        searchTester2.displayResults();

    }

}