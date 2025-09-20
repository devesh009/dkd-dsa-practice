package com.dev.arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 02/01/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */

@Slf4j
public class ArrayEasySol {

    // Linear search based problems

    public int countDigits(int num) {
        if (num < 0) {
            num *= -1;
        }
        int count = 0;

        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    public int findCount1(int num) {
        num = num < 0 ? -num : num;
        return (int) Math.log10(num) + 1;
    }

    public int findEvenCount(int[] arr) {
        int count = 0;
        if (arr == null) return count;
        for (int n : arr) {
            if (n % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public int findRichest(int[][] acc) {
        int ans = Integer.MIN_VALUE;

        for (int[] a : acc) {
            int totalMoney = 0;
            for (int money : a) {
                totalMoney += money;
            }
            ans = Math.max(ans, totalMoney);
        }
        return ans;
    }

    // Binary Search

    /**
     * Performs a binary search to find the index of the target value in a sorted array.
     * Returns the index if found, otherwise returns -1.
     * Note: The implementation contains a bug and may not work as expected.
     *
     * @param arr    the sorted array to search
     * @param target the value to search for
     * @return the index of the target if found, otherwise -1
     */
    public int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            //int mid = (start + end)/2; // this may exceed the int range value
            int mid = start + (end - start) / 2;
            int curr = arr[mid];
            if (curr == target) return mid;

            if (curr > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int orderAgnosticBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        // best way to find asc or desc always compare first and last element
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            //int mid = (start + end)/2; // this may exceed the int range value
            int mid = start + (end - start) / 2;
            int curr = arr[mid];
            if (curr == target) return mid;
            if (!isAsc) {
                if (curr > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (curr > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }
        return -1;
    }
    /**
     * Finds the smallest element in a sorted array that is greater than or equal to the target value (the ceil).
     * If such an element does not exist, returns Integer.MAX_VALUE.
     *
     * @param arr the sorted array to search
     * @param target the value to find the ceil for
     * @return the ceil value if found, otherwise Integer.MAX_VALUE
     */
    public int findCeilNumInSortedArr(int[] arr, int target){
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = arr.length  - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            int curr = arr[mid];
            if(curr >= target){
                ans = Math.min(ans, curr);
            }

            if(curr > target){
                end = mid - 1;
            }else{
             start = mid + 1;
            }

        }
        return ans;
    }


}
