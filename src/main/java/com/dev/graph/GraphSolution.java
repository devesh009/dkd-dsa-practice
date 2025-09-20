package com.dev.graph;

import com.dev.graph.pojos.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created on 31/12/2024
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
public class GraphSolution {

/*    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            Integer currNode = q.poll();
            ans.add(currNode);

            for (Integer neighbor : adj.get(currNode)) {
                if (!visited[neighbor]) {

                    q.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return ans;
    }*/


    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();

        dfs(0, visited, adj, ans);
        return ans;
    }

    private void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans) {
        visited[node] = true;
        ans.add(node);
        for (Integer neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj, ans);
            }
        }
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

    public int findCenterOfStarGraph(List<List<Integer>> adjList) {
        int i = 0;
        for (List<Integer> adj : adjList) {
            if (adj.size() == adjList.size() - 2) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n];
        boolean[][] conn = new boolean[n][n];

        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
            conn[road[0]][road[1]] = true;
            conn[road[1]][road[0]] = true;
        }
        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = degree[i] + degree[j];
                if (conn[i][j]) {
                    rank--;
                }
                maxRank = Math.max(maxRank, rank);
            }
        }
        return maxRank;
    }

    public int minTrioDegree(int n, int[][] edges) {
        // Adjacency matrix to represent the graph
        boolean[][] adj = new boolean[n + 1][n + 1];
        int[] degree = new int[n + 1];

        // Build the graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u][v] = true;
            adj[v][u] = true;
            degree[u]++;
            degree[v]++;
        }

        int minDegree = Integer.MAX_VALUE;

        // Check all combinations of three nodes
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    // Check if they form a connected trio
                    if (adj[i][j] && adj[j][k] && adj[k][i]) {
                        // Calculate the degree of the trio
                        int trioDegree = degree[i] + degree[j] + degree[k] - 6;
                        minDegree = Math.min(minDegree, trioDegree);
                    }
                }
            }
        }

        // Return the result
        return minDegree == Integer.MAX_VALUE ? -1 : minDegree;
    }


    public void bfsOfGraph(int v, List<List<Integer>> adjList) {

        boolean[] visited = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int val = q.poll();
            System.out.print(val + "->");
            for (Integer nbr : adjList.get(val)) {
                if (!visited[nbr]) {
                    q.add(nbr);
                    visited[nbr] = true;
                }
            }
        }
    }


    public void shortestPathBybfsOfGraph(int v, List<List<Integer>> adjList) {

        boolean[] visited = new boolean[v];
        int[] distance = new int[v];
        distance[0] = 0;

        int[] parent = new int[v];
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int parentNode = q.poll();
            for (Integer nbr : adjList.get(parentNode)) {
                if (!visited[nbr]) {
                    q.add(nbr);
                    visited[nbr] = true;
                    parent[nbr] = parentNode;
                    distance[nbr] = distance[parentNode] + 1;
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            System.out.println("Distance of " + i + " from source is " + distance[i]);
        }

        int dest = 5;
        System.out.println("Path from source to destination is ");

        while (dest != -1) {
            System.out.print(dest + "->");
            dest = parent[dest];
        }
    }


    public int minDiceThrows(int n, int[][] ladders, int[][] snakes) {
        // Create a board array
        int[] board = new int[n + 1];
        Arrays.fill(board, -1);
        ArrayList<int[]> temp = new ArrayList<>();

        // Populate the board with ladders
        for (int[] ladder : ladders) {
            temp.add(ladder);
            board[ladder[0]] = ladder[1];
        }

        // Populate the board with snakes
        for (int[] snake : snakes) {
            board[snake[0]] = snake[1];
        }

        // BFS to find the minimum dice throws
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0}); // Start from cell 1 with 0 dice throws
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cell = current[0];
            int throwsCount = current[1];

            // If we reach the last cell, return the number of throws
            if (cell == n) {
                return throwsCount;
            }



            // Simulate dice rolls
            for (int dice = 1; dice <= 6; dice++) {
                int nextCell = cell + dice;
                if (nextCell <= n ) {
//                    visited[nextCell] = true;

                    // Check if there's a snake or ladder
                    if (board[nextCell] != -1) {
                        nextCell = board[nextCell];
                    }

                    queue.add(new int[]{nextCell, throwsCount + 1});
                }
            }
        }

        // If we can't reach the last cell
        return -1;
    }
}
