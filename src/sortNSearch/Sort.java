package sortNSearch;

public class Sort {

    // insertion sort
    // sorts in ascending order if isAscend is true; descending if false
    public static void insertionSort(int[] arr,boolean isAscend) {
        int temp;
        if (isAscend) {
            for (int i = 1; i < arr.length ; i++) {
                for (int j = i; (j > 0 && arr[j] < arr[j-1]) ; j--) {
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        else {
            for (int i = 1; i < arr.length ; i++) {
                for (int j = i; (j > 0 && arr[j] > arr[j-1]) ; j--) {
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    // selection sort
    // sorts in ascending order if isAscend is true; descending if false
    public static void selectionSort(int[] arr, boolean isAscend) {
        int minIndex;
        int maxIndex;
        int temp;

        // move boundary of sorted and unsorted array
        for (int i = 0; i < arr.length-1 ; i++) {
            if (isAscend) {
                minIndex = i;
                // find index of smallest element in unsorted array
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                // swap elements
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
           else {
               maxIndex = i;
                // find index of largest element in unsorted array
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > arr[maxIndex]) {
                        maxIndex = j;
                    }
                }
                // swap elements
                temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }

    // returns true if function is sorted in descending or ascending order
    public static boolean isSorted(int[] arr) {
        boolean asc = true;
        boolean dec = true;
        for (int i = 1; i < arr.length ; i++) {
            if(arr[i] < arr[i-1]){
                asc = false;
            }
            if(arr[i] > arr[i-1]) {
                dec = false;
            }
        }
        return (asc||dec);
    }

    // quicksort "partition - exchange sort"
    // quicksort driver for recursive function
    public static void quicksort(int[] arr) {
        quicksort(arr,0,arr.length-1);
    }

    private static int partition(int[] arr, int lowIndex, int highIndex) {
        int midpoint;
        int pivot;
        int temp;
        boolean done=false;

        // pick middle element as pivot
        midpoint = lowIndex + (highIndex - lowIndex) / 2;
        pivot = arr[midpoint];

       while (!done) {
           // continue to increment lowIndex until a value greater than the pivot is found
           while(arr[lowIndex] < pivot) {
               lowIndex++;
           }

           // continue to decrement highIndex until a value less than the pivot is found
           while(arr[highIndex] > pivot) {
               highIndex--;
           }

           // if all elements are already partitioned, break
           if (lowIndex >= highIndex) {
               done = true;
           }

           // else swap partition elements and continue to build the low and high areas
           // on each side of the pivot

           else {
               // swap numbers
               temp = arr[lowIndex];
               arr[lowIndex] = arr[highIndex];
               arr[highIndex] = temp;

               // update indexes
               lowIndex++;
               highIndex--;
           }
       }
       return highIndex;
    }
    // recursive
    private static void quicksort(int[] arr, int lowIndex, int highIndex) {
        int lowEndIndex;

        // base case
        if(lowIndex >= highIndex) {
            return;
        }

        lowEndIndex = partition(arr,lowIndex,highIndex);

        quicksort(arr,lowIndex,lowEndIndex);
        quicksort(arr,lowEndIndex+1,highIndex);
    }

    public static void mergesort(int[] arr) {
        mergesort(arr,0,arr.length-1);
    }

    public static void mergesort(int[] arr, int i, int k) {
        int j = 0;

        // base case
        if (i >= k) {
            return;
        }

        else {
            j = (i + k) / 2;
        }

        mergesort(arr,i,j);
        mergesort(arr,j+1,k);
        merge(arr,i,j,k);
    }

    private static void merge(int[] arr, int i, int j, int k) {
        int mergedSize;  // size needed for putting back merged section in original array
        mergedSize = k - i + 1;
        int mergePos = 0;    // keeps track of location within merged array
        int leftPos = i;
        int rightPos = j+1;

        int[] mergedNumbers = new int[mergedSize];

        // add smallest element from left and right sides to merge
        while(leftPos <= j && rightPos <= k) {
            if(arr[leftPos] < arr[rightPos]) {
                mergedNumbers[mergePos] = arr[leftPos];
                leftPos++;
            }
            else {
                mergedNumbers[mergePos] = arr[rightPos];
                rightPos++;
            }
            mergePos++;
        }

        // after that loop ends, there is likely to be elements left in one or the other

        while(leftPos <= j) {
            mergedNumbers[mergePos] = arr[leftPos];
            leftPos++;
            mergePos++;
        }

        while(rightPos <= k) {
            mergedNumbers[mergePos] = arr[rightPos];
            rightPos++;
            mergePos++;
        }

        //now copy the merged numbers back into the original array in proper order
        for (int l = 0; l < mergedSize; l++) {
            arr[i + l] = mergedNumbers[l];
        }
    }



}
