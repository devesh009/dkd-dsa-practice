package com.dev.recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created on 09/01/2025
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
class RecursionSolTest {
    private RecursionSol recursionSol = new RecursionSol();

    @Test
    void getAllPermetuationArray() {
        List<java.util.List<Integer>> ans = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        Integer[] arr = new Integer[]{1, 2, 3};
        boolean[] freq = new boolean[arr.length];
        recursionSol.getAllPermetuationArray(ans, permutation, freq, arr);
        ans.forEach(System.out::println);
        assertThat(ans.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    void getAllPermuteOfString() {
        recursionSol.getAllPermuteOfString("abc", "");
    }

    @Test
    void getAllPermutOfArray() {
        List<List<Integer>> ans = new ArrayList<>();
        Integer[] arr = new Integer[]{1, 2, 3};
        recursionSol.getAllPermutOfArray(ans, arr, 0);
        ans.forEach(System.out::println);
    }

    @Test
    void getAllSubsets() {
        Integer[] arr = {1, 2, 3};
        List<List<Integer>> subsets = recursionSol.getAllSubsets(arr);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    @Test
    void getAllSubset() {
        int[] arr = {1, 2, 3};
        List<List<Integer>> subsets = new ArrayList<>();
        recursionSol.getAllSubset(arr, 0, subsets, new ArrayList<>());
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

}