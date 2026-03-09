package BackTracking;

import java.util.ArrayList;
import java.util.List;


/**
 * Utility class to generate all possible subsets (power set) of given array.
 *
 * <p>Given array {@code nums} of distinct integers, return all 2^n possible subsets (including
 * empty set and full set). Each element either included or excluded.</p>
 *
 * <p><b>Approach:</b> Backtracking (Include/Exclude Decision Tree)</p>
 * <ul>
 *   <li>For each element: two choices → include OR exclude</li>
 *   <li>{@code start} parameter ensures each element processed once</li>
 *   <li>Include path → recurse → backtrack, then exclude path → recurse</li>
 *   <li>Base case: {@code start == n} → add current subset copy</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(2^n × n), 2^n subsets × n copy time.<br>
 * <b>Space Complexity:</b> O(n) recursion + O(2^n × n) result.</p>
 *
 * @author Arpan Das
 * @since 09/03/2026
 */

public class SubSets {

    /**
     * Returns all possible subsets of nums.
     *
     * <p>Backtracking explores include/exclude decisions for each element.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums = [1,2,3]
     * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 2³=8 subsets ✓
     *
     * Input: nums = [0]
     * Output: [[],[0]] ✓
     *
     * Input: nums = []
     * Output: [[]] ✓ (empty set)
     * </pre>
     *
     * @param nums array of distinct integers
     * @return all 2^n subsets
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        backTrack(nums, result, new ArrayList<>(), 0);
        return result;
    }

    /**
     * Backtracking: decides include/exclude for nums[start].
     *
     * <p>@param start current index to consider</p>
     */
    private void backTrack(int[] nums, List<List<Integer>> result,
                           List<Integer> current, int start) {
        // Base case: processed all elements
        if (start == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: Include current element
        current.add(nums[start]);
        backTrack(nums, result, current, start + 1);
        current.removeLast();  // Backtrack

        // Choice 2: Exclude current element
        backTrack(nums, result, current, start + 1);
    }
}
