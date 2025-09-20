package com.dev.stack;

/**
 * Created on 03/01/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public class StackEasyLevelQuestions {
    private static StackEasyLevelSolution stackSolution = new StackEasyLevelSolution();

    public static void main(String[] args) {


        // Find duplicate brackets
        // findDuplicate();

        //Find balanced brackets
        // findBalancedBracket();

        //Next greater element on right side of array
        //nexGreaterFromRight();

        // Stock Span , next greater from left
       // findStockSpan();


        //Largest area of histogram
       // largestAreaHistogram();

        // Sliding window maximum
        //slidingWindowMaximum();

        // infix


    }

    // largest area histogram
    private static void largestAreaHistogram() {

        int[] arr = new int[]{6, 2, 5, 4, 5, 1, 6};
        System.out.print("\n*************** Input ***************\n");
        for(int a : arr){
            System.out.print(" "+a);
        }

        System.out.print("\n*************** Output ***************\n");
        stackSolution.findLargestArea(arr);
        stackSolution.findLargestAreaMySol(arr);
    }

    // left next greater
    private static void findStockSpan() {
        int[] arr = new int[]{2, 5, 9, 3, 1, 12, 6, 8, 7};
        System.out.println("find stock span");
        for (int k : arr) {
            System.out.print("\t" + k);
        }
        System.out.println("");
        stackSolution.findStockSpan(arr);
    }

    private static void nexGreaterFromRight() {

        int[] arr = new int[]{2, 5, 9, 3, 1, 12, 6, 8, 7};
        stackSolution.findNextGreaterElement(arr);
        stackSolution.findNextGreaterElementSol1(arr);
    }

    private static void findBalancedBracket() {
        String[] str = new String[]{
                "[(a+b)+{(c+d)*(e/f)}]",
                "[(a+b)+{(c+d)*(e/f)]}",
                "[(a+b)+{(c+d)*(e/f)}",
                "([(a+b)+{(c+d)*(e/f)}]",
        };
        for (String s : str) stackSolution.findBalancedBracket(s);
    }

    private static void slidingWindowMaximum() {
        int[] arr = new int[]{2, 9, 3, 8, 1, 7, 12, 6, 14, 4, 32, 0, 7, 19, 8, 12, 6};
        stackSolution.findMaxInWindowMySol(arr, 4);
    }

    private static void findDuplicate() {
        System.out.println((stackSolution.findDuplicateBracket()));
    }
}
