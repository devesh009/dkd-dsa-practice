package com.dev.byCompany.oracle;

import com.dev.byCompany.oracle.pojos.Node;
import com.dev.graph.pojos.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created on 30/12/2024
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
public class OracleSolution {


    /**
     * // arr: input array
     * // Function to find the sum of contiguous subarray with maximum sum.
     * Brute force approach
     * <p>
     * TC = O(n^3)
     *
     * @param arr
     * @return
     */
    int maxSubarraySum(int[] arr) {

        int n = arr.length;
        int max = Integer.MIN_VALUE;
        // Your code here
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    /**
     * @param arr
     * @return
     */
    int maxSubarraySumByKedansAlgo(int[] arr) {

        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    // Function to check if brackets are balanced or not.
    static boolean isParenthesisBalanced(String s) {
        // code here
        if (s.length() == 1) return false;
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        int i = 1;
        while (i < s.length()) {
            Character c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;
                Character currChar = st.pop();
                if ((c == ')' && currChar != '(') ||
                        (c == ']' && currChar != '[') ||
                        (c == '}' && currChar != '{')) {
                    return false;
                }
            }
            i++;
        }
        return st.isEmpty();
    }


    /**
     * Given a sorted array arr and an integer k, find the position(0-based indexing)
     * at which k is present in the array using binary search.
     *
     * @param arr
     * @param k
     * @return
     */
    public int binarysearch(int[] arr, int k) {
        // Code Here
        int[] ans = new int[]{Integer.MAX_VALUE};
        search(arr, k, 0, arr.length - 1, ans);
        return ans[0] == Integer.MAX_VALUE ? -1 : ans[0];
    }

    private void search(int[] arr, int k, int l, int u, int[] ans) {

        if (l >= u) return;
        int mid = (l + u) / 2;
        if (arr[mid] == k) {
            ans[0] = Math.min(mid, ans[0]);
        }
        search(arr, k, l, mid, ans);
        search(arr, k, mid + 1, u, ans);
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {


        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                if (checkCycle(i, adj, visited)) return true;
            }
        }
        return false;
    }

    private boolean checkCycle(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(v, -1));
        visited[v] = true;

        while (!q.isEmpty()) {
            Pair currNode = q.poll();
            int node = currNode.node;
            int parent = currNode.parent;

            for (Integer neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(new Pair(neighbor, node));
                } else if (parent != neighbor) {
                    return true;
                }
            }

        }
        return false;
    }

    // Function to remove a loop in the linked list.
    public static void removeLoop(Node node) {
        // If list is empty or has only one node
        // without loop
        if (node == null || node.next == null)
            return;

        Node slow = node, fast = node;

        // Move slow and fast 1 and 2 steps
        // ahead respectively.
        slow = slow.next;
        fast = fast.next.next;

        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;

            slow = slow.next;
            fast = fast.next.next;
        }

        // If loop exists
        if (slow == fast) {
            slow = node;
            if (slow != fast) {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // since fast->next is the looping point
                // remove loop
                fast.next = null;
            }
            // This case is added if fast and slow
            // pointer meet at first position.
            else {
                while (fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null;
            }
        }

    }


    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        int[][] dp = new int[val.length][capacity + 1];
        return getMaxValue(capacity, val, wt, val.length - 1, dp);
    }

    private static int getMaxValue(int capacity, int[] val, int[] wt, int i, int[][] dp) {
        if (i == 0) {
            return wt[i] <= capacity ? val[i] : 0;
        }
        if (dp[i][capacity] > 0) return dp[i][capacity];
        int notTake = getMaxValue(capacity, val, wt, i - 1, dp);
        int take = Integer.MIN_VALUE;
        if (wt[i] <= capacity) {
            take = val[i] + getMaxValue(capacity - wt[i], val, wt, i - 1, dp);
        }
        return dp[i][capacity] = Math.max(notTake, take);
    }
}

