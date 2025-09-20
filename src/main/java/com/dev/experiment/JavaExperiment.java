package com.dev.experiment;

import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created on 11/07/2025
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */

public class JavaExperiment {

    public static void main(String[] args) {
        System.out.println(divide(10, 0));

    }

    public static int divide(int a, int b) {
        try {
            if (b == 0) {
                throw new IllegalArgumentException("Divide by zero");
            }
            return a / b;
        } catch (IllegalArgumentException e) {
            System.out.println("Inside catch block : " + e.getMessage());
            return 1;
        } finally {
            System.out.println("Inside finally block");
            return 2;
        }
    }

    public int getInt(int a) {
        return a;
    }

    public int getInt(String a) {
        return Integer.parseInt(a);
    }
}
