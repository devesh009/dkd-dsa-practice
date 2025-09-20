package com.dev.tree;

import com.dev.tree.pojos.MyTreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 07/01/2025
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
class TreeSolutionTest {

    private TreeSolution treeSolution = new TreeSolution();


    @Test
    void countNodes() {
    }

    @Test
    void preorder() {
    }

    @Test
    void inorder() {
    }

    @Test
    void postorder() {
    }

    @Test
    void levelOrder() {
    }

    @Test
    void levelOrderByLevelStoring() {
    }

    @Test
    void preorderIterative() {
    }

    @Test
    void depthOfTree() {
    }

    @Test
    void isBalancedBinaryTree() {
    }

    @Test
    void diameter() {
    }

    @Test
    void maxPathSumAns() {
    }

    @Test
    void identicalTree() {
    }

    @Test
    void isSameTree() {
    }

    @Test
    void testZigzagLevelOrder() {
        // Creating a sample binary tree
        MyTreeNode root = new MyTreeNode(1);
        root.left = new MyTreeNode(2);
        root.right = new MyTreeNode(3);
        root.left.left = new MyTreeNode(4);
        root.left.right = new MyTreeNode(5);
        root.right.left = new MyTreeNode(6);
        root.right.right = new MyTreeNode(7);


        // Get the zigzag level order traversal
        List<List<Integer>> result = treeSolution.zigzagLevelOrder(root);

        // Print the result
        printResult(result);
    }

    private static void printResult(List<List<Integer>> result) {
        for (List<Integer> row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    @Test
    void printBoundary() {
        // Creating a sample binary tree
        MyTreeNode root = new MyTreeNode(1);
        root.left = new MyTreeNode(2);
        root.right = new MyTreeNode(3);
        root.left.left = new MyTreeNode(4);
        root.left.right = new MyTreeNode(5);
        root.right.left = new MyTreeNode(6);
        root.right.right = new MyTreeNode(7);

        // Get the boundary traversal
        List<Integer> result = treeSolution.printBoundary(root);

        // Print the result
        System.out.print("Boundary Traversal: ");
        printBounderTraversalResult(result);
    }

    private void printBounderTraversalResult(List<Integer> result) {
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    @Test
    void verticalTraversal() {
    }

    @Test
    void getAllPathToLeafNodes() {
        // Creating a sample binary tree
        MyTreeNode root = new MyTreeNode(1);
        root.left = new MyTreeNode(2);
        root.right = new MyTreeNode(3);
        root.left.left = new MyTreeNode(4);
        root.left.right = new MyTreeNode(5);
        root.right.left = new MyTreeNode(6);
        root.right.right = new MyTreeNode(7);

        // Get the boundary traversal
        ArrayList<ArrayList<Integer>> ans = treeSolution.getAllPathToLeafNodes(root);
    }
}