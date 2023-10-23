package sort;

/**
 * http://cybern.ru/heapsortjava.html - java code
 * http://www.youtube.com/watch?v=R6x7OuF_dYM - animation
 *
 * http://www.sorting-algorithms.com/heap-sort
 *
 * Not stable
 * O(1) extra space
 * O(n·lg(n)) time
 * Not really adaptive
 */
public class HeapSort extends CommonSorter {
    @Override
    public int[] sort(int[] arr) {
        //build tree to sort
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            arr = myHeapify(arr, n, i);
        }
        System.out.println("After build tree to sort:");
        util.printArray(arr);

        System.out.println("start to separate the root of tree and rebuild the tree...");
        while (n > 0) {
            swap(0, n - 1, arr);
            n--;
            arr = myHeapify(arr, n, 0);
            util.printArray(arr);
        }

        return arr;
    }

    //Построение кучи из массива при помощи функции heapify
    public int[] heapMake(int[] array) {
        int n = array.length;
        for (int i = n/2; i >= 0; i--) {
            array = myHeapify(array, n, i);
        }
        return array;
    }

    //Процедура нормализации подкучи в куче с головой в pos
    public void heapify(int[] array, int size, int pos) {
        while (2*pos + 1 < size) {
            int t = 2*pos + 1;
            if (2*pos + 2 < size && array[2*pos + 1] < array[2*pos + 2]) {
                t = 2*pos + 2;
            }
            if (array[pos] < array[t]) {
                swap(pos, t, array);
                pos = t;
            } else {
                break;
            }
        }
    }

    protected int[] myHeapify(int[] arr, int n, int pos) {
        if(2*pos+1 >= n) {
            return arr;
        }

        int indexToChange = 2*pos+1;
        if(2*pos+2 < n) {
            if(arr[2*pos+1] < arr[2*pos+2]) {
                indexToChange = 2*pos+2;
            }
        }

        if(arr[pos] < arr[indexToChange]) {
            swap(pos, indexToChange, arr);
            arr = myHeapify(arr, indexToChange, n);
        }

        return arr;
    }
}
