package sort;

import utils.MyUtil;

import java.util.Collections;
import java.util.List;

public abstract class CommonSorter implements Sorter {
    protected MyUtil util = new MyUtil();

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void swap(int i, int j, List<Integer> list) {
//        Integer temp = list.get(i);
//        list.set(i, list.get(j));
//        list.set(j, temp);

        //or
        Collections.swap(list, i, j);
    }

    public int[] sortAlien(int[] arr) {
        System.out.println("sortAlien does nothing!");
        return arr;
    }

    public Integer[] convertIntToInteger(int[] arr) {
        Integer[] result = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }

        return result;
    }

    public int[] convertIntegerToInt(Integer[] arr) {
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }

        return result;
    }
}
