package DynamicProgramming.LinearDP;

/**
 * Utility class to compute the n‑th Tribonacci number.
 *
 * <p>The Tribonacci sequence is defined as:
 * <ul>
 *   <li>T(0) = 0</li>
 *   <li>T(1) = 1</li>
 *   <li>T(2) = 1</li>
 *   <li>T(n) = T(n‑1) + T(n‑2) + T(n‑3) for n ≥ 3</li>
 * </ul>
 * This class provides multiple implementations: naive recursion, DP with extra space, and optimized constant‑space iteration.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li><b>Recursion</b> → purely recursive: for n ≥ 3, recurse on n‑1, n‑2, n‑3; base cases at 0 and 1,2.</li>
 *   <li><b>DP with extra space</b> → build an array dp[0..n] bottom‑up, initializing T₀, T₁, T₂, then filling T₃..Tₙ.</li>
 *   <li><b>Space‑optimized iteration</b> → keep only three variables (a, b, c) representing the last three values and update them in a loop.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b>
 *   <ul>
 *     <li>Recursive: O(3^n) (exponential, inefficient).</li>
 *     <li>DP with extra space: O(n).</li>
 *     <li>Space‑optimized iteration: O(n).</li>
 *   </ul>
 * <b>Space Complexity:</b>
 *   <ul>
 *     <li>Recursive: O(n) for the call stack.</li>
 *     <li>DP with extra space: O(n) for the dp array.</li>
 *     <li>Space‑optimized iteration: O(1).</li>
 *   </ul>
 * </p>
 *
 * @author Arpan Das
 * @since 12/04/2026
 */
public class Tribonacci {

    /**
     * Returns the n‑th Tribonacci number using a naive recursive approach.
     *
     * <p>For small n this is straightforward but runs in exponential time due to repeated subproblems:
     * each call branches into three smaller calls. This is mainly for educational comparison.</p>
     *
     * @param n index of the Tribonacci number to compute (0‑indexed, n ≥ 0)
     * @return T(n) as defined by the Tribonacci recurrence
     */
    public int tribonacciRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        return tribonacciRecursion(n - 1)
                + tribonacciRecursion(n - 2)
                + tribonacciRecursion(n - 3);
    }

    /**
     * Returns the n‑th Tribonacci number using bottom‑up DP with O(n) space.
     *
     * <p>Builds an array dp[0..n] where dp[i] stores T(i). The array is filled iteratively
     * from dp[0] = 0, dp[1] = 1, dp[2] = 1, and for i ≥ 3: dp[i] = dp[i‑1] + dp[i‑2] + dp[i‑3].</p>
     *
     * @param n index of the Tribonacci number to compute (0‑indexed, n ≥ 0)
     * @return T(n) computed via DP array
     */
    public int tribonacciExtraSpaceDp(int n) {
        if (n == 0) {
            return 0;
        }
        if (n >= 1 && n <= 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    /**
     * Returns the n‑th Tribonacci number using an iterative method with O(1) space.
     *
     * <p>Instead of storing the whole array, keep only the last three values (a, b, c) representing
     * T(i‑3), T(i‑2), T(i‑1). In each iteration update:
     * new‑c = a + b + c, then shift a←b, b←c, c←new‑c.</p>
     *
     * @param n index of the Tribonacci number to compute (0‑indexed, n ≥ 0)
     * @return T(n) computed via iterative sliding window
     */
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }

        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int sum = a + b + c;
            a = b;
            b = c;
            c = sum;
        }
        return c;
    }
}