package DynamicProgramming;
/**
 * Utility class for calculating the number of distinct ways to climb a staircase.
 *
 * <p>Given a staircase with n steps, where each step can be climbed using either 1
 * or 2 steps at a time, compute the total number of distinct ways to reach the top.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>This is the classic Fibonacci sequence problem where ways[n] = ways[n-1] + ways[n-2].</li>
 *   <li>Instead of using an array or recursion, use two variables to track the previous two values.</li>
 *   <li>Iterate from step 3 to n, computing the current number of ways as the sum of the two previous values.</li>
 * </ul>
 *
 * <p>Space-optimized solution that avoids storing the entire sequence and prevents
 * exponential time from naive recursion.</p>
 *
 * <p><b>Time Complexity:</b> O(n), linear iteration through the steps.<br>
 * <b>Space Complexity:</b> O(1), only two variables used regardless of input size.</p>
 *
 * @author Arpan Das
 * @since 10/01/2026
 */
public class ClimbStairs {

    /**
     * Returns the number of distinct ways to climb n stairs, taking 1 or 2 steps at a time.
     *
     * <p>Base cases: 1 step = 1 way, 2 steps = 2 ways (1+1 or 2).
     * For n ≥ 3, ways(n) = ways(n-1) + ways(n-2).</p>
     *
     * @param n number of steps to climb
     * @return the number of distinct ways to reach the top
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int prev2 = 1; // ways to climb 1 step
        int prev1 = 2; // ways to climb 2 steps

        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2; // Fibonacci: sum of previous two
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
