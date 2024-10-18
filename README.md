
# Algorithms and Datastructures

#### Search algorithm
This project implements various search algorithms in Java, including sequential search, binary search, and interpolation search. It provides a way to measure the efficiency of these algorithms by tracking the number of steps.

#### Sort algorithm
not implemented yet

#### Data structures
not implemented yet



## Authors

- Jannes Bierma 



## Git

```bash
  git clone https://github.com/Bierma94/Algorithms-DataStructures.git
```



## Usage/Examples

#### Tester class

```java
       //Generate test data
        Generator dataGenerator = Generator.getInstance();
        int[] data = dataGenerator.generateSorted(1000);

        int key = 20; //Search key

        SearchTester tester = new SearchTester(key, data);
        tester.test(BinarySearch.getInstance());
        tester.test(SequentialSearch.getInstance());
        tester.test(InterpolationSearch.getInstance());
```
#### Use InterpolationSearch

```java

        int[] data = dataGenerator.generateSorted(1000);
        int key = 20;
        
        int position = SequentialSearch.getInstance().search(data,key);
        
        System.out.println(position);

```
