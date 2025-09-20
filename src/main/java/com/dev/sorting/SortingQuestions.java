package com.dev.sorting;

/**
 * Created on 03/09/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public class SortingQuestions {
    private static SortingSolutions sortingSolutions = new SortingSolutions();

    public static void main(String[] args) {

        //1. Selection sort
//        selectionSort();

        //2. Bubble sort
//        bubbleSort();

        //3. Insertion sort
//        insertionSort();

        //4. Merge sort
//        mergeSort();

        //5. Quick sort
//        quickSort();


    }

    private static void quickSort() {
        int[] arr = {3, 1, 2, 4, 1, 5, 2, 6, 4};
        int i = 0;
        int n = arr.length;
        int j = n - 1;
        sortingSolutions.quickSort(arr, i, j);


        for (int a : arr) {
            System.out.println(a);
        }
    }

    private static void mergeSort() {
        int[] arr = {3, 1, 2, 4, 1, 5, 2, 6, 4};
        int i = 0;
        int n = arr.length;
        int j = n - 1;
        sortingSolutions.mergeSort(arr, i, j);


        for (int a : arr) {
            System.out.println(a);
        }
    }

    private static void insertionSort() {
        int[] arr = {13, 46, 24, 52, 20, 9};
        sortingSolutions.insertionSort(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }

    private static void bubbleSort() {
        int[] arr = {13, 46, 24, 52, 20, 9};
        sortingSolutions.bubbleSort(arr);
//        sortingSolutions.bubbleSort1(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }

    private static void selectionSort() {
        int[] arr = {13, 46, 24, 52, 20, 9};
//        sortingSolutions.selectionSort(arr);
        sortingSolutions.selectionSort1(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
