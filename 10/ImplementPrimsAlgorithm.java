import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Graph class
class Graph {
    private int V; // Number of vertices
    private List<Edge>[] adj; // Adjacency list

    // Graph constructor
    public Graph(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int u, int v, int weight) {
        adj[u].add(new Edge(v, weight));
        adj[v].add(new Edge(u, weight)); // For an undirected graph
    }

    // Method to implement Prim's algorithm for MST
    public void primMST() {
        boolean[] inMST = new boolean[V]; // Boolean array to track vertices included in MST
        PriorityQueue<Edge> pq = new PriorityQueue<>(V, (a, b) -> Integer.compare(a.weight, b.weight)); // Priority queue to select the minimum weight edge
        int src = 0; // Starting from vertex 0
        pq.add(new Edge(src, 0));

        // Main loop for Prim's algorithm
        while (!pq.isEmpty()) {
            Edge current = pq.poll(); // Remove edge with minimum weight
            if (inMST[current.dest])
                continue;
            inMST[current.dest] = true;
            for (Edge neighbor : adj[current.dest]) {
                if (!inMST[neighbor.dest]) {
                    pq.add(neighbor);
                }
            }
            System.out.println("Edge: " + src + " - " + current.dest + " | Weight: " + current.weight);
        }
    }
}

// Edge class
class Edge {
    int dest; // Destination vertex
    int weight; // Weight of the edge

    // Edge constructor
    public Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

// Main class
public class ImplementPrimsAlgorithm {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        Graph graph = new Graph(V); // Create a new graph
        // Add edges to the graph
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);
        System.out.println("Minimum Spanning Tree using Prim's Algorithm:");
        graph.primMST(); // Run Prim's algorithm
    }
}