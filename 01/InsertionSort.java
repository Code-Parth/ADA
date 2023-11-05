public class InsertionSort {
    // Method to sort an array using insertion sort
    void sort(int arr[]) {
        int n = arr.length;
        // Start from the second element (element at index 0 is already sorted)
        for (int i = 1; i < n; ++i) {
            // key is the element to be compared with the already sorted elements
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key, to one position ahead
            // of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // Place the key in its correct position
            arr[j + 1] = key;
        }
    }

    // Method to print an array
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Main method to test the code
    public static void main(String args[]) {
        // Define an array to be sorted
        int arr[] = { 15, 3, 12, 1, 14 };

        // Create an object of InsertionSort
        InsertionSort ob = new InsertionSort();
        // Sort the array using insertion sort
        ob.sort(arr);

        // Print the sorted array
        printArray(arr);
    }
}