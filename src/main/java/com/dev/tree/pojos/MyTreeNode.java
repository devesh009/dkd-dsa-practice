package com.dev.tree.pojos;

/**
 * Created on 29/12/2024
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
public class MyTreeNode {
    public int val;
    public MyTreeNode left;
    public MyTreeNode right;

    public MyTreeNode() {
    }

    public MyTreeNode(int val) {
        this.val = val;
    }

    public MyTreeNode(int val, MyTreeNode left, MyTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
