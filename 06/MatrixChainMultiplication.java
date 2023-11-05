public class MatrixChainMultiplication {
    // Function to find the most efficient way to multiply a given sequence of matrices
    public static int matrixChainOrder(int[] p) {
        int n = p.length - 1;
        int[][] m = new int[n][n];

        // Initialize the cost matrix
        for (int i = 1; i < n; i++) {
            m[i][i] = 0; // The cost is zero when multiplying one matrix.
        }

        // Compute optimal cost for chains of length 2 to n
        for (int chainLength = 2; chainLength < n; chainLength++) {
            for (int i = 1; i < n - chainLength + 1; i++) {
                int j = i + chainLength - 1;
                m[i][j] = Integer.MAX_VALUE; // Initialize this cell to a large value

                // Try all possible splits to find the minimum cost
                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < m[i][j]) {
                        m[i][j] = cost; // Update the cost if current one is lower
                    }
                }
            }
        }

        // Return the minimum cost for multiplying the entire chain
        return m[1][n - 1];
    }

    public static void main(String[] args) {
        int[] dimensions = {30, 35, 15, 5, 10, 20, 25};

        // Compute the minimum number of multiplications needed to multiply the chain
        int minMultiplications = matrixChainOrder(dimensions);
        System.out.println("Minimum number of multiplications: " + minMultiplications);
    }
}