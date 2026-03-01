package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class to find unique combinations summing to target from candidates (with duplicates).
 *
 * <p>Given array {@code candidates} (may contain duplicates) and {@code target}, return all unique
 * combinations summing to exact target where each number used at most once. Order doesn't matter.</p>
 *
 * <p><b>Approach:</b> Backtracking with Sorting + Duplicate Skipping</p>
 * <ul>
 *   <li>Sort candidates to group duplicates</li>
 *   <li>Start index prevents reuse of same element</li>
 *   <li>Skip duplicates: {@code if(i>start && candidates[i]==candidates[i-1]) continue}</li>
 *   <li>Prune: {@code if(curr > target) break}</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(2^t × t), t=sum(target/candidates[i]).<br>
 * <b>Space Complexity:</b> O(t) recursion depth + O(n log n) sorting.</p>
 *
 * @author Arpan Das
 * @since 01/03/2026
 */

public class CombinationSum2 {

    /**
     * Returns all unique combinations summing to target (each number used once).
     *
     * <p>Backtracking with duplicate skipping ensures unique results.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: candidates = [10,1,2,7,6,1,5], target = 8
     * Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
     * Note: [1,1,6] only once despite two 1s ✓
     *
     * Input: candidates = [2,5,2,1,2], target = 5
     * Output: [[1,2,2],[5]]
     * Note: [1,2,2] only once despite multiple 2s ✓
     *
     * Input: candidates = [], target = 1
     * Output: []
     * </pre>
     *
     * @param candidates candidate numbers (with possible duplicates)
     * @param target     target sum
     * @return unique combinations
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;

        // Sort to handle duplicates easily
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    /**
     * Backtracking: builds combinations with duplicate skipping.
     *
     * <p>@param start minimum index to consider (prevents reuse)</p>
     */
    private void backTracking(int[] candidates, int target, int start,
                              List<List<Integer>> result, List<Integer> combination) {
        // Base case: found valid combination
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        // Try candidates from start index
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates to avoid duplicate combinations
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            int curr = candidates[i];
            if (curr > target) {
                break;  // Pruning: remaining elements too large
            }

            combination.add(curr);                    // Choose
            backTracking(candidates, target - curr, i + 1, result, combination);  // Explore
            combination.removeLast();  // Backtrack
        }
    }
}
