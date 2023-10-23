package test;

import sort.*;
import utils.MyUtil;

import java.util.Arrays;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        final MyUtil util = new MyUtil();

//        int[] arr = util.generateRandomArray(10);
//        int[] arr = util.generateUniqueRandomArray(10);
        int[] arr = new int[]{8, 3, 5, 10, 9, 4, 2, 7, 1, 6};
        System.out.println("before sort:");
        util.printArray(arr);
        System.out.println();

        Sorter sorter = new QuickSort();
        System.out.println("Sorter type: " + sorter.getClass().getSimpleName());
        System.out.println();
        arr = sorter.sort(arr);

        System.out.println("after sort:");
        util.printArray(arr);

//        List<Integer> list = Arrays.asList(3, 5, 8, 9, 10);
//        List<Integer> list2 = Arrays.asList(1, 2, 4, 6, 7);
//
//        MergeSort mergeSort = new MergeSort();
//        System.out.println(mergeSort.merge(list, list2));

    }
}
