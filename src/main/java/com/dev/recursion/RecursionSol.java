package com.dev.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dev.recursion.RecursionUtil.*;

/**
 * Created on 23/08/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public class RecursionSol {

    void printNames(String name, Integer count) {
        if (count == 0) return;
        System.out.println(name);
        printNames(name, count - 1);
    }

    public void printNaturalNum(Integer start, Integer N) {
        if (start > N) return;
        System.out.println(start);
        printNaturalNum(start + 1, N);
    }

    public void printNaturalNumReverse(Integer N) {
        if (N == 0) return;
        System.out.println(N);
        printNaturalNumReverse(N - 1);
    }

    public void printNaturalNumBacktrack(Integer N) {
        if (N == 0) return;
        printNaturalNumBacktrack(N - 1);
        System.out.println(N);
    }

    public void printNaturalNumReverseBacktrack(Integer N, Integer start) {
        if (start > N) return;
        printNaturalNumReverseBacktrack(N, start + 1);
        System.out.println(start);
    }

    public void sumOfNum(Integer N, Integer sum) {
        if (N < 0) {
            System.out.println(sum);
            return;
        }
        sumOfNum(N - 1, sum + N);
    }

    public Integer sumOfNumByReturningValue(Integer N) {
        if (N == 0) return 0;
        return N + sumOfNumByReturningValue(N - 1);
    }

    public Integer getFactorial(Integer N) {
        if (N == 1) return 1;
        return N * getFactorial(N - 1);
    }

    public void reverseArr(Integer[] arr, Integer start, Integer end) {
        if (start >= end) return;
        swap(arr, start, end);
        reverseArr(arr, start + 1, end - 1);
    }

    public boolean isPalindrome(String str, Integer start, Integer end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindrome(str, start + 1, end - 1);
    }

    // TC = O(2^n)
    public Integer getNthFibonacci(Integer n) {
        if (n <= 1) return n;
        return getNthFibonacci(n - 1) + getNthFibonacci(n - 2);
    }

    // TC = O(2^n) * n, SC = O(N)
    public void printAllSubsequence(Integer[] a, ArrayList<Integer> ans, Integer i, Integer n) {
        if (i >= n) {
            for (Integer num : ans)
                System.out.print(num + "\t");
            System.out.println("");
            return;
        }
        ans.add(a[i]);
        printAllSubsequence(a, ans, i + 1, n);
        ans.remove(ans.size() - 1);
        printAllSubsequence(a, ans, i + 1, n);
    }

    public void subsequenceSumK(Integer[] arr, ArrayList<Integer> ans, Integer i, Integer n, Integer sum) {
        if (i == n) {
            if (ans.stream().mapToLong(Integer::longValue).sum() == sum) {
                ans.forEach(System.out::println);
            }
            return;
        }
        ans.add(arr[i]);
        subsequenceSumK(arr, ans, i + 1, n, sum);
        ans.remove(ans.size() - 1);
        subsequenceSumK(arr, ans, i + 1, n, sum);
    }

    // below code will avoid excess recursive call which is not required if we get the answer
    public boolean subsequenceSumKAvoidExcessCall(Integer[] arr, ArrayList<Integer> ans, Integer i, Integer n, Integer sum) {
        if (i == n) {
            if (ans.stream().mapToLong(Integer::longValue).sum() == sum) {
                ans.forEach(System.out::println);
                return true;
            }
            return false;
        }
        ans.add(arr[i]);
        if (subsequenceSumKAvoidExcessCall(arr, ans, i + 1, n, sum)) return true;
        ans.remove(ans.size() - 1);
        if (subsequenceSumKAvoidExcessCall(arr, ans, i + 1, n, sum)) return true;
        return false;
    }

    // TC = nlog(n), SC = o(n)
    public void mergeSort(Integer[] a, Integer low, Integer high) {
        if (low == high) return;

        Integer mid = (low + high) / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);
        mergeSortedArray(a, low, mid, high);
    }

    // TC = nlog(n), SC = o(n)
    public void quickSort(Integer[] arr, Integer low, Integer high) {
        if (low < high) {
            Integer partition = findPivotIndex(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }

    /**
     * combination sum problem, where we can pick element multiple times
     * duplicates are allowed
     * <p>
     * TC = 2^n * k
     *
     * @param ind
     * @param a
     * @param targetSum
     * @param ans
     * @param tempAns
     */
    public void combinationSum(Integer ind, Integer[] a, Integer targetSum, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> tempAns) {
        if (targetSum == 0) {
            ans.add(new ArrayList<>(tempAns));
            return;
        }
        if (targetSum < 0 || ind >= a.length) return;
        tempAns.add(a[ind]);
        combinationSum(ind, a, targetSum - a[ind], ans, tempAns);
        tempAns.remove(tempAns.size() - 1);
        combinationSum(ind + 1, a, targetSum, ans, tempAns);
    }

    /**
     * combination sum problem, where we can pick element only once
     * duplicates are not allowed
     *
     * @param ind
     * @param a
     * @param targetSum
     * @param ans
     * @param tempAns
     */
    public void uniqueCombinationSum(Integer ind, Integer[] a, Integer targetSum, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> tempAns) {
        if (targetSum == 0) {
            ans.add(new ArrayList<>(tempAns));
            return;
        }
        if (ind >= a.length || targetSum < 0) return;
        tempAns.add(a[ind]);
        uniqueCombinationSum(ind + 1, a, targetSum - a[ind], ans, tempAns);
        tempAns.remove(tempAns.size() - 1);
        uniqueCombinationSum(ind + 1, a, targetSum, ans, tempAns);
    }

    public List<List<Integer>> getAllPermetuationArray(List<List<Integer>> ans, List<Integer> permutation, boolean[] fre, Integer[] arr) {

        if (permutation.size() == arr.length) {
            ans.add(new ArrayList<>(permutation));
            return ans;
        }
        for (Integer i = 0; i < arr.length; i++) {
            if (!fre[i]) {
                fre[i] = true;
                permutation.add(arr[i]);
                getAllPermetuationArray(ans, permutation, fre, arr);
                permutation.remove(permutation.size() - 1);
                fre[i] = false;
            }
        }
        return ans;
    }

    /**
     * Space optimized approach
     *
     * @param ans
     * @param arr
     * @param index
     */
    public void getAllPermutOfArray(List<List<Integer>> ans, Integer[] arr, Integer index) {
        if (index == arr.length) {
            ans.add(List.of(arr));
        }

        for (Integer i = index; i < arr.length; i++) {
            swap(arr, i, index);
            getAllPermutOfArray(ans, arr, index + 1);
            swap(arr, i, index);
        }
    }

    public void getAllPermuteOfString(String str, String ans) {
        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }
        for (Integer i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String temp = str.substring(0, i) + str.substring(i + 1);
            getAllPermuteOfString(temp, ans + ch);
        }
    }


    public List<List<Integer>> getAllSubsets(Integer[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0, arr, new ArrayList<>(), subsets);
        return subsets;
    }

    private void generateSubsets(int index, Integer[] arr, List<Integer> current, List<List<Integer>> subsets) {
        if (index == arr.length) {
            subsets.add(new ArrayList<>(current));
            return;
        }
        // Include the current element
        current.add(arr[index]);
        generateSubsets(index + 1, arr, current, subsets);
        // Exclude the current element
        current.remove(current.size() - 1);
        generateSubsets(index + 1, arr, current, subsets);
    }


    public static void getAllSubset(int[] arr, int k, List<List<Integer>> res, List<Integer> list) {

        res.add(new ArrayList<>(list));
        for (int i = k; i < arr.length; i++) {
            list.add(arr[i]);
            getAllSubset(arr, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        getAllComb(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    /**
     * combination sum with repeated numbers
     *
     * @param candidates
     * @param target
     * @param ans
     * @param currAns
     * @param i
     */
    public void getAllComb(int[] candidates, int target, List<List<Integer>> ans, List<Integer> currAns, int i) {

        if (i == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(currAns));
            }
            return;
        }
        // checking if we can use the current element
        if (target < 0) return;

        currAns.add(candidates[i]);
        target -= candidates[i];

        // not updating i because we can use same element again
        getAllComb(candidates, target, ans, currAns, i);

        currAns.remove(currAns.size() - 1);
        target += candidates[i];
        getAllComb(candidates, target, ans, currAns, i + 1);
    }

    // same as above with little modification
    public void getAllComb1(int[] candidates, int target, List<List<Integer>> ans, List<Integer> currAns, int i) {

        if (i == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(currAns));
            }
            return;
        }
        // checking if we can use the current element
        if (candidates[i] <= target) {
            currAns.add(candidates[i]);
            getAllComb(candidates, target - candidates[i], ans, currAns, i);
            currAns.remove(currAns.size() - 1);
        }
        getAllComb(candidates, target, ans, currAns, i + 1);
    }

    /**
     * get all unique combination sum , lexically sorted
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // to get sorted array combination
        Arrays.sort(candidates);
        getUniqueComb(ans, new ArrayList<>(), 0, candidates, target);
        return ans;
    }


    public void getUniqueComb(List<List<Integer>> ans, List<Integer> tempAns, int i, int[] candidates, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(tempAns));
            // this return doesn't affect the answer because we are not adding the element in the list
            // but optimizes the code
            return;
        }

        for (int k = i; k < candidates.length; k++) {
            // to avoid duplicate combination
            if (i < k && candidates[k] == candidates[k - 1]) continue;
            if (candidates[k] > target) break;
            tempAns.add(candidates[k]);
            getUniqueComb(ans, tempAns, k + 1, candidates, target - candidates[k]);
            tempAns.remove(tempAns.size() - 1);
        }

    }

    /**
     * return all sum of all subsets
     *
     * @param arr
     * @return
     */
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        getAllSum(arr, ans, 0, 0);
        return ans;
    }

    public void getAllSum(int[] arr, ArrayList<Integer> ans, int k, int sum) {
        ans.add(sum);
        for (int i = k; i < arr.length; i++) {
            sum += arr[i];
            getAllSum(arr, ans, i + 1, sum);
            sum -= arr[i];
        }
    }


    /**
     * get all unique subset
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        getUniqueSubsetList(nums, ans, new ArrayList<Integer>(), 0);
        return ans;

    }

    public void getUniqueSubsetList(int[] arr, List<List<Integer>> ans, List<Integer> tempAns, int k) {

        ans.add(new ArrayList<>(tempAns));
        for (int i = k; i < arr.length; i++) {
            if (i != k && arr[i] == arr[i - 1]) continue;
            tempAns.add(arr[i]);
            getUniqueSubsetList(arr, ans, tempAns, i + 1);
            tempAns.remove(tempAns.size() - 1);
        }
    }

}
