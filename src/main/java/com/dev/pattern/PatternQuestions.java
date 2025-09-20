package com.dev.pattern;

/**
 * Created on 04/01/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public class PatternQuestions {
    static PatternSolution patternSolution = new PatternSolution();

    public static void main(String[] args) {

        //1. print square
//        printSquare();

        //2. print right angle triangle
//        printRightAngleTriangle();

        //3. print numbers in triangle form
//        printNumInTraingle();

        //4. print right angle triangle opposite
//        oppTriangle();

        //5. print opposite triangle of number
//        oppTraingleOfNum();

        //6. Pyramid
        printPyramid();


    }

    private static void printPyramid() {
        int height = 5;
        int width = 9;
        patternSolution.printPyramid(height, width);
    }

    private static void oppTraingleOfNum() {

        int height = 10;
        patternSolution.oppTraingleOfNum(height);
    }


    private static void oppTriangle() {

        int height = 10;
        patternSolution.oppTriangle(height);
    }


    private static void printNumInTraingle() {
        int height = 10;
        patternSolution.printNumInTraingle(height);
    }

    private static void printRightAngleTriangle() {
        int height = 10;
        patternSolution.printRightAngleTriangle(height);

    }

    private static void printSquare() {
        int m = 10, n = 10;
        patternSolution.printSquare(m, n)
        ;

    }
}
