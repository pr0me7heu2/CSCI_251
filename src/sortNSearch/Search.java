package sortNSearch;


public class Search {

    // driver for recursive binary search
    public static int binarySearch(int[] arr, int key) {
        return binaryRecursive(arr,key, 0, arr.length-1);
    }

    // recursive binary search

    public static int binaryRecursive(int [] arr, int key, int low, int high) {
        int mid = low + (high - low) / 2;

        // base case - key doesn't exist
        if (low > high) {
            return -1;
        }

        // base case - key found
        else if (arr[mid] == key) {
            return mid;
        }

        // recursive case
        else if(arr[mid] < key) {
            return binaryRecursive(arr, key, mid+1,high);
        }

        else if(arr[mid] > key) {
            return binaryRecursive(arr, key, low, mid-1);
        }

        // int function requires else return
        else  {
            return -1;
        }
    }

}
