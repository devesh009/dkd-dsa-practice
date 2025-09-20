package com.dev.arrays;

/**
 * Created on 13/09/2025
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
public class ArrayUtility {
    private ArrayUtility() {
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverseByRange(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void reverseArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int t = arr[r];
            arr[r] = arr[l];
            arr[l] = t;
            r--;
            l++;
        }
    }
}
