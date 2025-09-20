package com.dev.dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created on 18/02/2025
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
class DynamicSolutionsTest {


    private static DynamicSolutions dynaSol = new DynamicSolutions();

    @Test
    void countUniqueOutcomes() {
        int N = 2; // number of dice
        int uniqueCount = dynaSol.countUniqueOutcomes(N);
        System.out.println("Count of unique combinations: " + uniqueCount);
    }


    private void lengthOfLongestCommonSubseq() {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        int s1 = str1.length();
        int s2 = str2.length();
        int[][] dp = new int[s1][s2];
        for (int[] a : dp) Arrays.fill(a, -1);

        int maxLength = dynaSol.lengthOfLongestCommonSubseq(str1, str2, s1 - 1, s2 - 1, dp);
        System.out.println(maxLength);

    }


    private static void rodCuttingProblem() {

        int[] price = {2, 4, 5, 6};
        int n = price.length;

        int[][] dp = new int[n][n + 1];
        for (int[] a : dp) Arrays.fill(a, -1);
        int maxPrice = dynaSol.rodCuttingProblem(price, n - 1, n, dp);
        System.out.println(maxPrice);
    }

    private static void coinChange() {
        int[] coins = {1, 2, 5};
        int target = 10;
        int[][] dp = new int[coins.length][target + 1];
        for (int[] a : dp) Arrays.fill(a, -1);
        int numOfWays = dynaSol.coinChange(coins, target, coins.length - 1, dp);
        System.out.println(numOfWays);
    }

    @Test
    public void knapsack() {
        int[] wt = {3, 2, 5};
        int[] val = {30, 40, 60};
        int allowedWeight = 6;
        int[][] dp = new int[wt.length][allowedWeight + 1];
        for (int[] a : dp) Arrays.fill(a, -1);
        int maxValue = dynaSol.knapsack(wt, val, wt.length - 1, allowedWeight, dp);
        System.out.println(maxValue);

    }

    private static void subsetSum() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 1000;
        int n = arr.length;


        int[][] dp = new int[n][target + 1];
        for (int[] a : dp) Arrays.fill(a, -1);
        boolean subsetExists = dynaSol.subsetSum(n - 1, target, arr, dp);
        System.out.println(subsetExists);
    }

    private static void gridMinSumPathOfGrid() {
        int[][] arr = new int[][]{{2, 1, 3}, {3, 4, 6}, {10, 1, 6}, {8, 3, 7}};
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        for (int[] a : dp) Arrays.fill(a, -1);

        int minSum = dynaSol.gridMinSumPathOfGrid(m - 1, n - 1, arr, dp);
        System.out.println(minSum);
    }

    private static void gridUniquePath() {
        int m = 2, n = 2;
        int[][] dp = new int[m][n];
        for (int[] a : dp) Arrays.fill(a, -1);
        int uniqPath = dynaSol.gridUniquePath(m - 1, n - 1, dp);
        System.out.println(uniqPath);

    }


    private static void maxNinjaTrainingPoint() {
        int[][] point = new int[][]{{2, 1, 3}, {3, 4, 6}, {10, 1, 6}, {8, 3, 7}};
        int n = point.length;
        int[][] dp = new int[n][4];
        for (int[] a : dp) Arrays.fill(a, -1);

        int maxPoint = dynaSol.maxNinjaTrainingPoint(n - 1, 3, point, dp);
        System.out.println(maxPoint);
    }

    private static void masProfitByHouseRobber() {
        int[] arr = new int[]{2, 1, 4, 9};

        // excluding first  house
        int[] arr1 = new int[]{1, 4, 9};
        // excluding last house
        int[] arr2 = new int[]{2, 1, 4};
        System.out.println(Math.max(dynaSol.masProfitByHouseRobber(arr1), dynaSol.masProfitByHouseRobber(arr2)));
    }

    private static void maxNonADjSubSeq() {

        int[] arr = new int[]{2, 1, 4, 9};
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
//        int sum = dynaSol.maxSumNonAdjSubSeq(arr, arr.length - 1);
//        int sum = dynaSol.maxSumNonAdjSubSeq(arr, arr.length - 1, dp);
//        System.out.println(sum);
        dynaSol.maxSumNonAdjSubSeq(arr);

    }

    private static void frogJumpMinEnergy() {
        int height[] = {30, 10, 60, 10, 60, 50};
        int n = height.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

//        System.out.println(dynaSol.frogJumpMinEnergy(height,n-1));
//        System.out.println(dynaSol.frogJumpMinEnergy(height,n-1, dp));
//        dynaSol.frogJumpMinEnergy(height);
        dynaSol.frogJumpMinEnergyOptimum(height);
    }

    private static void fibonacciNum() {
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
//        int num = dynaSol.fibonacciNum(n, dp);
        int num = dynaSol.fibonacciNum(n);
        System.out.println(num);
    }
}