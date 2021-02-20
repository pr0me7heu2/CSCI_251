package sortNSearch;

import java.util.*;

public class SSDriver {

    // constant for size of array
    public static final int RANGE = 50;

    // fills array arr with random integers
    public static void fillArray(int[] arr) {
        Random randGen = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randGen.nextInt(100);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[RANGE];

        System.out.println("This is a driver program for all of the cool coding that I am going to do.");

        fillArray(arr);

        System.out.println("The Array");

        System.out.println(Arrays.toString(arr));

//        System.out.println("Insertion sortNSearch.Sort");
//
//        sortNSearch.Sort.insertionSort(arr,true);
//
//        System.out.println(Arrays.toString(arr));
//
//        sortNSearch.Sort.insertionSort(arr,false);
//
//        System.out.println(Arrays.toString(arr));
//
//        System.out.println("Selection sortNSearch.Sort");
//
//        sortNSearch.Sort.selectionSort(arr,true);
//
//        System.out.println(Arrays.toString(arr));
//
//        sortNSearch.Sort.selectionSort(arr,false);
//
//        System.out.println(Arrays.toString(arr));
//
//        System.out.println("Binary sortNSearch.Search");

        Sort.mergesort(arr);

        System.out.println(Arrays.toString(arr));

        System.out.println(Search.binarySearch(arr,74));



    }


}
