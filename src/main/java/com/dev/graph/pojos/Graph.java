package com.dev.graph.pojos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 11/05/2025
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */

public class Graph {

    private List<List<Integer>> adjList;
    private int V;

    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>(V);
        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int n1, int n2, boolean isDirected) {
        adjList.get(n1).add(n2);
        if (!isDirected) {
            adjList.get(n2).add(n1);
        }
    }

    public List<List<Integer>> getAdjList(){

        return this.adjList;
    }

    public void printGraph(){
        for(int i = 0; i < V; i++){
            System.out.print(i + " -> ");
            for (Integer node : adjList.get(i)){
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }


}
