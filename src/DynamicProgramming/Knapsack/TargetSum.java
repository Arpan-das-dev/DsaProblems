package DynamicProgramming.Knapsack;

/**
 * Utility class to count ways to assign +/− to reach target sum (NeetCode 150 sheet).
 *
 * <p>LeetCode 494: Given {@code nums} array, count ways to assign + or - to each element so sum = target.</p>
 *
 * <p><b>Approaches:</b></p>
 * <ul>
 *   <li><b>Brute:</b> DFS 2^ n backtracking</li>
 *   <li><b>DP 0/1 Knapsack:</b> Transform to subset sum problem</li>
 * </ul>
 *
 * <p>Key: Let P=sum(+), M=sum(-). P+M=sum, P-M=target → P=(sum+target)/2</p>
 *
 * <p>{@code @code Time: O(n×sum/2), Space: O(sum/2)}<p>
 *
 * @author Arpan Das
 * @since 27/03/2026
 * <p><b>Part of {@code NeetCode 150} </b></p>
 */
public class TargetSum {

    private int count;

    /**
     * Brute force DFS: try +/− for each number.
     *
     * <p>Exponential 2^n, counts valid assignments.</p>
     */
    public int findTargetSumWaysBrute(int[] nums, int target) {
        count = 0;
        backtrack(nums, target, 0);
        return count;
    }

    private void backtrack(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0) {
                count++;
            }
            return;
        }

        int num = nums[index];
        backtrack(nums, target - num, index + 1);  // Assign -
        backtrack(nums, target + num, index + 1);  // Assign +
    }

    /**
     * Optimal DP: subset sum transformation.
     *
     * <p>Find subsets summing to (total+target)/2 = P (positive group).</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums=[1,1,1,1,1], target=3
     * P=3, M=2 → 3 ways ✓
     * Output: 5 (wait, actually 5 ways: +++--, ++-+-, etc.)
     *
     * Input: nums=[1,2,3], target=0 → Output: 1 (+-+)
     * </pre>
     *
     * @param nums non-negative integers
     * @param target target sum
     * @return number of valid assignments
     */
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Feasibility checks
        if ((totalSum + target) % 2 != 0 || Math.abs(target) > totalSum) {
            return 0;
        }

        int subsetSum = (totalSum + target) / 2;
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;  // 1 way to make sum 0

        // 0/1 knapsack for subset sum
        for (int num : nums) {
            // Reverse to avoid using same num multiple times
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[subsetSum];
    }
}