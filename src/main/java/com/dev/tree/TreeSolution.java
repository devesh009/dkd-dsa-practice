package com.dev.tree;


import com.dev.tree.pojos.MyTreeNode;
import com.dev.tree.pojos.NodeData;
import com.dev.tree.pojos.VerticalOrderNode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created on 24/08/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public class TreeSolution {

    public int countNodes(int i) {
        // code here
        if (i == 0) return 1;
        return (int) Math.pow(2, i - 1);
    }

    // TC = O(n) , SC = O(n)
    public void preorder(MyTreeNode root) {
        if (root == null) return;
        System.out.print(root.val + "-");
        preorder(root.left);
        preorder(root.right);
    }

    // TC = O(n) , SC = O(n)
    public void inorder(MyTreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + "-");
        inorder(root.right);
    }

    public void postorder(MyTreeNode root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + "-");
    }

    public List<List<Integer>> levelOrder(MyTreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<MyTreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int width = q.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < width; i++) {
                if (q.peek().left != null) q.add(q.peek().left);
                if (q.peek().right != null) q.add(q.peek().right);
                subList.add(q.poll().val);
            }
            ans.add(subList);
        }
        return ans;
    }


    /**
     * This impl uses level for storing nodes
     *
     * @param root
     */
    public void levelOrderByLevelStoring(MyTreeNode root) {

        Queue<NodeData> q = new LinkedList<>();
        Map<Integer, List<Integer>> ans = new TreeMap<>();

        q.add(new NodeData(1, root));
        while (!q.isEmpty()) {
            NodeData currentNode = q.poll();
            if (!ans.containsKey(currentNode.level)) {
                List<Integer> subList = new ArrayList<>();
                subList.add(currentNode.node.val);
                ans.put(currentNode.level, subList);
            } else {
                ans.get(currentNode.level).add(currentNode.node.val);
            }
            if (currentNode.node.left != null) {
                q.add(new NodeData(currentNode.level + 1, currentNode.node.left));
            }
            if (currentNode.node.right != null) {
                q.add(new NodeData(currentNode.level + 1, currentNode.node.right));
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : ans.entrySet()) {
            System.out.println("key - " + entry.getKey());
            for (Integer num : entry.getValue()) {
                System.out.print(num + "-");
            }
            System.out.println("-------------------------");
        }

    }

    public void preorderIterative(MyTreeNode root) {
        Stack<MyTreeNode> st = new Stack<>();
        st.push(root);
        List<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            MyTreeNode curr = st.pop();
            ans.add(curr.val);
            if (curr.right != null) st.push(curr.right);

            if (curr.left != null) st.push(curr.left);
        }
        for (Integer num : ans) {
            System.out.print(num + " - ");
        }
    }

    public int depthOfTree(MyTreeNode root) {
        if (root == null) return 0;

        int lh = depthOfTree(root.left);
        int rh = depthOfTree(root.right);
        return Math.max(lh, rh) + 1;
    }

    public int isBalancedBinaryTree(MyTreeNode root) {
        if (root == null) return 0;

        int lh = isBalancedBinaryTree(root.left);
        if (lh == -1) return -1;
        int rh = isBalancedBinaryTree(root.right);
        if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }

    public int diameter(MyTreeNode root, int[] diameter) {
        if (root == null) return 0;
        int lh = diameter(root.left, diameter);
        int rh = diameter(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh + rh);
        return Math.max(lh, rh) + 1;
    }

    public int maxPathSumAns(MyTreeNode root, int[] sum) {
        if (root == null) return 0;
        int lh = Math.max(maxPathSumAns(root.left, sum), 0);
        int rh = Math.max(maxPathSumAns(root.right, sum), 0);
        sum[0] = Math.max(lh + rh + root.val, sum[0]);
        return Math.max(lh, rh) + root.val;
    }

    public boolean isSameTree(MyTreeNode p, MyTreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public List<List<Integer>> zigzagLevelOrder(MyTreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<MyTreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean flag = true;

        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int k = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                if (q.peek().left != null) q.offer(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);
                if (!flag) {
                    level.addFirst(q.poll().val);
                } else {
                    level.addLast(q.poll().val);
                }
            }
            ans.add(level);
            flag = !flag;
        }
        return ans;
    }

    public List<Integer> printBoundary(MyTreeNode root) {

        if (root == null) return List.of();
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);

        getLeftNodes(root, ans);
        getLeafNodes(root, ans);
        getRightNode(root, ans);
        return ans;
    }

    private void getLeftNodes(MyTreeNode root, List<Integer> ans) {
        MyTreeNode currentNode = root.left;
        while (!isLeafNode(currentNode)) {
            ans.add(currentNode.val);
            if (currentNode.left != null) currentNode = currentNode.left;
            else currentNode = currentNode.right;
        }
    }

    private void getLeafNodes(MyTreeNode root, List<Integer> ans) {
        if (isLeafNode(root)) {
            ans.add(root.val);
            return;
        }
        if (root.left != null) getLeafNodes(root.left, ans);
        if (root.right != null) getLeafNodes(root.right, ans);
    }

    private void getRightNode(MyTreeNode root, List<Integer> ans) {
        MyTreeNode currentNode = root.right;
        List<Integer> rAns = new ArrayList<>();
        while (!isLeafNode(currentNode)) {
            rAns.add(currentNode.val);
            if (currentNode.right != null) currentNode = currentNode.right;
            else currentNode = currentNode.left;
        }
        // reverse the list, since we have to print right nodes in reverse order
        Collections.reverse(rAns);
        ans.addAll(rAns);
    }

    private boolean isLeafNode(MyTreeNode root) {
        return root.left == null && root.right == null;
    }

    public List<List<Integer>> verticalTraversal(MyTreeNode root) {
        Map<Integer, TreeSet<Integer>> sortedData = getMapOfArrangedNodes(root);
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<Integer>> entry : sortedData.entrySet()) {
            List<Integer> row = new ArrayList<>();
            for (Integer num : entry.getValue()) {
                row.add(num);
            }
            ans.add(row);
        }
        return ans;
    }

    private Map<Integer, TreeSet<Integer>> getMapOfArrangedNodes(MyTreeNode root) {
        Map<Integer, TreeSet<Integer>> map = new TreeMap<>();
        Queue<VerticalOrderNode> q = new LinkedList<>();
        q.offer(new VerticalOrderNode(0, root));
        while (!q.isEmpty()) {

            VerticalOrderNode vNode = q.poll();
            int level = vNode.level;
            MyTreeNode node = vNode.root;

            if (map.containsKey(level)) {
                map.get(level).add(node.val);
            } else {
                TreeSet<Integer> pq = new TreeSet<>();
                pq.add(node.val);
                map.put(level, pq);
            }
            if (node.left != null) q.offer(new VerticalOrderNode(level - 1, node.left));
            if (node.right != null) q.offer(new VerticalOrderNode(level + 1, node.right));
        }
        return map;
    }

    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    public ArrayList<Integer> topView(MyTreeNode root) {
        // code here

        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : getMapOfTopView(root).entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    private Map<Integer, Integer> getMapOfTopView(MyTreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<VerticalOrderNode> q = new LinkedList<>();
        q.offer(new VerticalOrderNode(0, root));


        while (!q.isEmpty()) {

            VerticalOrderNode vNode = q.poll();
            int level = vNode.level;
            MyTreeNode node = vNode.root;

            if (!map.containsKey(level)) {
                map.put(level, node.val);
            }
            if (node.left != null) q.offer(new VerticalOrderNode(level - 1, node.left));
            if (node.right != null) q.offer(new VerticalOrderNode(level + 1, node.right));
        }
        return map;
    }

    //Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(MyTreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : getMapOfBottomView(root).entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    private Map<Integer, Integer> getMapOfBottomView(MyTreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<VerticalOrderNode> q = new LinkedList<>();
        q.offer(new VerticalOrderNode(0, root));


        while (!q.isEmpty()) {

            VerticalOrderNode vNode = q.poll();
            int level = vNode.level;
            MyTreeNode node = vNode.root;


            map.put(level, node.val);

            if (node.left != null) q.offer(new VerticalOrderNode(level - 1, node.left));
            if (node.right != null) q.offer(new VerticalOrderNode(level + 1, node.right));
        }
        return map;
    }

    public List<Integer> rightSideView(MyTreeNode root) {
        Queue<MyTreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        q.add(root);
        while (!q.isEmpty()) {
            int width = q.size();
            for (int i = 0; i < width; i++) {
                if (i == 0) ans.add(q.peek().val);
                if (q.peek().right != null) q.offer(q.peek().right);
                if (q.peek().left != null) q.offer(q.peek().left);
                q.poll();
            }
        }
        return ans;
    }

    public List<Integer> rightSideViewMySol(MyTreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : getMapOfRightView(root).entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    public Map<Integer, Integer> getMapOfRightView(MyTreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<VerticalOrderNode> q = new LinkedList<>();
        q.offer(new VerticalOrderNode(0, root));


        while (!q.isEmpty()) {

            VerticalOrderNode vNode = q.poll();
            int level = vNode.level;
            MyTreeNode node = vNode.root;

            if (!map.containsKey(level)) {
                map.put(level, node.val);
            }

            if (node.right != null) q.offer(new VerticalOrderNode(level + 1, node.right));
            if (node.left != null) q.offer(new VerticalOrderNode(level + 1, node.left));

        }
        return map;
    }

    public boolean isSymmetric(MyTreeNode root) {
        return root == null || isSymetric(root.left, root.right);
    }

    public boolean isSymetric(MyTreeNode left, MyTreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) return false;
        return isSymetric(left.left, right.right) && isSymetric(left.right, right.left);

    }

    public static ArrayList<ArrayList<Integer>> getAllPathToLeafNodes(MyTreeNode root) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        ArrayList<Integer> path = new ArrayList<>();
        getPaths(root, list, path);
        return list;
    }

    /**
     * get all path from node to leaf
     *
     * @param root
     * @param list
     * @param path
     */
    public static void getPaths(MyTreeNode root, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            list.add(new ArrayList<>(path));
        }


        getPaths(root.left, list, path);
        getPaths(root.right, list, path);
        path.remove(path.size() - 1);
    }

    public static boolean getPathFromRootToB(MyTreeNode root, int value, ArrayList<Integer> path) {
        if (root == null) return false;

        path.add(root.val);
        if (root.val == value) return true;
        if (getPathFromRootToB(root.left, value, path) || getPathFromRootToB(root.right, value, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }


    /**
     * Here is a solution to find the lowest common ancestor (LCA) of two nodes in a binary tree:
     * Explanation
     * Base Case: If the current node is null or matches either of the nodes p or q, return the current node.
     * Recursive Case: Recursively find the LCA in the left and right subtrees.
     * Result: If both left and right recursive calls return non-null values, the current node is the LCA.
     * Otherwise, return the non-null value from the recursive calls.
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public MyTreeNode lowestCommonAncestor(MyTreeNode root, MyTreeNode p, MyTreeNode q) {
        if (root == null || root == p || root == q) return root;

        MyTreeNode left = lowestCommonAncestor(root.left, p, q);
        MyTreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public int widthOfBinaryTree(MyTreeNode root) {

        if (root == null) return 0;
        Queue<NodeData> q = new LinkedList<>();
        q.offer(new NodeData(0, root));
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().level;
            int first = 0;
            int last = 0;
            for (int i = 0; i < size; i++) {
                NodeData currNode = q.poll();
                int currNum = currNode.level - min; // for optimization start from 0
                if (i == 0) first = currNum;
                if (i == size - 1) last = currNum;
                if (currNode.node.left != null) q.offer(new NodeData(currNum * 2 + 1, currNode.node.left));
                if (currNode.node.right != null) q.offer(new NodeData(currNum * 2 + 2, currNode.node.right));
            }
            ans = Math.max(ans, last - first + 1);

        }
        return ans;
    }

    //Function to check whether all nodes of a tree have the value
    //equal to the sum of their child nodes.
    public static int isSumProperty(MyTreeNode root) {
        // add your code here
        return checkChildrenSumTree(root) ? 1 : 0;

    }


    private static boolean checkChildrenSumTree(MyTreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;

        int childSum = 0;
        if (root.left != null) childSum += root.left.val;
        if (root.right != null) childSum += root.right.val;

        boolean node = root.val == childSum;


        boolean leftChild = true;
        boolean rightChild = true;

        if (root.left != null) leftChild = checkChildrenSumTree(root.left);
        if (root.right != null) rightChild = checkChildrenSumTree(root.right);


        return node && (leftChild && rightChild);
    }

    public static void makeTreeChildrenSum(MyTreeNode root) {
        if (root == null) return;
        int childSum = 0;
        if (root.left != null) childSum += root.left.val;
        if (root.right != null) childSum += root.right.val;

        if (childSum >= root.val) root.val = childSum;
        else {
            if (root.left != null) root.left.val = childSum;
            if (root.right != null) root.right.val = childSum;
        }
        makeTreeChildrenSum(root.left);
        makeTreeChildrenSum(root.right);

        int totalSum = 0;
        if (root.left != null) totalSum += root.left.val;
        if (root.right != null) totalSum += root.right.val;
        if (root.left != null || root.right != null) root.val = totalSum;
    }







    // Function to return the ceil of given number in BST.
    int findCeil(MyTreeNode root, int key) {
        if (root == null) return -1;
        MyTreeNode node = root;
        int ceil = -1;
        while (node != null) {
            if (node.val == key) {
                return node.val;
            }
            if (node.val < key) {
                node = node.right;
            } else {
                ceil = node.val;
                node = node.left;
            }
        }

        return ceil;
        // Code here
    }

    public static int floor(MyTreeNode root, int x) {
        // Code here
        if (root == null) return -1;
        int floor = -1;
        MyTreeNode node = root;
        while (node != null) {
            if (node.val == x) {
                return node.val;
            }
            if (x > node.val) {
                floor = node.val;
                node = node.right;
            } else {
                node = node.left;
            }
        }

        return floor;
    }

    public MyTreeNode insertIntoBST(MyTreeNode root, int val) {
        if (root == null) return new MyTreeNode(val);
        MyTreeNode curr = root;
        while (true) {
            if (curr.val < val) {
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = new MyTreeNode(val);
                    break;
                }
            } else {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new MyTreeNode(val);
                    break;
                }
            }
        }
        return root;
    }


    public MyTreeNode deleteNode(MyTreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {
            return createLeftTree(root);
        }

        MyTreeNode dummy = root;
        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = createLeftTree(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = createLeftTree(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return dummy;

    }

    private MyTreeNode createLeftTree(MyTreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        MyTreeNode rightTree = root.right;
        MyTreeNode leftRightMostLeaf = getLeftTreeRightMostLeaf(root.left);
        leftRightMostLeaf.right = rightTree;
        return root.left;
    }

    private MyTreeNode getLeftTreeRightMostLeaf(MyTreeNode root) {
        if (root.right == null) return root;
        return getLeftTreeRightMostLeaf(root.right);
    }

    public MyTreeNode lowestCommonAncestorOfBST(MyTreeNode root, MyTreeNode p, MyTreeNode q) {
        if (root == null) return root;
        int curr = root.val;
        if (p.val > curr && q.val > curr) {
            return lowestCommonAncestorOfBST(root.right, p, q);
        } else if (p.val < curr && q.val < curr) {
            return lowestCommonAncestorOfBST(root.left, p, q);
        } else {
            return root;
        }
    }

    public boolean isValidBST(MyTreeNode root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return checkBst(root, min, max);
    }

    public boolean checkBst(MyTreeNode root, int min, int max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max ) return false;
        return  checkBst(root.left, min, root.val) &&
                checkBst(root.right, root.val, max);
    }

}
