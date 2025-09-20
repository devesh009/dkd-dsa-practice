package com.dev.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 23/08/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public class RecursionQuest {
    private static RecursionSol recursionSol = new RecursionSol();

    public static void main(String[] args) {

        //1. print name N times
        printNames();

        //2. print numbers till N
        //printNaturalNum();

        //3. print natural num i reverse
        //printNaturalNumReverse();

        //4. backtracking print natural num
        //printNaturalNumBacktrack();

        //5. backtrack reverse natural num
        //printNaturalNumReverseBacktrack();

        //6. Sum of N num (Parameterised)
        //sumOfNum();

        //7. Sum by returning value of sum
        //sumOfNumByReturningValue();

        //8. get Factorial
        //getFactorial();

        //9. Reverse array by recursion
        //everseArr();

        //10. find palindrome of string
        //isPalindrome();

        //11. get nth fibonacci num
        //getNthFibonacci();

        //12. print all subsequences
        //printAllSubsequence();

        //13. print subsequence of sum K
//        subsequenceSumK();

        //14. merge sort
        //mergeSort();

        //15. quick sort
        //quickSort();

        //16. combination sum
//        combinationSum();//16. combination sum



    }

    private static void combinationSum() {

        Integer[] arr = new Integer[]{2,3,6,7};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tempAns = new ArrayList<>();;
        //recursionSol.combinationSum(0, arr, 7, ans, tempAns );


        recursionSol.uniqueCombinationSum(0, arr, 7, ans, tempAns );
        for (List<Integer> a1 : ans){
            for (Integer num : a1){
                System.out.print(num+"\t");
            }
            System.out.println();
        }
    }

    private static void quickSort() {
        Integer[] arr = new Integer[]{3,1,2,4,1,5,2,6,4};
        recursionSol.quickSort(arr, 0, arr.length-1);
        for (Integer x : arr){
            System.out.print(x+"-");
        }
    }

    private static void mergeSort() {
        Integer[] arr = new Integer[]{3,1,2,4,1,5,2,6,4};
        recursionSol.mergeSort(arr, 0, arr.length-1);
        for (Integer x : arr){
            System.out.print(x+"-");
        }
    }

    private static void subsequenceSumK() {
        Integer[] arr= new Integer[]{3,1,2};
//        recursionSol.subsequenceSumK(arr, new ArrayList<Integer>(),0, arr.length, 5);
        recursionSol.subsequenceSumKAvoidExcessCall(arr, new ArrayList<Integer>(),0, arr.length, 5);
        //recursionSol.subsequenceSizeK(arr, new ArrayList<Integer>(),0, arr.length, 5);

    }

    private static void printAllSubsequence() {
        Integer[] arr= new Integer[]{3,1,2};
        recursionSol.printAllSubsequence(arr, new ArrayList<Integer>(),0, arr.length );
    }

    private static void getNthFibonacci() {
        Integer ans = recursionSol.getNthFibonacci(8);
        System.out.println(ans);
    }

    private static void isPalindrome() {
        String str = "MADAMM";
        boolean isPal = recursionSol.isPalindrome(str, 0, str.length()- 1);
        System.out.println(str+" -  "+isPal);
    }

    private static void reverseArr() {
       Integer[] arr = new Integer[]{1,2,3,4,5};
        recursionSol.reverseArr(arr,0, arr.length - 1);
        for (Integer n : arr){
            System.out.println(n);
        }
    }

    private static void getFactorial() {
            Integer ans = recursionSol.getFactorial(4);
        System.out.println(ans);
    }

    private static void sumOfNumByReturningValue() {
        Integer ans = recursionSol.sumOfNumByReturningValue(4);
        System.out.println(ans);
    }

    private static void sumOfNum() {
        recursionSol.sumOfNum(3, 0);
    }

    private static void printNaturalNumReverseBacktrack() {
        recursionSol.printNaturalNumReverseBacktrack(10, 1);
    }

    private static void printNaturalNumBacktrack() {
        recursionSol.printNaturalNumBacktrack(10);
    }

    private static void printNaturalNumReverse() {
        recursionSol.printNaturalNumReverse(10);
    }

    private static void printNaturalNum() {
        recursionSol.printNaturalNum(1, 10);
    }

    private static void printNames() {
        recursionSol.printNames("Devesh", 10);
    }

}
