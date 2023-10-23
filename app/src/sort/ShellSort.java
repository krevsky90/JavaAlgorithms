package sort;

/**
 * http://java.dzone.com/articles/algorithm-week-shell-sort
 */
public class ShellSort extends CommonSorter {
    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        int gap = n / 2;
        while (gap > 0) {
            System.out.println("gap = " + gap);
            for (int i = gap; i < n; i++) {
                System.out.println("\ti = " + i);
                int temp = arr[i];
                System.out.println("\ttemp = " + temp);
                int j = i;
                System.out.println("\tj = " + j);

                while (j >= gap && arr[j - gap] > temp) {
                    System.out.println("\tj = " + j);
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = temp;
                util.printArray(arr);
                System.out.println();
            }

            gap = gap / 2;
        }

        return arr;
    }
}
