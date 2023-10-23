package utils;

public class MyUtil {
    public void printArray(int[] arr) {
        System.out.println(arrayToString(arr));
    }

    public String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < arr.length-1; i++) {
            sb.append(arr[i]).append(", ");
        }
        sb.append(arr[arr.length-1]).append("}");
        return sb.toString();
    }

    public int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = getRandomValue();
        }
        return arr;
    }

    public int[] generateUniqueRandomArray(int size) {
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = generateUniqueValue(arr);
        }
        return arr;
    }

    public int generateUniqueValue(int[] arr) {
        int value = getRandomValue();
        while (!isUnique(arr, value)) {
            value = getRandomValue();
        }

        return value;
    }

    public boolean isUnique(int[] arr, int value) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == value) {
                return false;
            }
        }

        return true;
    }

    public int getRandomValue() {
        return (int) (Math.random()*11);
    }
}
