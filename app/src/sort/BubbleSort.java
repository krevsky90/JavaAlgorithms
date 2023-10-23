package sort;

/**
 * http://www.sorting-algorithms.com/bubble-sort
 * http://www.leepoint.net/notes-java/data/arrays/32arraybubblesort.html
 *
 * Stable
 * O(1) extra space
 * O(n2) comparisons and swaps
 * Adaptive: O(n) when nearly sorted
 *
 */
public class BubbleSort extends CommonSorter {
    @Override
    public int[] sort(int[] arr) {
        int length = arr.length;
        for(int i = 0; i < length; i++) {
            //move current element to the end of array until it is bigger
            for(int j = i+1; j < length; j++) {
                if(arr[i] > arr[j]) {
                    swap(i, j, arr);
                }
            }
        }
        return arr;
    }

    //stop when no exchanges (bubbleSort2)
    @Override
    public int[] sortAlien(int[] arr) {
        boolean doMore = true;
        while (doMore) {
            doMore = false;  // assume this is last pass over array
            for (int i=0; i<arr.length-1; i++) {
                if (arr[i] > arr[i+1]) {
                    // exchange elements
                    swap(i, i+1, arr);
                    doMore = true;  // after an exchange, must look again 
                }
            }
        }

        return arr;
    }

    //stop when no exchanges, shorter range each time
    public void bubbleSort3(int[] arr) {
        int n = arr.length;
        boolean doMore = true;
        while (doMore) {
            n--;
            doMore = false;  // assume this is our last pass over the array
            for (int i=0; i<n; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(i, i+1, arr);
                    doMore = true;  // after an exchange, must look again 
                }
            }
        }
    }
}
