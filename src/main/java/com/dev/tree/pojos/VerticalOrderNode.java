package com.dev.tree.pojos;

/**
 * Created on 08/01/2025
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
public class VerticalOrderNode {
    public int level;
    public MyTreeNode root;

    public VerticalOrderNode() {
    }

    public VerticalOrderNode(int level, MyTreeNode root) {
        this.level = level;
        this.root = root;
    }

}
