package com.dev.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.dev.arrays.ArrayUtility.reverseByRange;
import static com.dev.arrays.ArrayUtility.swap;

/**
 * Created on 02/01/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */

@Slf4j
public class ArraySolutions {

    // Find span of array
    public int findSpanOfArray(int[] arr) {

        int smallest = Integer.MAX_VALUE;
        int greatest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > greatest) {
                greatest = num;
            }
            if (num < smallest) {
                smallest = num;
            }
        }
        return (greatest - smallest);
    }

    //Find index of element

    public void findIndexofElement(int n, int[] arr, int num) {
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == num) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }

    // Create a bar chart
    public void createBarChart(int n, int[] arr) {
        int column = n;
        int row = Integer.MIN_VALUE;
        for (Integer num : arr) {
            if (num > row) row = num;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int height = row - i;
                if (height > arr[j]) {
                    System.out.print("\t");
                } else {
                    System.out.print("\t*");
                }
            }
            System.out.println("");
        }

      /*  int maxHeight = arr[0];
        for (int num : arr) {
            if (maxHeight < num) {
                maxHeight = num;
            }
        }

        for (int i = maxHeight; i >= 1; i--) {
            for (int j = 0; j < n; j++) {
                if (arr[j] < (i)) {
                    System.out.print("\t");
                } else {
                    System.out.print("*\t");
                }
            }
            System.out.println("");
        }*/
    }
    // Reverse array using extra space

    public void reverseArray(int[] a1) {
        int j = 0;
        int[] a2 = new int[a1.length];
        for (int i = a1.length - 1; i >= 0; i--) {
            a2[j++] = a1[i];
        }
        for (int a : a2) {
            System.out.println(a);
        }
    }

    // Sum of two Array

    public void getSumOfArray(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;

        int[] sum = new int[length1 >= length2 ? length1 : length2];

        int l1 = length1 - 1;
        int l2 = length2 - 1;
        int l3 = sum.length - 1;
        int carry = 0;
        while (l3 >= 0) {
            if (l1 < 0 && l2 >= 0) {
                sum[l3] = (arr2[l2] + carry) % 10;
                carry = (arr2[l2] + carry) / 10;
            }

            if (l2 < 0 && l1 >= 0) {
                sum[l3] = (arr1[l1] + carry) % 10;
                carry = (arr1[l1] + carry) / 10;
            }

            if (l1 >= 0 && l2 >= 0) {
                sum[l3] = (arr1[l1] + arr2[l2]) % 10;
                carry = (arr1[l1] + arr2[l2]) / 10;
            }

            l1--;
            l2--;
            l3--;
        }

        if (carry > 0) System.out.print(carry + "\t");
        for (int a : sum) System.out.print(a + "\t");
        System.out.println("");
    }

    public void getDiffOfArray(int[] arr1, int[] arr2) {
        int diffLength = arr1.length > arr2.length ? arr1.length : arr2.length;

        int[] diff = new int[diffLength];
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = diffLength - 1;
        int carry = 0;
        while (k >= 0) {
            int temp;
            int arr2v = j >= 0 ? arr2[j] : 0;
            if ((arr1[i] + carry) >= arr2v) {
                temp = arr1[i] + carry - arr2v;
                carry = 0;
            } else {
                temp = arr1[i] + carry + 10 - arr2v;
                carry = -1;
            }

            diff[k] = temp;
            i--;
            j--;
            k--;
        }

        for (int a : diff) {
            System.out.print(a + "\t");
        }

    }

    public void getSumOfArrayMine(int[] arr1, int[] arr2) {
        int max = Math.max(arr1.length, arr2.length);
        int[] ans = new int[max + 1];

        int carry = 0;
        int place = ans.length - 1;
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        while (place > -1) {
            int value = carry;
            if (i > -1) value += arr1[i];
            if (j > -1) value += arr2[j];
            carry = value / 10;
            ans[place] = value % 10;
            j--;
            i--;
            place--;
        }
        if (carry != 0) {
            ans[0] = carry;
        }
        for (int k : ans) {
            System.out.print(" " + k);
        }
    }

    public void moveAllZerosToEnd(int[] arr) {
        int firstPosition = -1;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] == 0 && firstPosition == -1) {
                firstPosition = i;
            }
            if (arr[i] != 0 && firstPosition > -1) {
                swap(arr, firstPosition, i);
                firstPosition++;
            }

        }
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    public void unionOfSortedArr(int[] arr, int[] arr1) {
        int i = 0;
        int k = 0;
        List<Integer> union = new ArrayList<>();
        if (arr[i] <= arr1[k]) {
            union.add(arr[i]);
            i++;
        } else {
            union.add(arr1[k]);
            k++;
        }
        while (i < arr.length && k < arr1.length) {
            if (arr[i] <= arr1[k]) {
                if (union.get(union.size() - 1) != arr[i]) {
                    union.add(arr[i]);
                }
                i++;
            } else if (arr[i] > arr1[k]) {
                if (union.get(union.size() - 1) != arr1[k]) {
                    union.add(arr1[k]);
                }
                k++;
            }
        }
        while (i < arr.length) {
            if (union.get(union.size() - 1) != arr[i]) {
                union.add(arr[i]);
            }
            i++;
        }
        while (k < arr1.length) {
            if (union.get(union.size() - 1) != arr1[k]) {
                union.add(arr1[k]);
            }
            k++;
        }
        for (Integer num : union) {
            System.out.print(num + "\t");
        }
    }

    public void intersectionOfSortedArr(int[] A, int[] B) {
        int i = 0;
        int j = 0;
        int k = A.length;
        int m = B.length;
        List<Integer> ans = new ArrayList<>();
        while (i < k && j < m) {
            if (A[i] < B[j]) {
                i++;
            } else if (A[i] > B[j]) {
                j++;
            } else {
                ans.add(A[i]);
                i++;
                j++;
            }
        }
        for (Integer num : ans) {
            System.out.print(num + "\t");
        }

    }

    // ****************** Easy Level ************************************

    public void largestElementInArr(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        System.out.println("Largest element is " + max);
    }

    public void secondLargestElement(int[] arr) {
        int secondLargest = Integer.MIN_VALUE;
        int largest = arr[0];
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            }
            if (secondLargest < num && num < largest) {
                secondLargest = num;
            }
        }
        System.out.println("Second largest integer  : " + secondLargest);
    }

    public void checkSortedArray(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                System.out.println("This is an unsorted array");
                break;
            }
        }
    }

    public void removeDuplicate(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) ans.add(arr[i]);
        }

        for (int num : ans) {
            System.out.print(num + "\t");
        }
    }

    public void removeDuplicate1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int i, j;
        for (i = 0, j = 1; j < arr.length; ) {
            if (arr[i] != arr[j]) {
                arr[i + 1] = arr[j];
                i++;
                j++;
            } else {
                j++;
            }
        }

        for (int k = 0; k <= i; k++) {
            System.out.println(arr[k]);
        }
    }

    /**
     * rotate by reversing the array approach
     *
     * @param nums
     * @param k
     */
    public void rotateByKShift(int[] nums, int k) {
        k %= nums.length;
        reverseByRange(nums, 0, nums.length - 1);
        reverseByRange(nums, 0, k - 1);
        reverseByRange(nums, k, nums.length - 1);
    }

    /**
     * using 2 pointer approach
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int write = 0, read = 0;
        while (write < nums.length && read < nums.length) {
            if (nums[read] != 0) {
                nums[write] = nums[read];
                write++;
                read++;
            } else {
                read++;
            }
        }

        while (write < nums.length) {
            nums[write] = 0;
            write++;
        }
    }

    /**
     * Search in a sorted array
     *
     * @param arr
     * @param k
     * @return
     */
    boolean searchInSorted(int arr[], int k) {
        if (arr == null) return false;

        for (int num : arr) {
            if (num == k) return true;
        }
        return false;

    }

    /**
     * Function to return a list containing the union of the two arrays.
     *
     * @param a
     * @param b
     * @return
     */
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here

        int i = 0;
        int j = 0;
        ArrayList<Integer> ls = new ArrayList<>();
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                if (ls.size() == 0 || ls.get(ls.size() - 1) != a[i]) {
                    ls.add(a[i]);
                }
                i++;
            } else {
                if (ls.size() == 0 || ls.get(ls.size() - 1) != b[j]) {
                    ls.add(b[j]);
                }
                j++;
            }
        }

        while (i < a.length) {
            if (ls.size() == 0 || ls.get(ls.size() - 1) != a[i])
                ls.add(a[i]);
            i++;
        }

        while (j < b.length) {
            if (ls.size() == 0 || ls.get(ls.size() - 1) != b[j])
                ls.add(b[j]);
            j++;
        }

        return ls;
    }

    /**
     * Return the missing number
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int sum = (n * (n + 1)) / 2;

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        int missingNum = sum - actualSum;
        return missingNum;

    }

    /**
     * Find the maximum consecutive ones
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {


        int ans = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp++;
            } else {
                temp = 0;
            }
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    /**
     * Find single number
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            ans = ans ^ n;
        }
        return ans;

    }

    /**
     * Find the longest subarray with sum k
     * Below code is brute force approach
     *
     * @param arr
     * @param k
     * @return
     */
    public int longestSubarray(int[] arr, int k) {

        int n = arr.length;
        int length = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = i; j < n; j++) {
                temp += arr[j];
                if (temp == k) {
                    length = Math.max(length, j - i + 1);
                }
            }
        }

        return length;
        // code here
    }

    /**
     * Find the longest subarray with sum k
     * Below code is optimized approach using hashmap space complexity is O(n)
     *
     * @param arr
     * @param k
     * @return
     */
    public int longestSubarray1(int[] arr, int k) {

        int n = arr.length;
        int len = 0;
        int temp = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        for (int i = 0; i < n; i++) {
            temp += arr[i];
            if (temp == k) {
                len = i + 1;
            }
            Integer rem = temp - k;
            if (preSum.containsKey(rem)) {
                len = Math.max(i - preSum.get(rem), len);
            }

            if (!preSum.containsKey(temp)) {
                preSum.put(temp, i);
            }
        }
        return len;
    }

    /**
     * TODO: Need to fix this
     * Find the longest subarray with sum k
     * Below code is optimized approach without using hashmap space complexity is O(1)
     * we are using 2 pointers here but its not working
     *
     * @param a
     * @param k
     * @return
     */
    public int longestSubarray2(int[] a, int k) {
        int n = a.length; // size of the array.

        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }

    // ****************** Medium Level ************************************

    /**
     * 2 Sum problem
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
        }
        return ans;
    }

    /**
     * sort the array of 0, 1, 2
     * The Dutch National Flag algorithm is used to sort an array of 0s, 1s, and 2s
     * in linear time.
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, low++, mid++);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high--);
                    break;
            }
        }
    }

    /**
     * Moore's Voting Algorithm is used to find the majority element in an array,
     * which is the element that appears more than n/2 times. Here is the implementation in Java:
     * Explanation
     * Phase 1: Find a candidate for the majority element.
     * Phase 2: Verify if the candidate is indeed the majority element.
     *
     * @param nums
     * @return
     */

    public int findCandidate(int[] nums) {
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }


    /**
     * Find the maximum sum subarray
     * Kadan's Algorithm is used to find the maximum sum subarray in an array. Here is the implementation in Java:
     * Explanation
     * Initialization: Initialize currSum and maxSum with the first element of the array.
     * Traversal: Traverse the array from the second element.
     * Update Current Sum: Update currSum to be the maximum of the current element and the sum of currSum and the current element.
     * Update Maximum Sum: Update maxSum to be the maximum of maxSum and currSum.
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int currSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    /**
     * Find the maximum profit
     * The maximum profit that can be obtained from a stock is the difference between the maximum price and the minimum price.
     * Here is the implementation in Java:
     * Explanation
     * Initialization: Initialize the profit to be 0 and the minimum price to be the first element of the array.
     * Traversal: Traverse the array from the second element.
     * Update Minimum Price: Update the minimum price to be the minimum of the current element and the minimum price.
     * Update Maximum Profit: Update the profit to be the maximum of the difference between the current element and the minimum price and the profit.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - min;
            profit = Math.max(cost, profit);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }

    /**
     * To find the maximum profit from stock prices with a difference of at least 5 seconds between the buy and sell times, you can modify the algorithm to include a condition that ensures the time difference constraint. Here's a Java implementation:
     * Explanation
     * Initialize Variables: Use variables to keep track of the minimum price and the maximum profit.
     * Iterate Through Prices: For each price, update the minimum price and calculate the potential profit, ensuring the time difference constraint.
     * Update Maximum Profit: If the potential profit is greater than the current maximum profit and the time difference is at least 5 seconds, update it.
     * Code
     * Find the maximum profit with time constraint of 5 seconds
     *
     * @param prices
     * @return
     */
    public static int maxProfitWithTimeConstraint(int[] prices) {
        if (prices == null || prices.length < 6) {
            return 0;
        }

        int maxProfit = 0;

        for (int i = 5; i < prices.length; i++) {
            for (int j = 0; j <= i - 5; j++) {
                int profit = prices[i] - prices[j];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    /**
     * You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
     * You should return the array of nums such that the the array follows the given conditions:
     * <p>
     * Every consecutive pair of integers have opposite signs.
     * For all integers with the same sign, the order in which they were present in nums is preserved.
     * The rearranged array begins with a positive integer.
     * Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
     *
     * @param nums
     * @return
     */
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int pos = 0;
        int neg = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                ans[neg] = nums[i];
                neg = neg + 2;
            } else {
                ans[pos] = nums[i];
                pos = pos + 2;
            }
        }
        return ans;
    }

    /**
     * Find the largest index k such that nums[k] < nums[k + 1]. If no such index exists, the permutation is the last permutation.
     * Find the largest index l greater than k such that nums[k] < nums[l].
     * Swap the value of nums[k] with that of nums[l].
     * Reverse the sequence from nums[k + 1] up to and including the final element nums[nums.length - 1].
     * Here is the Java code to achieve this:
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int k = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            reverseByRange(nums, 0, nums.length - 1);
            return;
        }
        int l = -1;
        for (int i = nums.length - 1; i > k; i--) {
            if (nums[i] > nums[k]) {
                l = i;
                break;
            }
        }
        swap(nums, k, l);
        reverseByRange(nums, k + 1, nums.length - 1);
    }

    /**
     * find the leaders in the array
     * leaders are the elements which are greater than all the elements
     * to its right side
     *
     * @param arr
     * @return
     */
    public ArrayList<Integer> leaders(int arr[]) {
        // code here

        int g = Integer.MIN_VALUE;
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= g) {
                ans.add(arr[i]);
            }
            g = Math.max(g, arr[i]);
        }
        Collections.reverse(ans);
        return ans;
    }

    /**
     * Find the longest consecutive subsequence
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 1;
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int x = i;
                int count = 1;
                while (set.contains(x + 1)) {
                    x += 1;
                    count += 1;
                }

                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    /**
     * set matrix row and column to zero if any element is zero
     * Extra space is used to store the row and column index
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {

        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * set matrix row and column to zero if any element is zero
     * Extra space is not used to store the row and column index
     * space complexity is O(1)
     *
     * @param matrix
     * @param n
     * @param m
     * @return
     */
    public ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int[] row = new int[n]; // row array
        int[] col = new int[m]; // col array

        // Traverse the matrix:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    // mark ith index of row wih 1:
                    row[i] = 1;

                    // mark jth index of col wih 1:
                    col[j] = 1;
                }
            }
        }
        // Finally, mark all (i, j) as 0
        // if row[i] or col[j] is marked with 1.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }

    public void printRect(int n) {

        int[][] matrix = new int[n][n];
        int num = 1;

        // Fill the matrix with numbers from 1 to n*n
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = num++;
            }
        }

        // Print the matrix in diagonal sequence
        for (int line = 1; line <= (n + n - 1); line++) {
            int startCol = Math.max(0, line - n);
            int count = Math.min(line, Math.min((n - startCol), n));
            for (int j = 0; j < count; j++) {
                System.out.print(matrix[Math.min(n, line) - j - 1][startCol + j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * rotate matrix by 90 degree
     *
     * @param matrix
     */
    public void rotateMatrixBy90(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }
        // Reverse each row
        for (int i = 0; i < n; i++) {
            reverseArray(matrix[i]);
        }
    }



    /**
     * Print the matrix in spiral form
     *
     * @param mat
     * @return
     */
    public static List<Integer> printSpiral(int[][] mat) {

        // Define ans list to store the result.
        List<Integer> ans = new ArrayList<>();
        int n = mat.length; // no. of rows
        int m = mat[0].length; // no. of columns

        // Initialize the pointers required for traversal.
        int top = 0, left = 0, bottom = n - 1, right = m - 1;

        // Loop until all elements are not traversed.
        while (top <= bottom && left <= right) {

            // For moving left to right
            for (int i = left; i <= right; i++)
                ans.add(mat[top][i]);

            top++;

            // For moving top to bottom.
            for (int i = top; i <= bottom; i++)
                ans.add(mat[i][right]);

            right--;

            // For moving right to left.
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    ans.add(mat[bottom][i]);

                bottom--;
            }

            // For moving bottom to top.
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(mat[i][left]);

                left++;
            }
        }
        return ans;
    }

    /**
     * Find total count of subarray with sum k
     *
     * @param nums
     * @param k
     * @return
     */
    public int totalNumOfSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int preSum = 0;
        int count = 0;
        for (int n : nums) {
            preSum += n;
            int rem = preSum - k;
            count += map.getOrDefault(rem, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    /**
     * print pascals triangle
     * (row-1) C (col-1) this formula is used to calculate the value of pascals triangle
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                temp.add(nCr(i - 1, j - 1));
            }
            ans.add(temp);
        }
        return ans;
    }

    private int nCr(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    /**
     * To find the repeated number in the array without modifying the array and using only constant extra space, you can use Floyd's Tortoise and Hare (Cycle Detection) algorithm.
     * The findDuplicate method uses Floyd's Tortoise and Hare (Cycle Detection) algorithm to find the duplicate number in an array without modifying the array and using only constant extra space. Here's a step-by-step explanation:
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        // Initialize the slow and fast pointers
        int slow = nums[0];
        int fast = nums[0];

        // Move slow pointer by one step and fast pointer by two steps
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Find the entrance to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    /**
     * Repeat and Missing Number Array
     * Find the missing number in the array
     *
     * @param A
     * @return
     */
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();

        int xor = 0;

        for (int i = 0; i < A.size(); i++) {
            xor = xor ^ A.get(i);
            xor = xor ^ (i + 1);
        }
        int rsb = xor & -xor;
        int x = 0;
        int y = 0;
        for (Integer i : A) {
            if ((rsb & i) == 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        for (int i = 1; i <= A.size(); i++) {
            if ((rsb & i) == 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        for (Integer i : A) {
            if (x == i) {
                ans.add(x);
                ans.add(y);
                break;
            }
            if (y == i) {
                ans.add(y);
                ans.add(x);
                break;
            }
        }
        return ans;
    }

    /**
     * @param A
     * @param n
     * @return
     */
    int maxLen(int A[], int n) {
        // Your code here
        HashMap<Integer, Integer> mpp = new HashMap<>();

        int maxi = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum += A[i];

            if (sum == 0) {
                maxi = i + 1;
            } else {
                if (mpp.get(sum) != null) {

                    maxi = Math.max(maxi, i - mpp.get(sum));
                } else {

                    mpp.put(sum, i);
                }
            }
        }
        return maxi;
    }

    public List<Long> divisorQueries(int N, int Q, int[] a, int[][] Queries) {
        List<Long> results = new ArrayList<>();

        for (int[] query : Queries) {
            int type = query[0];
            int l = query[1] - 1; // Convert to 0-based index
            int r = query[2] - 1; // Convert to 0-based index

            if (type == 1) {
                for (int i = l; i <= r; i++) {
                    a[i] = a[i] / smallestPrimeFactor(a[i]);
                }
            } else if (type == 2) {
                long sum = 0;
                for (int i = l; i <= r; i++) {
                    sum += a[i];
                }
                results.add(sum);
            } else if (type == 3) {
                int i = l; // For type 3, l is the index and r is the new value
                int k = query[2];
                a[i] = k;
            }
        }

        return results;
    }

    private static int smallestPrimeFactor(int n) {
        if (n <= 1) return n;
        if (n % 2 == 0) return 2;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return i;
        }
        return n;
    }

    public int findInRotatedSortedArray(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Determine which part is sorted
            if (nums[left] <= nums[mid]) {
                // Left part is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right part is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1; // Target not found
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static int lengthOfShortestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        int requiredUniqueCount = uniqueChars.size();
        Map<Character, Integer> windowCounts = new HashMap<>();
        int left = 0, right = 0, formed = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (uniqueChars.contains(c) && windowCounts.get(c).intValue() == 1) {
                formed++;
            }

            while (left <= right && formed == requiredUniqueCount) {
                c = s.charAt(left);
                minLength = Math.min(minLength, right - left + 1);

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (uniqueChars.contains(c) && windowCounts.get(c).intValue() == 0) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    /**
     * There is a small, one-way bridge that can carry a maximum weight of U units at a time. There is also a line of N cars
     * waiting to cross the bridge. The weights of the cars are given as an array weight. The weight of the K-th car in the
     * line is weight [K] (for K within the range [O..N-1]). The car that will enter the bridge first weighs weight [0],
     * the car that will enter second weighs weight [1], and so on. At most two cars can be on the bridge at the same time.
     * To begin, the first two cars in line will enter the bridge. Then the third car will enter the bridge as soon as the first
     * car leaves the bridge, the fourth car will enter when the second car leaves, and so on. The cars leave the bridge in the
     * same order they entered it. However, this may lead to a situation where cars exceed the bridge's weight limit. To
     * prevent such a situation, some drivers have to turn back. When a driver turns back, all drivers behind them in line
     * move one position closer to the bridge. The driver who turns back is removed from the line and will not try to cross
     * the bridge again. Your task is to find the minimum number of drivers that must turn back so that the bridge will not be
     * overloaded. Write a function: class Solution { public int solution(int U, int[] weight); } that, given an integer U
     * representing the weight limit of the bridge and an array weight of N integers representing the weights of the cars in
     * line, returns the minimum number of drivers that must turn back so that the bridge will not be overloaded.
     * Examples:
     * For U = 9 and weight = [5, 3, 8, 1, 8, 7, 7, 6), the function should return 4. After the 3rd, 5th, 6th and 7th cars turn back, the weights of the remaining cars in line are [5, 3, 1, 6]. Notice that instead of the 5th, 6th and 7th cars, any three of the last four cars can turn back to obtain an optimal answer. The cars will then cross the bridge as follows: During this process, the total weight of cars on the bridge does not exceed 9.
     * For U = 7 and weight = [7, 6, 5, 2, 7, 4, 5, 4), the function should return 5. After the 1st, 2nd, 5th, 6th and 7th cars turn back, the weights of the remaining cars in line are [5, 2, 4). Notice that instead of the 6th and 7th cars, any two of the last three cars can turn back to obtain an optimal answer.
     * For U = 7 and weight = [3, 4, 3, 1], the function should return 0. There is no need for any car to turn back.
     * For U = 2 and weight = [3, 7, 5, 5, 6, 3, 9, 10, 8, 4], the function should return 10. All cars need to turn back. Write an efficient algorithm for the following assumptions: • N is an integer within the range [1.. 100,000]; • each element of array weight is an integer within the range [1.. 1,000,000,000]; • U is an integer within the range [1..1,000,000,000).
     * the 1st car (weight 5) enters the bridge;
     * the 2nd car (weight 3) enters the bridge, the total weight of cars on the bridge is 5 + 3 = 8;
     * the 1st car (weight 5) leaves the bridge;
     * the 3rd car (weight 1) enters the bridge, the total weight of cars on the bridge is 3 + 1 = 4;
     * the 2nd car (weight 3) leaves the bridge;
     * the 4th car (weight 6) enters the bridge, the total weight of cars on the bridge is 1 + 6 = 7;
     * the 3rd car (weight 1) leaves the bridge;
     * the 4th car (weight 6) leaves the bridge.
     * During this process, the total weight of cars on the bridge does not exceed 9.
     * For U = 7 and weight = [7, 6, 5, 2, 7, 4, 5, 4), the function should return 5. After the 1st, 2nd, 5th, 6th and 7th cars turn back, the weights of the remaining cars in line are [5, 2, 4). Notice that instead of the 6th and 7th cars, any two of the last three cars can turn back to obtain an optimal answer.
     * For U = 7 and weight = [3, 4, 3, 1], the function should return 0. There is no need for any car to turn back.
     * For U = 2 and weight = [3, 7, 5, 5, 6, 3, 9, 10, 8, 4], the function should return 10. All cars need to turn back. Write an efficient algorithm for the following assumptions: • N is an integer within the range [1.. 100,000]; • each element of array weight is an integer within the range [1.. 1,000,000,000]; • U is an integer within the range [1..1,000,000,000).
     * @param U
     * @param weight
     * @return
     */
    public int minCarsToTurnBack(int U, int[] weight) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(weight, 0, -1, 0, U, memo);
    }

    // index: current car index
    // onBridge: weight of the car currently on bridge (or -1 if empty)
    // totalOnBridge: sum of weights currently on the bridge
    private int dfs(int[] weight, int index, int onBridge, int totalOnBridge, int limit, Map<String, Integer> memo) {
        if (index >= weight.length) {
            return 0; // all cars processed
        }

        String key = index + "," + onBridge + "," + totalOnBridge;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int w = weight[index];
        int minSkips = Integer.MAX_VALUE;

        // Case 1: Try to let current car enter
        if (onBridge == -1) {
            // bridge is empty: allow this car
            if (w <= limit) {
                minSkips = dfs(weight, index + 1, w, w, limit, memo);
            }
        } else {
            // bridge has one car, try to enter second one
            if (totalOnBridge + w <= limit) {
                // enter second car, then first one leaves (simulate leaving)
                minSkips = dfs(weight, index + 1, w, w, limit, memo);
            }
        }

        // Case 2: Skip (turn back this car)
        int skip = 1 + dfs(weight, index + 1, onBridge, totalOnBridge, limit, memo);
        minSkips = Math.min(minSkips, skip);

        memo.put(key, minSkips);
        return minSkips;
    }

    /**
     * There are N blocks, numbered from 0 to N-1, arranged in a row. A couple of frogs were sitting together on one block when
     * they had a terrible quarrel. Now they want to jump away from one another so that the distance between them will be as
     * large as possible. The distance between blocks numbered J and K, where J ≤ K, is computed as K - J + 1. The frogs can
     * only jump up, meaning that they can move from one block to another only if the two blocks are adjacent and the second
     * block is of the same or greater height as the first. What is the longest distance that they can possibly create between
     * each other, if they also chose to sit on the optimal starting block initially? Write a function: class Solution ‹
     * public int solution (int[l blocks); } that, given an array blocks consisting of N integers denoting the heights of the
     * blocks, returns the longest possible distance that two frogs can make between each other starting from one of the blocks.
     *
     * Given blocks = [2, 6, 8, 5], the function should return 3. If starting from blocks[0], the first frog can stay where
     * it is and the second frog can jump to blocks[2] (but not to blocks[3]).
     * Given blocks = [1, 5, 5, 2, 6], the function should return 4. If starting from blocks[3], the first frog can jump to
     * blocks[1], but not blocks[O], and the second frog can jump to blocks[4].
     * Given blocks = [1, 1], the function should return 2. If starting from blocks[1], the first frog can jump to blocks[0]
     * and the second frog can stay where it is. Starting from blocks[0] would result in the same distance.
     * Write an efficient algorithm in java for the following assumptions: • N is an integer within the range [2..200,000];
     * each element of array blocks is an integer within the range [1.1,000,000,000].
     *
     *
     * @param blocks
     * @return
     */
    public int solution(int[] blocks) {
        int n = blocks.length;
        if (n == 2) {
            return 2;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 0;
        for (int i = 1; i < n; i++) {
            if (blocks[i] <= blocks[i - 1]) {
                left[i] = left[i - 1];
            } else {
                left[i] = i;
            }
        }

        right[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (blocks[i] <= blocks[i + 1]) {
                right[i] = right[i + 1];
            } else {
                right[i] = i;
            }
        }

        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            int currentDistance = right[i] - left[i] + 1;
            if (currentDistance > maxDistance) {
                maxDistance = currentDistance;
            }
        }

        return maxDistance;
    }

}
