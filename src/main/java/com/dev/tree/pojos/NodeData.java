package com.dev.tree.pojos;

/**
 * Created on 25/08/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public class NodeData {
    public int level;
    public MyTreeNode node;

   public NodeData(int level, MyTreeNode node) {
        this.level = level;
        this.node = node;
    }
}
