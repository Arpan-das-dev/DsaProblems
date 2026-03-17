package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Generates all unique subsets from array containing duplicates using backtracking.
 *
 * <p>Given an integer array <code>nums</code> that may contain duplicates, return all possible
 * subsets (the power set). The solution set must not contain duplicate subsets. Return the solution
 * in any order.</p>
 *
 * <p>This implementation uses backtracking with duplicate skipping to ensure uniqueness.</p>
 *
 * <p><b>Algorithm:</b></p>
 * <ul>
 * <li>Sort input array to enable duplicate detection</li>
 * <li>Backtrack generating subsets, skipping duplicates using <code>nums[j] == nums[j-1]</code></li>
 * <li>Add current subset to result at each step (includes empty subset)</li>
 * </ul>
 *
 * <p><b>Examples:</b></p>
 * <pre>
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * Input: nums = []
 * Output: [[]]
 * </pre>
 *
 * @author Arpan Das
 * @since 17/03/2026
 */
public class SubSets2 {

    /**
     * Generates all unique subsets from integer array with duplicates.
     *
     * <p>Sorts input array first, then uses backtracking to generate all unique combinations.
     * Handles edge cases of null or empty input.</p>
     *
     * @param nums integer array possibly containing duplicates
     * @return list of all unique subsets
     * @throws NullPointerException if nums is null (handled by early return)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        backTrack(nums, result, 0, new ArrayList<>());
        return result;
    }

    /**
     * Backtracking helper method to generate subsets with duplicate skipping.
     *
     * <p>At each position <code>i</code>, adds current subset to result, then tries each subsequent
     * element. Skips duplicates by checking <code>nums[j] == nums[j-1]</code> for <code>j > i</code>.</p>
     *
     * @param nums input array (sorted)
     * @param result accumulates all subsets
     * @param i current starting index for subset selection
     * @param subset current subset being built
     */
    private void backTrack(int[] nums, List<List<Integer>> result, int i,
                           ArrayList<Integer> subset) {
        // Add current subset to result (explores all combinations)
        result.add(new ArrayList<>(subset));

        // Try adding each subsequent element
        for (int j = i; j < nums.length; j++) {
            // Skip duplicates to avoid duplicate subsets
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }

            subset.add(nums[j]);
            backTrack(nums, result, j + 1, subset);
            subset.removeLast();
        }
    }
}

