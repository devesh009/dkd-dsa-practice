package com.dev.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created on 07/02/2025
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
class ArraySolutionsTest {
    ArraySolutions solution = new ArraySolutions();

    @Test
    void nextPermutation() {
        int[] nums = {2, 1, 5, 4, 3, 0, 0};
        solution.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    @Test
    void findSpanOfArray() {
    }

    @Test
    void findIndexofElement() {
    }

    @Test
    void createBarChart() {
    }

    @Test
    void reverseArrayArray() {
    }

    @Test
    void getSumOfArray() {
    }

    @Test
    void getDiffOfArray() {
    }

    @Test
    void getSumOfArrayMine() {
    }

    @Test
    void rotateByKShiftArrByNPlace() {
    }

    @Test
    void moveAllZerosToEnd() {
    }

    @Test
    void unionOfSortedArr() {
    }

    @Test
    void intersectionOfSortedArr() {
    }

    @Test
    void largestElementInArr() {
    }

    @Test
    void secondLargestElement() {
    }

    @Test
    void checkSortedArray() {
    }

    @Test
    void removeDuplicate() {
    }

    @Test
    void removeDuplicate1() {
    }

    @Test
    void maxSubArray() {
    }

    @Test
    void subarraySum() {
    }

    @Test
    void testNextPermutation() {
    }

    @Test
    void maxStockProfit() {
    }

    @Test
    void testLongestSubArrayWithSumK() {
        int[] a = {2, 3, 5, 1, 9};
        int k = 10;
        int len = solution.longestSubarray(a, k);
        System.out.println("The length of the longest subarray is: " + len);

    }

    @Test
    void findCandidate() {
        int[] arr = {6,5,5};
        int ans = solution.findCandidate(arr);
        System.out.println("The majority element is: " + ans);
    }

    @Test
    void printRect() {
        solution.printRect(6);

    }


    @Test
    void divisorQueries() {
        int N = 5;
        int Q = 3;
        int[] a = {10, 15, 20, 25, 30};
        int[][] Queries = {
                {1, 1, 3},
                {2, 1, 5},
                {3, 2, 50}
        };

        List<Long> results = solution.divisorQueries(N, Q, a, Queries);
        for (Long result : results) {
            System.out.println(result);
        }
    }
}