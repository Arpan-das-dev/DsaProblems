package DynamicProgramming;

/**
 * Utility class for solving the House Robber II problem, where houses are arranged in a circle.
 *
 * <p>Given an array representing money in houses arranged in a circle, the goal is to
 * maximize the amount robbed such that no two adjacent houses are robbed.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Since the first and last houses are adjacent in a circle, we cannot rob both.</li>
 *   <li>Split the problem into two linear subproblems:
 *     <ul>
 *       <li>Rob houses from index 0 to n−2 (excluding the last house)</li>
 *       <li>Rob houses from index 1 to n−1 (excluding the first house)</li>
 *     </ul>
 *   </li>
 *   <li>Use dynamic programming with two variables (lastDay, twoDay) to compute maximum
 *       for each linear segment in O(n) time and O(1) space.</li>
 *   <li>Return the maximum of the two scenarios.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n), where n is the number of houses.<br>
 * <b>Space Complexity:</b> O(1), only a few variables used.</p>
 *
 * @author Arpan Das
 * @since 12/01/2026
 */
public class HouseRobber2 {

    /**
     * Returns the maximum amount of money that can be robbed from circular houses
     * without robbing adjacent houses.
     *
     * <p>Handles edge cases (null, empty, single house) and then computes the maximum
     * by considering two non-overlapping linear segments of the circular array.</p>
     *
     * @param nums array where nums[i] represents money in house i
     * @return the maximum amount that can be robbed
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // Case 1: include first house, exclude last house
        int pickFirst = robLinearHouses(nums, 0, nums.length - 1);
        // Case 2: exclude first house, include last house
        int pickLast = robLinearHouses(nums, 1, nums.length);

        return Math.max(pickFirst, pickLast);
    }

    /**
     * Helper method to compute maximum money that can be robbed in a linear segment of houses.
     *
     * <p>Uses DP with two variables:
     * <ul>
     *   <li>lastDay: maximum money robbed up to the previous house</li>
     *   <li>twoDay: maximum money robbed up to two houses back</li>
     * </ul>
     * For each house, decide whether to pick it (twoDay + current) or skip it (lastDay).</p>
     *
     * @param nums  array of house values
     * @param start starting index (inclusive)
     * @param limit ending index (exclusive)
     * @return maximum money that can be robbed in the segment [start, limit)
     */
    private int robLinearHouses(int[] nums, int start, int limit) {
        int lastDay = 0;   // max money robbed up to previous house
        int twoDay = 0;    // max money robbed up to two houses back

        for (int i = start; i < limit; i++) {
            int pick = twoDay + nums[i];  // rob current house
            int skip = lastDay;           // skip current house
            int current = Math.max(pick, skip);

            twoDay = lastDay;
            lastDay = current;
        }
        return lastDay;
    }
}
