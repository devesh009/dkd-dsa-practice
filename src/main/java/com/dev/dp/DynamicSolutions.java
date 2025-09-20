package com.dev.dp;

import java.util.Arrays;

/**
 * Created on 27/08/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public final class DynamicSolutions {

    public int fibonacciNum(int n, int[] dp) {

        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n];
        return dp[n] = fibonacciNum(n - 1, dp) + fibonacciNum(n - 2, dp);
    }

    // TC = o(n), SC = o(1)
    public int fibonacciNum(int n) {

        int prev = 1;
        int prev2 = 0;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = prev + prev2;
            prev2 = prev;
            prev = ans;
        }
        return ans;
    }

    // normal recursion
    public int frogJumpMinEnergy(int[] arr, int n) {
        if (n <= 0) return 0;
        int right = Integer.MAX_VALUE;
        int left = frogJumpMinEnergy(arr, n - 1) + Math.abs(arr[n] - arr[n - 1]);
        if (n >= 2) {
            right = frogJumpMinEnergy(arr, n - 2) + Math.abs(arr[n] - arr[n - 2]);
        }
        return Math.min(left, right);
    }

    // with dp for above problem
    public int frogJumpMinEnergy(int[] arr, int n, int[] dp) {
        if (n <= 0) return 0;
        if (dp[n] != -1) return dp[n];
        int right = Integer.MAX_VALUE;
        int left = frogJumpMinEnergy(arr, n - 1) + Math.abs(arr[n] - arr[n - 1]);
        if (n >= 2) {
            right = frogJumpMinEnergy(arr, n - 2) + Math.abs(arr[n] - arr[n - 2]);
        }
        return dp[n] = Math.min(left, right);
    }

    // tabulation form
    public void frogJumpMinEnergy(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            int fs = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) ss = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            dp[i] = Math.min(fs, ss);
        }
        System.out.println(dp[arr.length - 1]);

    }

    // sapce optimization sc = o(1)
    public void frogJumpMinEnergyOptimum(int[] arr) {
        int prev2 = 0;
        int prev1 = 0;
        for (int i = 1; i < arr.length; i++) {
            int fs = prev1 + Math.abs(arr[i] - arr[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) ss = prev2 + Math.abs(arr[i] - arr[i - 2]);
            int curr = Math.min(fs, ss);
            prev2 = prev1;
            prev1 = curr;

        }
        System.out.println(prev1);
    }


    // recursive solution
    public int maxSumNonAdjSubSeq(int[] arr, int i) {
        if (i == 0) return arr[i];
        if (i < 0) return 0;
        int pick = arr[i] + maxSumNonAdjSubSeq(arr, i - 2);
        int notPick = maxSumNonAdjSubSeq(arr, i - 1);
        return Math.max(pick, notPick);
    }

    // dp solution
    public int maxSumNonAdjSubSeq(int[] arr, int i, int[] dp) {
        if (i == 0) return arr[i];
        if (i < 0) return 0;

        if (dp[i] != -1) return dp[i];
        int pick = arr[i] + maxSumNonAdjSubSeq(arr, i - 2);
        int notPick = maxSumNonAdjSubSeq(arr, i - 1);
        return dp[i] = Math.max(pick, notPick);
    }

    // dp solution, sc= o(1)
    public void maxSumNonAdjSubSeq(int[] arr) {

        int prev1 = arr[0];
        int prev2 = 0;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int take = arr[i];
            if (i > 1) take += prev2;
            int notTake = prev1;
            int curr = Math.max(take, notTake);
            prev2 = prev1;
            prev1 = curr;
        }
        System.out.println(prev1);
    }

    public int masProfitByHouseRobber(int[] arr) {

        int prev1 = arr[0];
        int prev2 = 0;

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int take = arr[i] + prev2;
            int notTake = prev1;

            int curr = Math.max(take, notTake);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public int maxNinjaTrainingPoint(int day, int last, int[][] points, int[][] dp) {
        if (dp[day][last] != -1) return dp[day][last];
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
            return dp[day][last] = maxi;
        }
        int maxi = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int activity = points[day][i] + maxNinjaTrainingPoint(day - 1, i, points, dp);
                maxi = Math.max(maxi, activity);
            }
        }
        return dp[day][last] = maxi;
    }

    public int gridUniquePath(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = gridUniquePath(i - 1, j, dp) + gridUniquePath(i, j - 1, dp);
    }

    public int gridMinSumPathOfGrid(int i, int j, int[][] arr, int[][] dp) {
        if (i == 0 && j == 0) return arr[i][j];
        if (i < 0 || j < 0) return (int) Math.pow(10, 9);
        if (dp[i][j] != -1) return dp[i][j];
        int sum1 = gridMinSumPathOfGrid(i - 1, j, arr, dp) + arr[i][j];
        int sum2 = gridMinSumPathOfGrid(i, j - 1, arr, dp) + arr[i][j];
        return dp[i][j] = Math.min(sum1, sum2);
    }

    // also refer recursion solution similar to that will also print the subsequence
    public boolean subsetSum(int i, int target, int[] arr, int[][] dp) {
        if (target == 0) return true;
        if (i == 0) return arr[0] == target;
        if (dp[i][target] != -1) return dp[i][target] == 1;
        boolean ans2 = subsetSum(i - 1, target, arr, dp);
        boolean ans1 = false;
        if (target >= arr[i]) ans1 = subsetSum(i - 1, target - arr[i], arr, dp);
        dp[i][target] = ans2 || ans1 ? 1 : 0;
        return ans2 || ans1;
    }


    public int knapsack(int[] wt, int[] val, int i, int allowedWeight, int[][] dp) {
        if (i == 0) {
            if (wt[0] <= allowedWeight) return val[0];
            else return 0;
        }
        if (dp[i][allowedWeight] != -1) return dp[i][allowedWeight];

        int notTake = knapsack(wt, val, i - 1, allowedWeight, dp);
        int take = Integer.MIN_VALUE;
        if (wt[i] <= allowedWeight) {
            take = val[i] + knapsack(wt, val, i - 1, allowedWeight - wt[i], dp);
        }
        dp[i][allowedWeight] = Math.max(notTake, take);
        return dp[i][allowedWeight];
    }


    // Function to solve the 0/1 Knapsack problem using dynamic programming
    public int knapsack(int[] wt, int[] val, int n, int W) {
        // Create a 2D DP array to store the maximum value for each subproblem
        int dp[][] = new int[n][W + 1];

        // Base Condition
        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = dp[ind - 1][cap];

                // Calculate the maximum value when the current item is taken
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap) {
                    taken = val[ind] + dp[ind - 1][cap - wt[ind]];
                }

                // Store the maximum value for the current state
                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }

        // The result is stored in the last row and last column of the DP array
        return dp[n - 1][W];
    }

    public int coinChange(int[] coins, int target, int i, int[][] dp) {
        if (i == 0) {
            if (target % coins[0] == 0) return 1;
            return 0;
        }      if (dp[i][target] != -1) return dp[i][target];
        int notTake = coinChange(coins, target, i - 1, dp);
        int take = 0;
        if (coins[i] <= target) take = coinChange(coins, target - coins[i], i, dp);
        return dp[i][target] = notTake + take;
    }

    public int rodCuttingProblem(int[] price, int i, int target, int[][] dp) {
        if (i == 0) {
            return price[0] * target;
        }
        if (dp[i][target] != -1) return dp[i][target];
        int notTake = rodCuttingProblem(price, i - 1, target, dp);
        int take = Integer.MIN_VALUE;
        int rodLength = i + 1;
        if (rodLength <= target) take = rodCuttingProblem(price, i, target - rodLength, dp);
        return dp[i][target] = Math.max(notTake, take);
    }

    public int lengthOfLongestCommonSubseq(String str1, String str2, int s1, int s2, int[][] dp) {
        if (s1 < 0 || s2 < 0) return 0;
        if (dp[s1][s2] != -1) return dp[s1][s2];
        if (str1.charAt(s1) == str2.charAt(s2)) {
            return 1 + lengthOfLongestCommonSubseq(str1, str2, s1 - 1, s2 - 1, dp);

        } else {
            return Math.max(lengthOfLongestCommonSubseq(str1, str2, s1 - 1, s2, dp),
                    lengthOfLongestCommonSubseq(str1, str2, s1, s2 - 1, dp)
            );
        }
    }

    public int countUniqueOutcomes(int N) {
        int[][] dp = new int[N + 1][6 * N + 1];

        // Initialize base case
        dp[0][0] = 1;

        // Fill the DP table
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j >= k) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }

        // Count unique outcomes
        int uniqueCount = 0;
        for (int i = N; i <= 6 * N; i++) {
            if (dp[N][i] > 0) {
                uniqueCount++;
            }
        }
        return uniqueCount;
    }

    // Function to find the length of the longest increasing subsequence
    private int getAns(int arr[], int n, int ind, int prev_index, int[][] dp) {
        // Base condition
        if (ind == n) {
            return 0;
        }
        if (dp[ind][prev_index + 1] != -1) {
            return dp[ind][prev_index + 1];
        }

        int notTake = getAns(arr, n, ind + 1, prev_index, dp);

        int take = 0;

        if (prev_index == -1 || arr[ind] > arr[prev_index]) {
            take = 1 + getAns(arr, n, ind + 1, ind, dp);
        }
        dp[ind][prev_index + 1] = Math.max(notTake, take);
        return dp[ind][prev_index + 1];
    }

    // Function to find the length of the longest increasing subsequence
    public int longestIncreasingSubsequence(int arr[], int n) {
        int dp[][] = new int[n][n + 1];
        // Initialize dp array with -1 to mark states as not calculated yet
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return getAns(arr, n, 0, -1, dp);
    }

    // Function to find the length of the Longest Common Subsequence (LCS)
    public int lcsOfString(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store results of subproblems
        int dp[][] = new int[n + 1][m + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        // Initialize the first row and first column with zeros since LCS with an empty string is zero
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        // Fill the dp array using dynamic programming
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                // If the characters at the current indices are the same, increment the LCS length
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                    // If the characters are different, choose the maximum LCS length by either
                    // excluding a character in s1 or excluding a character in s2
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        return dp[n][m]; // Return the length of the Longest Common Subsequence (LCS)
    }

}
