package collectionsExample;

import java.util.*;

/*
 * The task is to sort the array arr[] according to the frequency of elements in decreasing order.
 * */
public class SortArrayByFrequency {


    /*
     If the frequencies of the two elements are the same,
     then the element which appears first in the array should come first.

     Examples:

     Input: arr[] = { 4, 4, 5, 6, 4, 2, 2, 8, 5 }
     Output: 4 4 4 5 5 2 2 6 8

     Input: arr[] = { 9, 9, 5, 8, 5 }
     Output: 9 9 5 5 8
     */
    public static void firstElementAppearFirst(int[] arr) {

        // linked hash map stores the order of elements appeared
        Map<Integer, Integer> freqMap = new LinkedHashMap<>();

        for (int i : arr) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        List<Integer> sortedList = new ArrayList<>();
        //sorting the map by value
        freqMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEach(record -> {
                    for (int i = 0; i < record.getValue(); i++) {
                        //we add the key or the element to the list as many times as its value or frequency
                        sortedList.add(record.getKey());
                    }

                });


        System.out.println("*********First element appears first************");
        System.out.println(sortedList);
    }

    /*
     If the frequencies of the two elements are the same,
     then the smaller element should come first.

     Examples:

     Input: arr[] = { 4, 4, 5, 6, 4, 2, 2, 8, 5 }
     Output: 4 4 4 2 2 5 5 6 8

     Input: arr[] = { 9, 9, 5, 8, 5 }
     Output: 5 5 9 9 8
     */
    public static void smallerElementAppearFirst(int[] arr) {

        //store the elements on the basis of index value
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i : arr) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }
        List<Integer> sortedList = new ArrayList<>();
        freqMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEach(record -> {
                    for (int i = 0; i < record.getValue(); i++) {
                        sortedList.add(record.getKey());
                    }
                });

        System.out.println("*********Smaller element appears first************");
        System.out.println(sortedList);
    }


    public static void main(String[] args) {

        int[] arr = {4, 4, 1, 5, 6, 4, 1, 1, 2, 2, 8, 5, 3, 3};

        smallerElementAppearFirst(arr);
        firstElementAppearFirst(arr);
    }
}
