public class MakingChange {
    // Function to count the number of ways to make change for a given amount
    public static int countWaysToMakeChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // There's one way to make change for 0.

        // Iterate over each coin
        for (int coin : coins) {
            // For each coin, iterate from coin value to amount
            for (int i = coin; i <= amount; i++) {
                // Add the number of ways to make change for (i - coin) to dp[i]
                dp[i] += dp[i - coin];
            }
        }

        // Return the number of ways to make change for the given amount
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5}; // The denominations of the coins
        int amount = 5; // The amount for which we want to make change

        // Compute the number of ways to make change for the given amount
        int ways = countWaysToMakeChange(coins, amount);

        // Print the number of ways to make change
        System.out.println("Number of ways to make change: " + ways);
    }
}