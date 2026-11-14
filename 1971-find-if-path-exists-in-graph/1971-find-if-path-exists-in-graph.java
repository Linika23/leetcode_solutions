
import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // Step 1: Create an adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Build the undirected graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 3: BFS initialization
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);
        visited[source] = true;

        // Step 4: BFS traversal
        while (!queue.isEmpty()) {

            int node = queue.poll();

            // Destination found
            if (node == destination) {
                return true;
            }

            for (int neighbour : adj.get(node)) {

                if (!visited[neighbour]) {

                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }

        return false;
    }
}
