package HW_5;

import java.util.Arrays;

/*
Реализовать алгоритм пирамидальной сортировки (HeapSort).
(Можно использовать массивы)
*/
public class Ex003 {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        Ex003 task = new Ex003();
        task.heapSort(arr);

        System.out.println("Отсортированный массив: \n" + Arrays.toString(arr));
    }


    public void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            makeHeap(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            makeHeap(arr, i, 0);
        }
    }

    void makeHeap(int[] arr, int n, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[max]) {
            max = left;
        }

        if (right < n && arr[right] > arr[max]) {
            max = right;
        }

        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            makeHeap(arr, n, max);
        }
    }
}
