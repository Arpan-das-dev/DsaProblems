package Greedy;

/**
 * Utility class to determine if you can reach the last index of an array via jumps.
 *
 * <p>Given an array of non-negative integers {@code nums}, you are initially positioned
 * at the first index. nums[i] represents the maximum jump length from index i. Return
 * {@code true} if you can reach the last index, {@code false} otherwise.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li><b>Greedy (Maximum Reach):</b> Track the farthest index reachable so far ({@code maxReach}).</li>
 *   <li>Iterate through indices from 0 to n-1:</li>
 *   <ul>
 *     <li>If current index > maxReach, cannot reach it → return false</li>
 *     <li>Update maxReach = max(maxReach, index + nums[index])</li>
 *   </ul>
 *   <li>If maxReach ≥ n-1 after iteration, can reach the end → return true</li>
 * </ul>
 *
 * <p>This greedy approach works because at each step, we want to maximize future options
 * by choosing the position that extends reach farthest.</p>
 *
 * <p><b>Time Complexity:</b> O(n), single pass through the array.<br>
 * <b>Space Complexity:</b> O(1), only one variable used.</p>
 *
 * @author Arpan Das
 * @since 03/02/2026
 */
public class JumpGame1 {

    /**
     * Determines if you can reach the last index using the given jump lengths.
     *
     * <p>Greedily tracks the maximum reachable index. If at any point the current index
     * exceeds maxReach, it's impossible to proceed.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step (2→3), from index 1 jump 3 steps (3→4) → reach end.
     *
     * Input:  nums = [3,2,1,0,4]
     * Output: false
     * Explanation: Can reach index 3 (0), but nums[3] = 0 cannot jump to index 4.
     *
     * Input:  nums = [0]
     * Output: true
     * Explanation: Already at last index.
     *
     * Input:  nums = [2,0,0]
     * Output: true
     * Explanation: Jump 2 steps from index 0 to reach end.
     * </pre>
     *
     * @param nums array where nums[i] = max jump length from index i
     * @return true if last index is reachable, false otherwise
     */
    public boolean canJump(int[] nums) {
        int maxReach = 0; // Farthest index reachable so far

        for (int index = 0; index < nums.length; index++) {
            // Cannot reach current index → game over
            if (index > maxReach) return false;

            // Update maximum reachable index from current position
            maxReach = Math.max(maxReach, index + nums[index]);
        }

        // Reached or passed the last index
        return true;
    }
}

