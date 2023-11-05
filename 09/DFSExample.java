import java.util.LinkedList;
import java.util.Stack;

// Graph class
class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list

    // Graph constructor
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        // Initialize adjacency lists for all vertices
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Method to add an edge into the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Method to perform DFS traversal from a given source vertex
    public void DFS(int start) {
        boolean[] visited = new boolean[V]; // Mark all vertices as not visited
        Stack<Integer> stack = new Stack<>(); // Create a stack for DFS

        // Mark the current node as visited and push it to the stack
        visited[start] = true;
        stack.push(start);

        while (!stack.isEmpty()) {
            // Pop a vertex from stack and print it
            int current = stack.pop();
            System.out.print(current + " ");

            // Get all adjacent vertices of the popped vertex
            // If an adjacent vertex has not been visited, then mark it visited and push it to the stack
            for (int neighbor : adj[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }
}

// Driver class
public class DFSExample {
    public static void main(String[] args) {
        Graph graph = new Graph(6); // Create a graph

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        System.out.println("DFS starting from vertex 0:");
        graph.DFS(0); // Perform DFS starting from vertex 0
    }
}