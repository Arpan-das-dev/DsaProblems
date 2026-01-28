package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to find all unique combinations in candidates that sum to target.
 *
 * <p>Given an array of distinct positive integers {@code candidates} and a target integer {@code target},
 * return a list of all unique combinations of {@code candidates} where the chosen numbers sum to {@code target}.
 * Each number in {@code candidates} may be used unlimited times.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use backtracking to explore all possible combinations.</li>
 *   <li>At each step, for the current index in candidates:
 *     <ul>
 *       <li><b>Include</b> the current number: add it to the current combination, recurse with reduced target
 *           and same index (since unlimited usage), then backtrack by removing it.</li>
 *       <li><b>Exclude</b> the current number: recurse with the next index (skip current number).</li>
 *     </ul>
 *   </li>
 *   <li><b>Base cases:</b>
 *     <ul>
 *       <li>If target = 0: found valid combination → add copy of current to result</li>
 *       <li>If target < 0 or no more candidates: invalid → return</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p>This generates all valid combinations efficiently by pruning invalid paths early.</p>
 *
 * <p><b>Time Complexity:</b> O(N^(T/M + 1)), where N = candidates.length, T = target, M = min(candidates).
 * Exponential but bounded by the number of combinations.<br>
 * <b>Space Complexity:</b> O(T/M) for recursion depth + O(number of combinations) for result.</p>
 *
 * @author Arpan Das
 * @since 28/01/2026
 */
public class CombinationSum {

    /**
     * Returns all unique combinations in {@code candidates} that sum to {@code target}.
     *
     * <p>Each number in {@code candidates} may be used unlimited times. The solution set must
     * not contain duplicate combinations. The answer may be returned in any order.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  candidates = [2,3,6,7], target = 7
     * Output: [[2,2,3],[7]]
     * Explanation: [2,2,3] = 2+2+3=7 and [7]=7.
     *
     * Input:  candidates = [2,3,5], target = 8
     * Output: [[2,2,2,2],[2,3,3],[3,5]]
     * Explanation: All combinations summing to 8.
     *
     * Input:  candidates = [2], target = 1
     * Output: []
     * Explanation: No combination sums to 1.
     * </pre>
     *
     * @param candidates array of positive distinct integers
     * @param target     the target sum
     * @return list of all unique combinations summing to target
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    /**
     * Recursive backtracking helper to build combinations summing to target.
     *
     * <p>Explores two choices at each step:
     * <ul>
     *   <li><b>Include current candidate:</b> add candidates[index], recurse with reduced target
     *       and same index (unlimited usage), then backtrack by removing it.</li>
     *   <li><b>Exclude current candidate:</b> recurse with next index (skip current number).</li>
     * </ul>
     * </p>
     *
     * @param candidates array of candidate numbers
     * @param target     remaining target sum
     * @param index      current index in candidates to consider
     * @param current    current combination being built
     * @param result     list of all valid combinations found so far
     */
    private void backTrack(int[] candidates, int target, int index, ArrayList<Integer> current,
                           List<List<Integer>> result) {
        // Base case 1: Found valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Base case 2: Invalid state (target negative or no more candidates)
        if (target < 0 || index >= candidates.length) {
            return;
        }

        // Choice 1: Include current candidate (unlimited usage)
        current.add(candidates[index]);
        backTrack(candidates, target - candidates[index], index, current, result); // same index
        current.removeLast(); // backtrack

        // Choice 2: Exclude current candidate (move to next)
        backTrack(candidates, target, index + 1, current, result);
    }
}

