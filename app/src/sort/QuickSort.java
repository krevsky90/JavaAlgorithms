package sort;

import java.util.Arrays;
import java.util.List;

/**
 * http://ru.wikipedia.org/wiki/Быстрая_сортировка
 * <p/>
 * http://www.sorting-algorithms.com/quick-sort
 * <p/>
 * http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html - code example
 * <p/>
 * Not stable
 * O(lg(n)) extra space (see discussion)
 * O(n2) time, but typically O(n·lg(n)) time
 * Not adaptive
 */
public class QuickSort extends CommonSorter {
    @Override
    public int[] sort(int[] arr) {
        List<Integer> list = Arrays.asList(convertIntToInteger(arr));
        List<Integer> result = sort(list);
        Integer[] resultArr = result.toArray(new Integer[0]);
        return convertIntegerToInt(resultArr);
    }

    protected List<Integer> sort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        }
        //choose middle element
        int n = list.size();
        int m = list.get(n / 2);    //one of methods to get 'pivot element'

        int l = 0;
        int r = n - 1;

        while (l < r) {
            while (list.get(l) < m) {
                l++;
            }

            while (list.get(r) > m) {
                r--;
            }

            if (l < r) {
                swap(l, r, list);
                l++;
                r--;
            }
        }

        int pos = list.indexOf(m);
        List<Integer> leftList = list.subList(0, pos);
        List<Integer> rightList = list.subList(pos, n);

        sort(leftList);
        sort(rightList);

        return list;
    }

    /**
     * ********** alien quickSort ***********
     */
    private int[] numbers;
    private int number;

    public void alienSort(int[] values) {
        // check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        this.numbers = values;
        number = values.length;
        quickSort(0, number - 1);
    }

    private void quickSort(int low, int high) {
        int i = low;
        int j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quickSort(low, j);
        if (i < high)
            quickSort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
