package BackTracking;

import java.util.ArrayList;
import java.util.List;


/**
 * Utility class to generate all combinations of k numbers chosen from 1 to n.
 *
 * <p>Given two integers n and k, return all possible combinations of k numbers out of the range 1 to n, in
 * lexicographic order. Each combination is a list of integers of length k.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach (backtracking with pruning):</b></p>
 * <ul>
 *   <li>Use a recursive backtracking strategy that builds combinations incrementally.</li>
 *   <li>At each step, iterate from the current starting integer up to a pruned upper bound:
 *       <code>i <= n - (k - integers.size()) + 1</code>
 *       to ensure enough remaining numbers exist to form a valid combination of size k.</li>
 *   <li>Once the current path (integers) reaches size k, add a copy to the result list and return.</li>
 *   <li>On each return, remove the last added element to backtrack and try the next integer.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(C(n, k)) where C(n, k) is the number of combinations of n choose k.<br>
 * <b>Space Complexity:</b> O(k) for the recursion stack and the temporary list, plus O(k * C(n, k))
 * for the result list (storing all combinations).</p>
 *
 * @author Arpan Das
 * @since 13/04/2026
 */
public class Combinations1 {

    /**
     * Returns all combinations of k numbers chosen from 1 to n.
     *
     * <p>The combinations are returned in lexicographic order, and each combination is a list of
     * exactly k distinct integers between 1 and n inclusive. If k is 0, an empty list of combinations
     * is returned. If k &gt; n, no valid combinations exist, so an empty list of combinations is returned.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: n = 4, k = 2
     * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
     *
     * Input: n = 1, k = 1
     * Output: [[1]]
     * </pre>
     *
     * @param n upper bound of the range [1, n] (n ≥ 1)
     * @param k size of each combination (0 ≤ k ≤ n)
     * @return list of all k‑length combinations chosen from 1 to n
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(1, n, k, result, new ArrayList<>());
        return result;
    }

    /**
     * Recursive helper that builds combinations via backtracking.
     *
     * <p>This method:
     * <ul>
     *   <li>Starts from the given integer and iterates up to a pruned upper bound.</li>
     *   <li>Adds the current integer to the partial combination, recurses with the next integer,
     *       then removes it to backtrack.</li>
     *   <li>When the current combination reaches size k, a copy is added to the result list.</li>
     * </ul>
     * The pruning ensures that the loop does not run into states where there are not enough numbers
     * remaining to reach size k.</p>
     *
     * @param integer current starting integer (in the range [1, n])
     * @param n upper bound of the range [1, n]
     * @param k size that each combination must have
     * @param result list of valid combinations (passed by reference)
     * @param integers current partial combination (passed by reference)
     */
    private void backTrack(int integer, int n, int k, List<List<Integer>> result, ArrayList<Integer> integers) {
        if (integers.size() == k) {
            result.add(new ArrayList<>(integers));
            return;
        }

        // Pruned loop: i <= n - (k - integers.size()) + 1
        for (int i = integer; i <= n - (k - integers.size()) + 1; i++) {
            integers.add(i);
            backTrack(i + 1, n, k, result, integers);
            integers.removeLast();
        }
    }
}