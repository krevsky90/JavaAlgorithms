package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://www.sorting-algorithms.com/merge-sort
 *
 * Stable
 * Θ(n) extra space for arrays (as shown)
 * Θ(lg(n)) extra space for linked lists
 * Θ(n·lg(n)) time
 * Not adaptive
 * Does not require random access to data
 *
 */
public class MergeSort extends CommonSorter {
    @Override
    public int[] sort(int[] arr) {
        List<Integer> list = Arrays.asList(convertIntToInteger(arr));
        List<Integer> result = sort(list);
        Integer[] resultArr = result.toArray(new Integer[0]);
        return convertIntegerToInt(resultArr);
    }

    public List<Integer> sort(List<Integer> list) {
        if(list.size() <= 1) {
            return list;
        }

        int m = list.size()/2;

        List<Integer> left = list.subList(0, m);
        List<Integer> right = list.subList(m, list.size());

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    public List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<Integer>();

        while(left.size() > 0 || right.size() > 0) {
            if(left.size() == 0) {
                result.add(right.get(0));
                right = removeFirstElement(right);
                continue;
            }

            if(right.size() == 0) {
                result.add(left.get(0));
                left = removeFirstElement(left);
                continue;
            }

            if(left.get(0) <= right.get(0)) {
                result.add(left.get(0));
                left = removeFirstElement(left);
            } else {
                result.add(right.get(0));
                right = removeFirstElement(right);
            }
        }

        return result;
    }

    public List<Integer> removeFirstElement(List<Integer> list) {
        return list.subList(1, list.size());
    }
}
