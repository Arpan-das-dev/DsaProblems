package BackTracking;

import java.util.*;

/**
 * Utility class to generate all valid parentheses combinations of a given length.
 *
 * <p>Given n pairs of parentheses, generate all combinations that are correctly balanced.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use backtracking (DFS) to build valid strings character by character.</li>
 *   <li>At each step:
 *     <ul>
 *       <li>If we have used fewer than n opening parentheses, we can add '('.</li>
 *       <li>If we have more opening parentheses than closing ones, we can add ')'. </li>
 *     </ul>
 *   </li>
 *   <li>When the string length reaches 2*n, add it to the result list.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(4^n / √n) — the nth Catalan number bounds the number of valid strings.<br>
 * <b>Space Complexity:</b> O(4^n / √n) for the result list plus O(n) for the recursion stack and StringBuilder.</p>
 *
 * @author Arpan Das
 * @since 20/01/2026
 */
public class GenerateParenthesis {

    /**
     * Generates all valid combinations of n pairs of parentheses.
     *
     * <p>A valid combination has:
     * <ul>
     *   <li>exactly n opening '(' and n closing ')' parentheses</li>
     *   <li>at every prefix, the number of ')' never exceeds the number of '('</li>
     * </ul>
     * </p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: n = 1
     * Output: ["()"]
     *
     * Input: n = 2
     * Output: ["(())", "()()"]
     *
     * Input: n = 3
     * Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
     * </pre>
     *
     * @param n number of pairs of parentheses
     * @return list of all valid parentheses combinations of length 2*n
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result, n, 0, 0, new StringBuilder());
        return result;
    }

    /**
     * Recursive backtracking helper to build valid parentheses strings.
     *
     * <p>Builds the current string in the StringBuilder. If the length is 2*n, the string is complete and added to result.
     * Otherwise, explores:
     * <ul>
     *   <li>adding '(' if fewer than n opening parentheses are used yet</li>
     *   <li>adding ')' if the number of closing parentheses is less than opening ones</li>
     * </ul>
     * After each recursive call, the last character is removed to backtrack.</p>
     *
     * @param result      list of valid parentheses strings collected so far
     * @param max         total number of pairs (n)
     * @param open        count of '(' used so far
     * @param close       count of ')' used so far
     * @param stringBuilder current partial string being built
     */
    private void backTrack(List<String> result, int max, int open, int close, StringBuilder stringBuilder) {
        // Base case: we have built a string of length 2*max → valid solution
        if (stringBuilder.length() == 2 * max) {
            result.add(stringBuilder.toString());
            return;
        }

        // Option 1: add '(' if we haven't used all n opening parentheses
        if (open < max) {
            stringBuilder.append('(');
            backTrack(result, max, open + 1, close, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1); // backtrack
        }

        // Option 2: add ')' if there are more '(' than ')' so far
        if (close < open) {
            stringBuilder.append(')');
            backTrack(result, max, open, close + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1); // backtrack
        }
    }
}

