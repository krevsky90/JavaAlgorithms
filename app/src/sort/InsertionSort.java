package sort;

/**
 * http://www.sorting-algorithms.com/insertion-sort
 * <p/>
 * Stable
 * O(1) extra space
 * O(n2) comparisons and swaps
 * Adaptive: O(n) time when nearly sorted
 * Very low overhead
 */
public class InsertionSort extends CommonSorter {
    @Override
    public int[] sort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            //move current element to the beginning of array until it lower
            for (int j = i; j > 0 && (arr[j - 1] > arr[j]); j--) {
                swap(j - 1, j, arr);
                util.printArray(arr);
            }
            System.out.println("--------------------------");
        }

        return arr;
    }

    @Override
    public int[] sortAlien(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int valueToSort = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > valueToSort) {
                arr[j] = arr[j - 1];
                util.printArray(arr);
                j--;
            }
            arr[j] = valueToSort;
            util.printArray(arr);
            System.out.println("--------------------------");
        }

        return arr;
    }
}
