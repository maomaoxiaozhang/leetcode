package Study.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/10/24.
 */
public class Test {
    public static void main(String[] args) {
        int[] array = {3, 8, 1, 7, 9, 5, 2, 6, 4};
        quickSort(array, 0, 8);
        print(array);
    }

    /*
    =======================================================冒泡=========================================================
    外层i用于控制循环次数；内层j用于每次从1遍历，相邻两两比较
    每次确定的为最大值，所以j从1开始
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length-i; j++) {
                if (array[j-1] > array[j])
                    swap(j-1, j, array);
            }
        }
    }

    /*
    =======================================================选择=========================================================
    外层i为确定每次最小值的位置；内层j为每次遍历的起始点i+1
    每次确定的为最小值，所以j从i+1开始
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++)
                if (array[j] < array[min])
                    min = j;
            swap(i, min, array);
        }
    }

    /*
    =======================================================插入=========================================================
    小心 swap 会多换一次，而 array[j+1] = get 赋值的方式不会！
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int get = array[i], j = i-1;
            for (; j >= 0; j--) {
                if (array[j] > get)
                    swap(j, j+1, array);
                else
                    break;
            }
            array[j+1] = get;
        }
    }

    /*
    ========================================================堆==========================================================
    堆的操作分为建堆 build 和稳定 heapify，每次确定最大值与最后一个交换再次进行平衡
    用于确定最大的k个数
     */
    public static void heapSort(int[] array) {
        build(array, array.length-1);
        for (int i = 0; i < array.length; i++) {
            swap(0, array.length-1-i, array);
            heapify(array, 0, array.length-2-i);
        }
    }

    public static void build(int[] array, int size) {
        for (int i = (size-1)/2; i >= 0; i--)
            heapify(array, i, size);
    }

    public static void heapify(int[] array, int i, int size) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int max = i;
        if (left <= size && array[left] > array[max])
            max = left;
        if (right <= size && array[right] > array[max])
            max = right;
        swap(max, i, array);
        if (max != i)
            heapify(array, max, size);
    }

    /*
    =======================================================归并=========================================================
     */
    public static void mergeSort(int[] array, int left, int right) {
        if (left == right)
            return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right-left+1];
        int i = left, j = mid+1, index = 0;
        while (i <= mid && j <= right)
            temp[index++] = array[i] < array[j] ? array[i++] : array[j++];
        while (i <= mid)
            temp[index++] = array[i++];
        while (j <= right)
            temp[index++] = array[j++];
        for (i = 0; i < index; i++)
            array[left + i] = temp[i];
    }

    /*
    =======================================================快排=========================================================
    左 < 右，左右不相见！
     */
    public static void quickSort(int[] array, int i, int j) {
        if (i > j)
            return;
        int left = i, right = j, temp = array[left];
        while (left < right) {
            while (left < right && array[right] >= temp)
                right--;
            while (left < right && array[left] <= temp)
                left++;
            if (left < right) {
                swap(left, right, array);
            }
        }
        array[i] = array[left];
        array[left] = temp;
        quickSort(array, i, left-1);
        quickSort(array, left+1, j);
    }

    /*
    =======================================================计数=========================================================
     */


    /*
    =======================================================基数=========================================================
     */


    /*
    ========================================================桶==========================================================
     */

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void print(int[] array) {
        Arrays.stream(array)
                .forEach(System.out::println);
    }
}
