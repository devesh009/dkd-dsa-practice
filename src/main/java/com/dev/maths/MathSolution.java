package com.dev.maths;

/**
 * Created on 30/08/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public class MathSolution {

    /**
     * TC = O(log10(N))
     *
     * @param num
     */
    public void countDigit(int num) {
        int count = 0;
        while (num > 0) {
            num = num / 10;
            count++;
        }
        System.out.println("Count is - " + count);
    }

    /**
     * this works because we are find number of time a num can be divided by 10
     * smarter approach mathematical logic
     *
     * @param num
     */
    public void countDigitByLog(int num) {
        int count = (int) Math.log10(num) + 1;
        System.out.println(count);
    }

    /**
     * multiplying a num by 10 will add 0 in the end so we can add upcoming num
     * to this place
     *
     * @param num
     */
    public void reverseNum(int num) {
        int ans = 0;
        while (num > 0) {
            ans = (num % 10) + (ans * 10);
            num = num / 10;
        }
        System.out.println(ans);


    }

    /**
     * reverse the num and compare
     *
     * @param num
     */
    public void checkPalindromeNum(int num) {
        int temp = num;
        int ans = 0;
        while (num > 0) {
            ans = (num % 10) + (ans * 10);
            num = num / 10;
        }
        System.out.println(temp == ans);

    }

    /**
     * Armstrong num is if sum of cube of all digit of num becomes equal to num
     *
     * @param num
     */
    public void isArmsstrongNum(int num) {

        int countDigit = (int) Math.log10(num) + 1;
        int temp = num;
        int ans = 0;
        while (num > 0) {
            ans = (int) Math.pow(num % 10, countDigit) + ans;
            num = num / 10;
        }
        System.out.println(temp + " - " + ans);
        System.out.println(temp == ans);
    }


    // TC = O(sqrt(n))
    public void printAllDivisors(int num) {
        int divisors = 1;
        int number = num;

        while (divisors <= number) {
            if (num % divisors == 0) {
                System.out.println(divisors);
                if (divisors != num / divisors)
                    System.out.println(num / divisors);
                number = num / divisors;
            }
            divisors += 1;
        }
    }

    // TC = O(sqrt(n))
    public void printAllDivisors1(int num) {
        int divisors = 1;
        int number = num;

        int count = 1;
        while (divisors * divisors <= number) {
            System.out.println(count++);
            if (num % divisors == 0) {
                System.out.println(divisors);
                if (divisors != num / divisors)
                    System.out.println(num / divisors);
            }
            divisors += 1;
        }
    }

    public void isPrimeNum(int num) {

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0 && num / i != num) {
                System.out.println(i + " * " + (num / i) + " = " + (i * num));
                System.out.println(num + "\t : not a prime number");
                return;
            }
        }
        System.out.println(num + "\t : Is prime number");
    }

    // TC = O(min(num1, num2))
    public void findGcd(int num1, int num2) {
        int ans = 1;
        for (int i = 2; i <= Math.min(num1, num2); i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                ans = i;
            }
        }
        System.out.println("HCF of " + num1 + " and " + num2 + "\tis : " + ans);
    }

    /**
     * Euclidian Algo is gcd(a,b) = gcd(a-b,a)
     *
     * TC = O(log10 min(a,b))
     *
     * @param num1
     * @param num2
     */
    public void findGcdByEuclidianAlgo(int num1, int num2) {

        if (num1 == 0 || num2 == 0) {
            System.out.println(Math.max(num1, num2));
            return;
        }
        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);
        findGcdByEuclidianAlgo(max % min, min);
    }


}
