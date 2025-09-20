package com.dev.sorting;

/**
 * Created on 03/09/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public final class SortUtils {

    static void swapArr(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
