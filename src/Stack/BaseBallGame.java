package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Utility class to simulate a baseball game score calculator.
 *
 * <p>Given an array of operations, each operation is one of:
 * <ul>
 *   <li>An integer (as a string) → add that integer to the record.</li>
 *   <li>"C" → remove the last score from the record.</li>
 *   <li>"D" → double the last score and add it to the record.</li>
 *   <li>"+" → add the sum of the last two scores to the record.</li>
 * </ul>
 * After processing all operations, compute the total score (sum of all current scores).</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use a stack (Deque<Integer>) to maintain the current record of scores.</li>
 *   <li>For each operation:
 *     <ul>
 *       <li>If the token is an integer, push it to the stack.</li>
 *       <li>If "C", remove the top element.</li>
 *       <li>If "D", push double the top element.</li>
 *       <li>If "+", compute the sum of the last two elements and push the result.</li>
 *     </ul>
 *   </li>
 *   <li>Finally, sum all elements remaining in the stack and return the total.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n) where n = operations.length, since each element is pushed/popped at most once.<br>
 * <b>Space Complexity:</b> O(n) for the stack to store the intermediate scores.</p>
 *
 * @author Arpan Das
 * @since 06/04/2026
 */
public class BaseBallGame {

    /**
     * Computes the total score after executing all operations.
     *
     * <p>The operations are applied in order, and the stack is updated according to the
     * specified rules for "C", "D", and "+". The final result is the sum of all scores
     * currently in the stack.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: operations = ["5","2","C","D","+"]
     * Output: 30
     * Explanation:
     *   "5" → record = [5]
     *   "2" → record = [5,2]
     *   "C" → record = [5] (remove 2)
     *   "D" → record = [5,10] (10 = 5*2)
     *   "+" → record = [5,10,15] (15 = 5+10)
     *   Sum = 5+10+15 = 30
     *
     * Input: operations = ["5","-2","4","C","D","9","+","+"]
     * Output: 27
     * Explanation:
     *   ... process each operation ...
     *   Final sum of all remaining scores is 27.
     * </pre>
     *
     * @param operations non‑null array of operations (strings)
     * @return the total score after processing all operations
     */
    public int calPoints(String[] operations) {
        Deque<Integer> points = new ArrayDeque<>();

        for (String item : operations) {
            switch (item) {
                case "+" -> sumOfLastTwo(points);
                case "C" -> points.pop();
                case "D" -> {
                    int curr = points.peek();
                    points.push(curr * 2);
                }
                default -> points.push(Integer.parseInt(item));
            }
        }

        int res = 0;
        for (int item : points) {
            res += item;
        }
        return res;
    }

    /**
     * Helper method to add the sum of the last two scores to the record.
     *
     * <p>If there are fewer than two scores, this method does nothing. Otherwise, it pops the last
     * score, adds it to the one before it, then pushes both scores back plus the new sum.</p>
     *
     * @param points non‑null stack of scores
     */
    private void sumOfLastTwo(Deque<Integer> points) {
        if (points.size() < 2) {
            return;
        }
        int a = points.pop();
        int b = points.peek();
        points.push(a);
        points.push(a + b);
    }
}