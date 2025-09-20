package com.dev.stack;

import java.util.Stack;

/**
 * Created on 03/01/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */



public class StackEasyLevelSolution {

    // Find duplicate brackets
    public boolean findDuplicateBracket() {
        /*Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();*/

        String str = "((a+b)+(c+d))";
        // String str = "(a+b)+((c+d))";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ')') {
                st.push(str.charAt(i));
            } else {
                if (st.peek() == '(') {
                    return true;
                }
                while (st.size() > 0 && st.peek() != '(') {
                    st.pop();
                }
                st.pop();
            }
        }
        return false;
    }

    //Find balanced brackets
    public void findBalancedBracket(String str) {
        /*Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        */
        System.out.println(str);
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.size() <= 0) {
                    System.out.println(false);
                    return;
                }
                if (st.peek() != '(') {
                    System.out.println(false);
                    return;
                }
                st.pop();
            } else if (ch == '}') {
                if (st.size() <= 0) {
                    System.out.println(false);
                    return;
                }
                if (st.peek() != '{') {
                    System.out.println(false);
                    return;
                }
                st.pop();
            } else if (ch == ']') {
                if (st.size() <= 0) {
                    System.out.println(false);
                    return;
                }
                if (st.peek() != '[') {
                    System.out.println(false);
                    return;
                }
                st.pop();
            }
        }
        System.out.println(st.isEmpty());
    }

    //Next greater element on right side of array
    public void findNextGreaterElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        st.push(arr[n - 1]);
        ans[n - 1] = -1;

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] > st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                st.push(arr[i]);
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
                st.push(arr[i]);
            }
        }
        for (int num : ans) System.out.print(num + "\t");
    }

    public void findNextGreaterElementSol1(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(0);

        int[] ans = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                ans[st.peek()] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            ans[st.pop()] = -1;
        }
        for (int num : ans) System.out.print(num + "\t");
    }

    public void findLargestArea(int[] arr) {
        int n = arr.length;
        int[] area = new int[n];
        int[] rightSmaller = new int[n];
        int[] leftSmaller = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                rightSmaller[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            rightSmaller[st.peek()] = n;
            st.pop();
        }

        for (int num : rightSmaller) {
            System.out.print(num + "\t");
        }
        System.out.println();
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                leftSmaller[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            leftSmaller[st.peek()] = -1;
            st.pop();
        }

        for (int num : leftSmaller) {
            System.out.print(num + "\t");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            int width = rightSmaller[i] - leftSmaller[i] - 1;
            System.out.println(width + " - ");
            area[i] = width * arr[i];
        }
        System.out.println();

        for (int num : area) {
            System.out.print(num + "\t");
        }
    }

    public void findLargestAreaMySol(int[] arr) {
        int n = arr.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        Stack<Integer> leftSt = new Stack<>();
        Stack<Integer> rightSt = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!leftSt.isEmpty() && arr[i] <= arr[leftSt.peek()]) {
                leftSt.pop();
            }
            if (leftSt.isEmpty()) leftSmaller[i] = i + 1;
            if (!leftSt.isEmpty()) leftSmaller[i] = i - leftSt.peek();
            leftSt.push(i);
        }

        System.out.println("\nleft smaller :\n");
        for (int a : leftSmaller) {
            System.out.print(" " + a);
        }

        for (int i = n - 1; i > -1; i--) {
            while (!rightSt.isEmpty() && arr[i] <= arr[rightSt.peek()]) {
                rightSt.pop();
            }
            if (rightSt.isEmpty()) rightSmaller[i] = n - i;
            if (!rightSt.isEmpty()) rightSmaller[i] = rightSt.peek() - i;
            rightSt.push(i);
        }
        System.out.println("\nright smaller :\n");

        for (int a : rightSmaller) {
            System.out.print(" " + a);
        }

        int[] area = new int[n];
        for (int i = 0; i < arr.length; i++) {
            area[i] = arr[i] * (leftSmaller[i] + rightSmaller[i] - 1);
        }
        System.out.println("\nArea : \n");

        for (int a : area) {
            System.out.print(" " + a);
        }
    }


    // left next greater
    public void findStockSpan(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int[] span = new int[arr.length];
        span[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) span[i] = i + 1;
            if (!stack.isEmpty()) span[i] = i - stack.peek();
            stack.push(i);
        }
        for (int k : span) {
            System.out.print("\t" + k);
        }

    }

    // o(n) solution
    public void findMaxInWindowMySol(int[] arr, int k) {
        int n = arr.length;
        int[] nextGreater = new int[n];
        Stack<Integer> stack = new Stack<>();

        // construct next greater element array
        for (int i = n - 1; i > -1; i--) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) nextGreater[i] = n;
            if (!stack.isEmpty()) nextGreater[i] = stack.peek();
            stack.push(i);
        }

        // to optimize
        int z = 0;
        for (int x = 0; x <= n - k; x++) {
            // enter the loop to find maximum of window K at x
            if (z < x) {
                z = x;
            }
            // update z if next greater is inside window or else z will be ans
            while (nextGreater[z] < x + k) {
                z = nextGreater[z];
            }
            System.out.println("Maximum for x = " + x + " - " + z + " " + arr[z]);
        }
    }

    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            if (stack.pop().equals(minStack.peek())) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
