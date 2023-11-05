public class LinearSearch {
    // This function returns index of element x in arr[]
    static int search(int arr[], int n, int x) {
        for (int i = 0; i < n; i++) {
            // Return the index of the element if the element is found
            if (arr[i] == x)
                return i;
        }

        // return -1 if the element is not found
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = { 10, 20, 30, 40, 50, 60 };
        int x = 30;
        int n = arr.length;

        // Function call
        int result = search(arr, n, x);
        if (result == -1)
            System.out.println("Element is not present in array");
        else
            System.out.println("Element is present at index " + result);
    }
}