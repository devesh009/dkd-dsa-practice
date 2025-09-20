package com.dev.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 22/12/2023
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public class DynamicProgramming {
    static int[][][][] dp = new int[11][2][(1 << 10)][2];

    static int recur(int i, int j, int k, int l, String a)
    {
        if (i == a.length()) {
            return 1;
        }
        if (dp[i][j][k][l] != -1)
            return dp[i][j][k][l];

        int ans = 0;

        if (j == 1) {
            for (int digit = 0; digit <= 9; digit++) {
                int mask = (1 << digit);

                if ((mask & k) != 0) {

                    if (digit == ((int)a.charAt(i) - 48)) {
                        ans += recur(i + 1, 1,
                                k - (1 << digit), 1,
                                a);
                    }

                    else if (digit == 0) {
                        ans += recur(i + 1, 0, k, 0, a);
                    }

                    else if (digit
                            < ((int)a.charAt(i) - 48)) {
                        ans += recur(i + 1, 0,
                                k - (1 << digit), 1,
                                a);
                    }
                }
            }
        }

        else {
            for (int digit = 0; digit <= 9; digit++) {
                int mask = (1 << digit);

                if ((mask & k) != 0) {

                    if (digit == 0 && l == 0)
                        ans += recur(i + 1, 0, k, 0, a);

                    else if (digit == 0 && l == 1)
                        ans += recur(i + 1, 0,
                                k - (1 << digit), 1,
                                a);

                    else
                        ans += recur(i + 1, 0,
                                k - (1 << digit), 1,
                                a);
                }
            }
        }
        return dp[i][j][k][l] = ans;
    }
    static int countInRange(int A, int B)
    {
        for (int[][][] table : dp) {
            for (int[][] row : table) {
                for (int[] innerRow : row) {
                    Arrays.fill(innerRow, -1);
                }
            }
        }

        A--;
        String L = String.valueOf(A);
        String R = String.valueOf(B);

        int ans1 = recur(0, 1, (1 << 10) - 1, 0, L);

        for (int[][][] table : dp) {
            for (int[][] row : table) {
                for (int[] innerRow : row) {
                    Arrays.fill(innerRow, -1);
                }
            }
        }
        int ans2 = recur(0, 1, (1 << 10) - 1, 0, R);
        return ans2 - ans1;
    }

    static void countNumbers(List<List<Integer>> arr){
        for (List<Integer> a1 : arr){
            if (a1.size() == 2){
                int l = a1.get(0);
                int r = a1.get(1);
                System.out.println(countInRange(l, r));
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> l1 = List.of(1,20);
        List<Integer> l2 = List.of(9,19);

        List<List<Integer>> arr = new ArrayList<>();
        arr.add(l1);
        arr.add(l2);

        countNumbers(arr);
    }
}
