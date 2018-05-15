package Study.sort;

import java.util.Arrays;

/**
 * Created by lenovo on 2018/1/24.
 * 自下向上建堆，自顶向下维稳
 * 堆只保证根为最值，不保证左右大小关系
 */
public class HeapSort {
    public static void swap(int[] array, int m, int n) {
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }

    //自顶向下递归维稳
    public static void heapify(int[] array, int pos, int size) {
        int left = 2 * pos + 1;
        int right = 2 * pos + 2;
        int max = pos;
        if (left <= size && array[left] > array[max])
            max = left;
        if (right <= size && array[right] > array[max])
            max = right;
        if (max != pos) {
            swap(array, pos, max);
            heapify(array, max, size);
        }
    }

    //自下向上建堆
    public static void build(int[] array, int size) {
        for (int i = (size-1)/2; i >= 0; i--) {
            heapify(array, i, size);
        }
    }

    public static void heapSort(int[] array) {
        int size = array.length-1;
        build(array, size);
        while (size >= 0) {
            swap(array, 0, size--);
            heapify(array, 0, size);
        }
    }

    public static void main(String[] args) {
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4};
        heapSort(array);
        Arrays.stream(array).forEach(System.out::println);
    }
}
