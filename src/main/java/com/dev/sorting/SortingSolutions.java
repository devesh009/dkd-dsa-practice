package com.dev.sorting;

import static com.dev.sorting.SortUtils.swapArr;

/**
 * Created on 03/09/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public class SortingSolutions {

    /**
     * select min and put it at first
     * TC = O(n^2);
     *
     * @param arr
     */
    public void selectionSort(int[] arr) {

        int n = arr.length;
        // last element will always be sorted
        for (int i = 0; i < n - 1; i++) {

            // swap min it will give sort array from start
            for (int k = i + 1; k < n; k++) {
                if (arr[k] < arr[i]) {
                    SortUtils.swapArr(arr, k, i);
                }
            }
        }
    }

    /**
     * reduced swap operations but TC will remain same
     * TC = O(n^2);
     *
     * @param arr
     */
    public void selectionSort1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n - 2; i++) {
            int min = i;
            for (int j = i + 1; j <= n - 1; j++) {
                min = arr[j] < arr[min] ? j : min;
            }
            if (min != i) {
                swapArr(arr, i, min);
            }
        }
    }

    /**
     * this algo bubbles up greatest element and put it in the end by comparing
     * adjacent element and swapping them. This process starts from the start of array and
     * eventually from the end of array it start becoming sorted
     * <p>
     * TC = O(n^2), Best case = O(n)
     *
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        int n = arr.length;

        // this variable is used for small optimization in case arr is already sorted then TC = O(n)
        int didSwap = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtils.swapArr(arr, j, j + 1);
                    didSwap = 1;
                }
            }
            // if didSwap equals 0 it means arr is already sorted
            if (didSwap == 0) break;
        }

    }

    public void bubbleSort1(int[] arr) {
        int n = arr.length;
        int first = 0;
        int second = 1;

        while (n > 0) {
            while (second <= n - 1) {
                if (arr[first] > arr[second]) {
                    SortUtils.swapArr(arr, first, second);
                }
                first++;
                second++;
            }
            n--;
            first = 0;
            second = 1;
        }
    }

    /**
     * put element at right position
     * uses increasing window concept where we put last element of arr to its right position by swapping
     * till arr[0]
     * <p>
     * TC = O(n^2), best case = O(n)
     *
     * @param arr
     */
    public void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) SortUtils.swapArr(arr, j, j - 1);
            }
        }

    }

    /**
     * Here we keep breaking the array till the smallest block and the sort it and then
     * merge the sorted result
     * <p>
     * <p>
     * since it divided by 2 it will log2
     * TC = O(n*log2(n)), SC = O(n)
     *
     * @param arr
     * @param i
     * @param j
     */
    public void mergeSort(int[] arr, int i, int j) {
        if (i == j) return;
        int mid = (i + j) / 2;
        mergeSort(arr, i, mid);
        mergeSort(arr, mid + 1, j);
        merge(arr, i, mid, j);
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int l = low, r = mid + 1;

        int[] ansSortedArr = new int[high - low + 1];
        int sortedIndex = 0;
        while (l <= mid && r <= high) {
            if (arr[l] > arr[r]) {
                ansSortedArr[sortedIndex] = arr[r];
                r++;
            } else {
                ansSortedArr[sortedIndex] = arr[l];
                l++;
            }
            sortedIndex++;
        }
        while (l <= mid) {
            ansSortedArr[sortedIndex] = arr[l];
            l++;
            sortedIndex++;
        }
        while (r <= high) {
            ansSortedArr[sortedIndex] = arr[r];
            r++;
            sortedIndex++;
        }

        for (int num : ansSortedArr) {
            arr[low++] = num;
        }
    }

    /**
     * keep the first element to its correct position find the
     * pivot repeat the same for all left and right array
     * <p>
     * TC = n log(n), SC = O(1)
     *
     * @param arr
     * @param i
     * @param j
     */
    public void quickSort(int[] arr, int i, int j) {

        if (i < j) {
            int partitionIndex = findPivot(arr, i, j);
            quickSort(arr, i, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, j);
        }

    }

    private int findPivot(int[] arr, int i, int j) {

        int pivot = arr[i];
        int greaterEelementIndex = i;
        int smallerElementIndex = j;
        while (greaterEelementIndex < smallerElementIndex) {
            while (arr[greaterEelementIndex] <= pivot && greaterEelementIndex < j) {
                greaterEelementIndex++;
            }
            while (arr[smallerElementIndex] > pivot && smallerElementIndex > i) {
                smallerElementIndex--;
            }

            if (greaterEelementIndex < smallerElementIndex) swapArr(arr, smallerElementIndex, greaterEelementIndex);

        }
        swapArr(arr, i, smallerElementIndex);
        return smallerElementIndex;
    }
}
