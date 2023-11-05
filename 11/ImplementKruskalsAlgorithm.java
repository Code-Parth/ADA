import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Graph class
class Graph {
    private int V; // Number of vertices
    private List<Edge> edges; // List of edges

    // Constructor
    public Graph(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }

    // Method to add an edge to the graph
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    // Method to implement Kruskal's algorithm for MST
    public List<Edge> kruskalMST() {
        List<Edge> result = new ArrayList<>(); // List to store the result
        Collections.sort(edges); // Sort the edges
        DisjointSet disjointSet = new DisjointSet(V); // Create a disjoint set

        // Loop through all edges
        for (Edge edge : edges) {
            if (disjointSet.find(edge.src) != disjointSet.find(edge.dest)) {
                result.add(edge);
                disjointSet.union(edge.src, edge.dest);
            }
        }
        return result;
    }
}

// Edge class
class Edge implements Comparable<Edge> {
    int src; // Source vertex
    int dest; // Destination vertex
    int weight; // Weight of the edge

    // Constructor
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // Method to compare two edges based on their weights
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

// DisjointSet class
class DisjointSet {
    int[] parent; // Array to store parent of each node
    int[] rank; // Array to store rank of each node

    // Constructor
    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];

        // Initialize parent array and rank array
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Method to find the parent of a node
    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Method to union two nodes
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        // Union by rank
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}

// Main class
public class ImplementKruskalsAlgorithm {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        Graph graph = new Graph(V); // Create a graph

        // Add edges to the graph
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        // Find the MST using Kruskal's algorithm
        List<Edge> minimumSpanningTree = graph.kruskalMST();

        // Print the MST
        System.out.println("Minimum Spanning Tree using Kruskal's Algorithm:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println("Edge: " + edge.src + " - " + edge.dest + " | Weight: " + edge.weight);
        }
    }
}