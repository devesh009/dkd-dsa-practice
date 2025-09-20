package com.dev.graph;

import com.dev.graph.pojos.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 29/04/2025
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
class GraphSolutionTest {

    GraphSolution graphSolution = new GraphSolution();

    @Test
    void createGraph() {
        Graph g = new Graph(6);
        g.addEdge(0, 1, false);
        g.addEdge(0, 4, false);
        g.addEdge(2, 1, false);
        g.addEdge(3, 4, false);
        g.addEdge(4, 5, false);
        g.addEdge(2, 3, false);
        g.addEdge(3, 5, false);

        g.printGraph();

    }

    @Test
    void findCenterOfStarGraph() {
        int n = 6;
        Graph g = new Graph(n+1);
        g.addEdge(6, 1, false);
        g.addEdge(1, 2, false);
        g.addEdge(1, 3, false);
        g.addEdge(1, 4, false);
        g.addEdge(1, 5, false);
        List<List<Integer>> adjList = g.getAdjList();

        int center = graphSolution.findCenterOfStarGraph(adjList);
        System.out.println("Center of Star Graph: " + center);
    }

    @Test
    void testMaximalNetworkRank() {
        int[][] roads = {
                {0, 1},
                {0, 3},
                {1, 2},
                {1, 3}
        };
        int result = graphSolution.maximalNetworkRank(5, roads);
        System.out.println("Maximal Network Rank: " + result);
    }


    @Test
    void bfsOfGraph() {
        int n = 6;
        Graph g = new Graph(n);
        g.addEdge(0, 1, false);
        g.addEdge(1, 2, false);
        g.addEdge(3, 5, false);
        g.addEdge(5, 6, false);
        g.addEdge(4, 5, false);
        g.addEdge(0, 4, false);
        g.addEdge(3, 4, false);

        g.printGraph();

        System.out.println("BFS Traversal: ");
       graphSolution.bfsOfGraph(n+1, g.getAdjList());

    }

    @Test
    void shortestPathBybfsOfGraph() {
        int n = 6;
        Graph g = new Graph(n);
        g.addEdge(0, 1, false);
        g.addEdge(1, 2, false);
        g.addEdge(3, 5, false);
        g.addEdge(5, 6, false);
        g.addEdge(4, 5, false);
        g.addEdge(0, 4, false);
        g.addEdge(3, 4, false);

        g.printGraph();


       graphSolution.shortestPathBybfsOfGraph(n+1, g.getAdjList());

    }

    @Test
    void snakeAndLadder() {
        int n = 36;
        int[][] ladders = {
                {2, 15},
                {5, 7},
                {9, 27},
                {18, 29},
                {25, 35}
        };
        int[][] snakes = {
                {17, 4},
                {20, 6},
                {34, 12},
                {24, 16},
                {32, 30}
        };

        int result = graphSolution.minDiceThrows(n, ladders, snakes);
        System.out.println("Minimum Dice Throws: " + result); // Output: 4

    }

    @Test
    void dfsOfGraph() {

    }

    @Test
    void isCycle() {
    }

    @Test
    void testBfsOfGraph() {
    }

    @Test
    void testDfsOfGraph() {
    }

    @Test
    void testIsCycle() {
    }
}