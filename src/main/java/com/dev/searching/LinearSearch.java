package com.dev.searching;

import java.util.Objects;

/**
 * Created on 13/09/2025
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
public class LinearSearch {

    public int linearSearch(int[] arr, int target) {

        if (arr == null || arr.length == 0) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public int searchMatrix(int[][] mat, int target) {
        if (Objects.isNull(mat) || mat.length == 0 || mat[0].length == 0) return -1;
        int rowLen = mat.length;
        int colLen = mat[0].length;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (mat[row][col] == target) return target;
            }
        }
        return -1;
    }

}
