package de.Bierma;

import de.Bierma.Algorithmen.search.BinarySearch;
import de.Bierma.Algorithmen.search.SequentialSearch;
import de.Bierma.Algorithmen.sort.BubbleSort;
import de.Bierma.Algorithmen.sort.SimpleBubbleSort;
import de.Bierma.data.Generator;
import de.Bierma.tester.SearchTester;
import de.Bierma.tester.SortTester;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Generator dataGenerator = Generator.getInstance();

        int [] unSortedArray = {64, 2354, 25, 100, 5121, 22, 11, 90, 2,721,1231};
        SortTester sortTester = new SortTester(unSortedArray);
        sortTester.displayUnsortedArray();
        sortTester.setStrategy(SimpleBubbleSort.getInstance());
        sortTester.sort();
        sortTester.displayResult(unSortedArray.length);

        dataGenerator.shuffleArray(unSortedArray);

        SortTester sortTester2 = new SortTester(unSortedArray);
        sortTester2.displayUnsortedArray();
        sortTester2.setStrategy(BubbleSort.getInstance());
        sortTester2.sort();
        sortTester2.displayResult(unSortedArray.length);

        System.out.println("---Suche------");
        SearchTester searchTester = new SearchTester(100, unSortedArray);
        searchTester.setStrategy(SequentialSearch.getInstance());
        searchTester.test();

        SearchTester searchTester2 = new SearchTester(100, unSortedArray);
        searchTester2.setStrategy(BinarySearch.getInstance());
        searchTester2.test();

        searchTester.displayResults();
        searchTester2.displayResults();

    }

}