package com.dev.pattern;

import java.util.Scanner;

/**
 * Project:  DsaPractice
 * Created by Devesh Kumar on 30/04/2023
 */
public class PatternSolution {
    public void printVShape(int n) {
        if (n == 0) return;
        for (int i = 1; i <= n; i++) {
            String print = i == 1 || i == n ? "*" : "-";
            System.out.print(print);
        }
        System.out.println("");
        printVShape(n - 1);
    }

    public void printVShape1(int n) {
        int counter = n;
        while (counter > 0) {
            for (int i = 1; i <= counter; i++) {
                if (i == 1 || i == counter) {
                    System.out.print("*");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println("");
            counter--;
        }
    }

    public void patterPrint1() {
        int spaceLength = 5;
        for (int i = 0; i < 4; i++) {
            int space = 1;
            for (int j = 0; j < 7; j++) {
                int start = i + 1;
                if (j >= start && space <= spaceLength) {
                    System.out.print("\t");
                    space++;
                } else {
                    System.out.print("*\t");
                }
            }
            spaceLength -= 2;
            System.out.println();
        }
    }


    public void patternPrint11() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of row: ");
        int row = sc.nextInt();
        System.out.println("Enter number of column: ");
        int col = sc.nextInt();
        int star = 1;
        int space = col - 2;
        for (int i = 0; i < row; i++) {
            for (int r = 0; r < col; r++) {
                for (int j = 0; j < star && j < col; j++) {
                    System.out.print("*\t");
                }
                for (int k = 0; k < space && k < col; k++) {
                    System.out.print("\t");
                }
                for (int l = 0; l < star && l < col; l++) {
                    System.out.print("*\t");
                }
            }

            space -= 2;
            star += 1;
            System.out.println();
        }

    }

    // print square patter
    public void printSquare(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }


    public void printRightAngleTriangle(int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public void printNumInTraingle(int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }

    public void oppTriangle(int height) {

        for (int i = height; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }


    public void oppTraingleOfNum(int height) {
        for (int i = height; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }


    }

    public void printPyramid(int height, int width) {

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= height - i - 1; j++) {
                System.out.print("#");
            }
            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= height - i - 1; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
