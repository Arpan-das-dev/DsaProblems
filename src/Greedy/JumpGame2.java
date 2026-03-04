package Greedy;

/**
 * Utility class to find minimum jumps to reach end of array.
 *
 * <p>Given array {@code nums} where {@code nums[i]} = max jump length from index i, return minimum
 * jumps to reach last index. Guaranteed reachable.</p>
 *
 * <p><b>Approach:</b> Greedy Range Expansion</p>
 * <ul>
 *   <li>{@code maxReach}: farthest index reachable from current position</li>
 *   <li>{@code lastJump}: end of current jump range</li>
 *   <li>Each jump covers range [prev_end+1, maxReach], increment steps at range boundary</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n) single pass.<br>
 * <b>Space Complexity:</b> O(1).</p>
 *
 * @author Arpan Das
 * @since 04/03/2026
 */
public class JumpGame2 {

    /**
     * Returns minimum jumps to reach last index.
     *
     * <p>Greedy: always extend the farthest reachable range per jump.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums = [2,3,1,1,4]
     * Range: [0,2]→steps=1, maxReach=4→[3,4]→steps=2 ✓
     * Output: 2
     *
     * Input: nums = [2,3,0,1,4]
     * Range: [0,2]→steps=1, maxReach=5→done ✓
     * Output: 2
     *
     * Input: nums = [1]
     * Output: 0
     *
     * Input: nums = [1,2,3]
     * Range: [0,1]→steps=1, maxReach=3→done ✓
     * Output: 1
     * </pre>
     *
     * @param nums jump lengths array
     * @return minimum jumps to last index
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;

        int maxReach = 0;     // Farthest reachable index
        int steps = 0;        // Jump to count
        int lastJumpEnd = 0;  // End of current jump range

        for (int i = 0; i < nums.length; i++) {
            // Update the farthest reachable from current position
            maxReach = Math.max(maxReach, i + nums[i]);

            // Reached end of current jump range: increment steps
            if (i == lastJumpEnd) {
                steps++;
                lastJumpEnd = maxReach;
            }

            // Early termination: can reach end
            if (lastJumpEnd >= nums.length - 1) {
                return steps;
            }
        }

        return steps;
    }
}
