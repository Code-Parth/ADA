public class BubbleSort {
    // Method to perform bubble sort
    void bubbleSort(int arr[]) {
        int n = arr.length;
        // Outer loop for 'n' elements
        for (int i = 0; i < n - 1; i++)
            // Inner loop for 'n-i' elements
            for (int j = 0; j < n - i - 1; j++)
                // If current element is greater than next
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    // Method to print an array
    void printArray(int arr[]) {
        int n = arr.length;
        // Loop through all elements
        for (int i = 0; i < n; ++i)
            // Print current element
            System.out.print(arr[i] + " ");
        // Print newline
        System.out.println();
    }

    // Driver method to test above
    public static void main(String args[]) {
        BubbleSort bs = new BubbleSort();
        int arr[] = { 10, 1, 5, 2, 8 };
        // Perform bubble sort
        bs.bubbleSort(arr);
        System.out.println("Sorted array: ");
        // Print sorted array
        bs.printArray(arr);
    }
}
