import java.io.*;
import java.util.*;

public class ImplementLCS {
    // Method to find the longest common subsequence
    public static String longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // Create a 2D array to store the lengths of common subsequences
        int[][] dp = new int[m + 1][n + 1];

        // Iterate over the strings
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, increment the length of common subsequence
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // If characters don't match, take the maximum length found so far
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Length of the longest common subsequence
        int len = dp[m][n];
        // Array to store the common subsequence
        char[] lcs = new char[len];

        // Start from the end of strings and fill the lcs array
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                lcs[len - 1] = text1.charAt(i - 1);
                i--;
                j--;
                len--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // Return the longest common subsequence
        return new String(lcs);
    }

    // Main method
    public static void main(String[] args) {
        String text1 = "AGGTAB";
        String text2 = "GXTXAYB";
        // Call the method and print the result
        String lcs = longestCommonSubsequence(text1, text2);
        System.out.println("Longest Common Subsequence: " + lcs);
    }
}