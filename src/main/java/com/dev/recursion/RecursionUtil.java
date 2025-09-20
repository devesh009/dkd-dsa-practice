package com.dev.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 23/08/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public final class RecursionUtil {
    public static void swap(Integer[] arr, Integer start, Integer end) {
        Integer temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void mergeSortedArray(Integer[] a, int low, int mid, int high) {
        int first = low;
        int second = mid + 1;

        List<Integer> sorted = new ArrayList<>();
        while (first <= mid && second <= high) {
            sorted.add(Math.min(a[first], a[second]));
            if (a[first] <= a[second]) first++;
            else second++;
        }
        while (first <= mid) {
            sorted.add(a[first]);
            first++;
        }
        while (second <= mid) {
            sorted.add(a[first]);
            second++;
        }
        int x = low;
        for (int num : sorted) {
            a[x] = num;
            x++;
        }
    }

    public static int findPivotIndex(Integer[] arr, int low, int high) {
        int i = low;
        int j = high;
        int pivot = arr[low];

        while (i < j) {
            while (pivot >= arr[i] && i<=high-1) {
                i++;
            }
            while (pivot < arr[j] && j>=low+1) {
                j--;
            }
            if(i<j)swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

}
