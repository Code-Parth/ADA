public class Knapsack {
    // Method to solve the knapsack problem using dynamic programming
    public static int knapsack(int[] values, int[] weights, int capacity) {
        int n = values.length; // Number of items
        int[][] dp = new int[n + 1][capacity + 1]; // DP table for storing intermediate results

        // Initialize the DP table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    // Base case: no items or no capacity
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    // If the item can be included in the knapsack
                    // Choose the maximum value between including and excluding the item
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    // If the item cannot be included in the knapsack
                    // The value is the same as the previous item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // The maximum value that can be obtained with the given capacity
        return dp[n][capacity];
    }

    // Main method to test the knapsack function
    public static void main(String[] args) {
        // Define the values and weights of the items and the capacity of the knapsack
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int capacity = 50;

        // Calculate the maximum value that can be obtained
        int maxValue = knapsack(values, weights, capacity);

        // Print the result
        System.out.println("Maximum value: " + maxValue);
    }
}