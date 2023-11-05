public class FactorialIterative {
    // Method to calculate factorial of a number iteratively
    public static long factorial(int n) {
        // Throw an exception if the input number is negative
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }

        // Initialize the result to 1
        long result = 1;

        // Multiply the result with each number from 1 to n
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        // Return the final result
        return result;
    }

    // Main method to test the factorial function
    public static void main(String[] args) {
        // Define the number for which we want to calculate the factorial
        int number = 5; // Change this to the desired number

        // Calculate the factorial of the number
        long result = factorial(number);

        // Print the result
        System.out.println("Factorial of " + number + " is " + result);
    }
}