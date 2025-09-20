package com.dev.maths;

/**
 * Created on 30/08/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public class MathQuestions {
    private static MathSolution mathSolution = new MathSolution();
    public static void main(String[] args) {

        //1. count digit of given num
//        countDigit();

        //2. reverse the number
//        reverseNum();

        //3. check if the num is palindrome
//        checkPalindromeNum();

        // 4. check armstrong num
//        isArmsstrongNum();

        //5. Print all divisors
//        printAllDivisors();

        //6. print all prime numbers
//        isPrimeNum();

        //7. HCF/GCD
        findGcd();

    }

    private static void findGcd() {
        int num1 = 20, num2 = 100;
//        mathSolution.findGcd(num1, num2);
        mathSolution.findGcdByEuclidianAlgo(num1, num2);
    }

    private static void isPrimeNum() {
        int num = 2_147_483_647;
        mathSolution.isPrimeNum(num);

    }

    private static void printAllDivisors() {
        int num = 36;
        mathSolution.printAllDivisors(num);
//        mathSolution.printAllDivisors1(num);
    }

    private static void isArmsstrongNum() {
        int num = 1634;

        mathSolution.isArmsstrongNum(num);
    }


    private static void checkPalindromeNum() {
        int num = 1321;
        mathSolution.checkPalindromeNum(num);
    }

    private static void reverseNum() {
        int num = 12345678;
        mathSolution.reverseNum(num);
    }

    // count number of digit
    private static void countDigit() {
        int num = 1234567;
        mathSolution.countDigit(num);

        // solution with log
        mathSolution.countDigitByLog(num);
    }
}
