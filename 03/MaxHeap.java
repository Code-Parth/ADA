public class MaxHeap {
    private int[] heap; // Array to store heap elements
    private int size; // Current size of the heap
    private int capacity; // Maximum possible size of the heap

    // Constructor to initialize the heap
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity + 1]; // 1-based array, 0th index is not used
    }

    // Function to insert a new value in the heap
    public void insert(int value) {
        if (size >= capacity) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }
        size++;
        heap[size] = value;
        int current = size;
        // Heapify the new value upwards
        while (current > 1 && heap[current] > heap[current / 2]) {
            swap(current, current / 2);
            current = current / 2;
        }
    }

    // Function to extract the maximum value from the heap
    public int extractMax() {
        if (size == 0) {
            System.out.println("Heap is empty. Cannot extract.");
            return -1;
        }
        int max = heap[1]; // The root of the heap contains the maximum value
        heap[1] = heap[size];
        size--;
        maxHeapify(1); // Heapify the root downwards
        return max;
    }

    // Function to heapify downwards from a given index
    private void maxHeapify(int index) {
        int left = 2 * index; // Left child index
        int right = 2 * index + 1; // Right child index
        int largest = index;
        // Find the largest among root, left child and right child
        if (left <= size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right <= size && heap[right] > heap[largest]) {
            largest = right;
        }
        // Swap and continue heapifying if root is not largest
        if (largest != index) {
            swap(index, largest);
            maxHeapify(largest);
        }
    }

    // Function to swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Function to print the heap
    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Main function to test the heap operations
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(25);
        maxHeap.insert(6);
        maxHeap.insert(8);
        maxHeap.insert(12);
        maxHeap.insert(14);
        maxHeap.insert(18);
        System.out.println("Max Heap:");
        maxHeap.printHeap();
        int max = maxHeap.extractMax();
        System.out.println("Extracted Maximum: " + max);
        System.out.println("Max Heap after extraction:");
        maxHeap.printHeap();
    }
}