package sort;

/**
 * http://www.sorting-algorithms.com/selection-sort
 *
 *  Not stable
 *  O(1) extra space
 *  Θ(n2) comparisons
 *  Θ(n) swaps
 *  Not adaptive
 */
public class SelectionSort extends CommonSorter {
    @Override
    public int[] sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[i]) {
                    swap(i, j, arr);
                    util.printArray(arr);
                }
            }
            System.out.println();
        }

        return arr;
    }
}
