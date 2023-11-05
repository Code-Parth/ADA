import java.util.LinkedList;
import java.util.Queue;

// Graph class
class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list

    // Graph constructor
    public Graph(int V) {
        this.V = V;
        adjacencyList = new LinkedList[V];
        // Initialize adjacency lists for all vertices
        for (int i = 0; i < V; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge into the graph
    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    // Method to perform BFS traversal from a given source vertex
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[V]; // Mark all vertices as not visited
        Queue<Integer> queue = new LinkedList<>(); // Create a queue for BFS

        // Mark the current node as visited and enqueue it
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            // Get all adjacent vertices of the dequeued vertex
            // If an adjacent vertex has not been visited, then mark it visited and enqueue it
            for (Integer neighbor : adjacencyList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}

// Driver class
public class BFSExample {
    public static void main(String[] args) {
        Graph graph = new Graph(6); // Create a graph

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);

        System.out.println("Breadth-First Search (BFS) starting from vertex 0:");
        graph.bfs(0); // Perform BFS starting from vertex 0
    }
}