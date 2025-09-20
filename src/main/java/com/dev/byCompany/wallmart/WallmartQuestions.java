package com.dev.byCompany.wallmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created on 22/08/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public class WallmartQuestions {

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    class LinkNode {
        int data;
        LinkNode next;
    }


    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    // Kedans algo
    // T=o(n), s = o(1)
    long maxSubarraySum(int[] arr) {
        // Your code here
        long ans = Integer.MIN_VALUE;
        long sum = 0;
        for(int i : arr){
            sum += i;
            ans = Math.max(ans, sum);
            sum = Math.max(sum, 0);
        }
        return ans;
    }
    void printMaxSubarraySum(int[] arr) {
        long ans = Integer.MIN_VALUE;
        long sum = 0,start = 0, end = 0, s = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum > ans){
                ans = sum;
                start = 0;
                end = i;
            }
            if(sum < 0){
                sum = 0;
                s = i + 1;
            }
        }
    }

    // able to reach at end of array
    static int minJumps(int[] arr, int n) {
       // your code here
        if(!canWeReachEnd(arr)) return -1;
        if(n == 1) return 0;
        int coverage = 0;
        int lastJumpIndx = 0;
        int jumps = 0;
        for(int i = 0; i<n; i++ ){
            coverage = Math.max(coverage, i + arr[i]);

            if(i == lastJumpIndx){
                jumps++;
                lastJumpIndx = coverage;
                if(coverage >= n-1) return jumps;
            }
        }
        return jumps;
    }
    static boolean canWeReachEnd(int[] arr ){
        int n = arr.length;
        int lastFlag = n - 1;
        for(int i = n-2; i>=0 ; i--){
            if(i+arr[i] >= lastFlag){
                lastFlag = i;
            }
        }
        return lastFlag == 0;
    }

    static  int minJumpSolution1(int[] arr, int n){
        int count=0;
        int lastJumpIndex=0;
        int coveragee=0;
        if(n==0||(arr[0]==0 && n!=1)){
            return -1;
        }
        if(n==1){
            return 0;
        }
        for(int i=0;i<n-1;i++){
            coveragee=Math.max(coveragee,i+arr[i]);
            if(i==lastJumpIndex){
                lastJumpIndex=coveragee;
                count++;
                if(lastJumpIndex>=n-1){
                    break;
                }
            }
        }
        return (lastJumpIndex >= n - 1) ? count : -1;
    }

    public static void sort012(int a[], int n)
    {
        // code here
        int mid = 0, start = 0,  end = n-1;
        while(mid <= end){
            switch(a[mid]){
                case 0:
                    swap(a, start, mid);
                    start++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(a, mid, end);
                    end--;
                    break;
            }
        }
    }

    static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    // check paranethesis
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x) {
        // add your code here
        Stack<Character> st = new Stack<>();

        for (char c : x.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
                continue;
            } else {
                char temp;
                switch (c) {
                    case ')':
                        if (st.isEmpty()) return false;
                        temp = st.pop();
                        if (temp != '(') return false;
                        break;
                    case ']':
                        if (st.isEmpty()) return false;
                        temp = st.pop();
                        if (temp != '[') return false;
                        break;
                    case '}':
                        if (st.isEmpty()) return false;
                        temp = st.pop();
                        if (temp != '{') return false;
                        break;


                }

            }
        }
        return st.isEmpty();
    }

    static boolean isparSol1(String x) {
        // add your code here
        Stack<Character> st = new Stack<>();
        for (char c : x.toCharArray()) {
            if (c == '(') {
                st.push(')');
            } else if (c == '[') {
                st.push(']');
            } else if (c == '{') {
                st.push('}');
            } else if (st.isEmpty() || st.pop() != c) {
                return false;
            }
        }
        return st.isEmpty();
    }


    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(TreeNode root) {
        // code here.
        List<Integer> ls = new ArrayList<>();
        populateOrderedList(root, ls);
        Integer prev = ls.get(0);
        for (int i = 1; i < ls.size(); i++) {
            if (ls.get(i) <= prev) return false;
            prev = ls.get(i);
        }
        return true;
    }

    void populateOrderedList(TreeNode root, List<Integer> ls) {
        if (root == null) return;
        populateOrderedList(root.left, ls);
        ls.add(root.data);
        populateOrderedList(root.right, ls);

    }

    // Function to remove a loop in the linked list.
    public static void removeLoop(LinkNode head) {
        // code here
        // remove the loop without losing any nodes

        if (head == null || head.next == null) return;
        LinkNode slow = head;
        LinkNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                if (slow == fast) {
                    while (fast.next != slow) {
                        fast = fast.next;
                    }
                    fast.next = null;
                    return;
                }
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;

            }
        }
    }

    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0;
        int j = 0;
        int count = 0;
        int maxCount = 0;

        while (i < n) {
            if (arr[i] <= dep[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    // Function to check if the linked list has a loop.
    public static boolean detectLoop(LinkNode head) {
        // Add code here

        if (head == null) return false;
        LinkNode slow = head;
        LinkNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.

    static class Pair {
        int hd;
        TreeNode node;

        public Pair(int hd, TreeNode node) {
            this.hd = hd;
            this.node = node;
        }

        TreeNode getKey(){
            return this.node;
        }

        int getValue(){
            return this.hd;
        }
    }

    static ArrayList<Integer> topView(TreeNode root) {
        // add your code

        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));

        Map<Integer, Integer> map = new TreeMap<>();

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node.data);
            }

            if (curr.node.left != null) {
                q.add(new Pair(curr.hd - 1, curr.node.left));
            }
            if (curr.node.right != null) {
                q.add(new Pair(curr.hd + 1, curr.node.right));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    static ArrayList<Integer> bottomView(TreeNode root) {
        // add your code

        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));

        Map<Integer, Integer> map = new TreeMap<>();

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            map.put(curr.hd, curr.node.data);

            if (curr.node.left != null) {
                q.add(new Pair(curr.hd - 1, curr.node.left));
            }
            if (curr.node.right != null) {
                q.add(new Pair(curr.hd + 1, curr.node.right));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView1(TreeNode root)
    {
        // Code here

        ArrayList<Integer> ans = new ArrayList<>();
        levelOrderTraversal(root, ans);
        return ans;
    }

    void levelOrderTraversal(TreeNode root,ArrayList<Integer> ans){

        if(root == null) {
            return ;
        }

        Map<Integer, Integer> mpp = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair( 0,root));

        while(!q.isEmpty()) {
            Pair pair = q.poll();
            TreeNode node = pair.getKey();
            int line = pair.getValue();

            mpp.put(line, node.data);

            if(node.left != null) {
                q.add(new Pair(line - 1, node.left));
            }

            if(node.right != null) {
                q.add(new Pair( line + 1,node.right));
            }
        }
        for(Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            ans.add(entry.getValue());
        }

    }
    int heightOFTree(TreeNode node) {
        if (node == null) return 0;

        int lh = heightOFTree(node.left);
        int rh = heightOFTree(node.right);

        return Math.max(lh, rh) + 1;
    }

    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(TreeNode root) {
        // Your code here
        return checkHeight(root) == -1 ? false : true;
    }

    int checkHeight(TreeNode root) {
        if (root == null) return 0;

        int lh = checkHeight(root.left);
        int rh = checkHeight(root.right);

        if (lh == -1 || rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;

        return Math.max(lh, rh) + 1;
    }

    long power(int N,int R)
    {
        //Your code here
        if(N == 0) return 0;
        int ans = 1;
        int lastNum = 1;
        int X = Math.abs(R);

        while(X > 0){
            if(X % 2 == 1){
                ans = ans * N;
                X = X -1;
            }else{
                X = X / 2;
                N = N * N;
            }
        }

        if(R < 0) return 1/ans;
        return ans;
    }


    long power1(int N,int R)
    {
        //Your code here
        long MOD = 1000000007L;
        if(N == 0) return 0;
        if(R == 0) return 1;

        if(R  % 2 == 0){
            long ans = power1(N,R/2);
            return (ans%MOD * ans%MOD)%MOD;
        }
        else{
            long ans = power1(N,(R-1)/2);
            return (ans%MOD * ans%MOD * N%MOD)%MOD;
        }

    }

    // Function to reverse a linked list.
    LinkNode reverseList(LinkNode head) {
        // code here
        if(head == null || head.next == null) return head;
        LinkNode newHeadNode = reverseList(head.next);
        head.next.next =head;
        head.next = null;
        return newHeadNode;
    }

    // Function to reverse a linked list.
    LinkNode reverseList1(LinkNode head) {
        // code here
        LinkNode prev = null;
        LinkNode temp = head;

        while(temp != null){
            LinkNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    // arr[] : the input array
    // N : size of the array arr[]

    //Function to return length of longest subsequence of consecutive integers.
    static int findLongestConseqSubseq(int arr[], int N)
    {
        // add your code here
        int n = arr.length;
        if(n == 0) return 0;
        int longest = 1;
        Set<Integer> set = new HashSet<>();

        for(int x : arr){
            set.add(x);
        }

        for(int num : set){
            if(!set.contains(num - 1)){
                int cnt = 1;
                int x = num;
                while(set.contains(x + 1)){
                    cnt++;
                    x++;
                }
                longest = Math.max(cnt, longest);
            }
        }
        return longest;
    }
    int longestCommonSub(String str1, String str2){
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for(int i = 1; i <= str1.length(); i++){
            for(int j = 1; j <= str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;

                if(str1.charAt(i-1) != str2.charAt(j-1))
                    dp[i][j] = Math.max(dp[i][j-1] , dp[i - 1][j]);
            }
        }
        return dp[str1.length()][str2.length()];
    }

    static String longestPalin(String S){
        // code here

        return  longestCommonSub1( S, reverseStr(S) );

    }
    static String  reverseStr(String str){
        String nstr="";
        char ch;

        for (int i=0; i<str.length(); i++)
        {
            ch= str.charAt(i); //extracts each character
            nstr= ch+nstr; //adds each character in front of the existing string
        }
        return nstr;
    }

    static  String longestCommonSub1(String str1, String str2){
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];


        for(int i = 1; i <= str1.length(); i++){
            for(int j = 1; j <= str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;

                if(str1.charAt(i-1) != str2.charAt(j-1))
                    dp[i][j] = Math.max(dp[i][j-1] , dp[i - 1][j]);
            }
        }


        int n = str1.length();
        int m = str2.length();

        int i = n;
        int j = m;
        int len = dp[n][m];
        int index = len - 1;


        String str = "";
        for(int k = 1; k<=len; k++){
            str += "$";
        }

        StringBuilder ans = new StringBuilder(str);
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                ans.setCharAt(index, str1.charAt(i-1));
                i--;
                j--;
                index--;
            }
            else if(str1.charAt(i-1) > str2.charAt(j-1)){
                j--;
            }else{
                i--;
            }
        }
        return ans.toString();
    }

    int maxProfit(int A[], int n){
        int mini = A[0];
        int maxProfit = 0 ;

        for(int i = 1; i<n; i++ ){
            int cost = A[i] - mini;
            maxProfit = Math.max(cost, maxProfit);
            mini = Math.min(mini, A[i]);
        }
        return maxProfit;
    }

    public List<String> find_permutation(String S) {
        // Code here
        List<String> result = new ArrayList<>();

        backtrack(result, S, "");
        return result;
    }
    void backtrack(List<String> result, String S, String ans){
        if(S.length() == 0){
            result.add(ans);
            return;
        }

        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            String leftPart = S.substring(0,i);
            String rightPart = S.substring(i + 1);
            String roq = leftPart + rightPart;
            backtrack( result, roq, ans + ch);

        }
    }


}


