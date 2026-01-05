package Stack;

import java.util.Stack;

/**
 * Utility class for finding the number of days until a warmer temperature
 * is recorded for each day in a given temperature array.
 *
 * <p>Given a daily temperature array, return an array where each element
 * represents the number of days to wait until a strictly warmer temperature
 * is observed. If no warmer temperature exists, return 0 for that day.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li><b>Brute Force:</b> Nested loops check each future day (O(n²)).</li>
 *   <li><b>Optimal:</b> Monotonic stack maintains decreasing temperature order
 *       while storing indices for O(1) future warmer temperature lookup.</li>
 * </ul>
 *
 * <p>The stack solution processes temperatures from right to left, ensuring
 * only relevant (warmer) future temperatures remain available.</p>
 *
 * <p><b>Time Complexity:</b> O(n) for stack solution, O(n²) for brute force.<br>
 * <b>Space Complexity:</b> O(n) for both result array and stack.</p>
 *
 * @author Arpan Das
 * @since 05/01/2026
 */
public class DailyTemperatures {

    /**
     * Brute force solution using nested loops to find warmer temperatures.
     *
     * <p>For each day i, linearly search all future days until finding
     * first warmer temperature or reaching end of array.</p>
     *
     * @param temps array of daily temperatures
     * @return array where result[i] = days until warmer temperature, or 0
     */

    public int[] dailyTempBrute(int[] temps) {
        int[] day = new int[temps.length];

        for (int i = 0; i < temps.length - 1; i++) {
            for (int j = i+1; j < temps.length ; j++) {
                if(temps[j] > temps[i]) {
                    day[i] = j-i;
                    break;
                }
            }
        }
        return day;
    }

    /**
     * Optimal monotonic stack solution for finding warmer temperatures.
     *
     * <p>Maintains a stack of indices with strictly decreasing temperatures.
     * For each day, pop elements until finding warmer future temperature
     * or stack empties (no warmer temperature exists).</p>
     *
     * @param temps array of daily temperatures
     * @return array where result[i] = days until warmer temperature, or 0
     */
    public int[] dailyTempOptimal(int[] temps) {
        // stack is the best option cause order matters here with index stored
        Stack<Integer> integers = new Stack<>();
        int[] result = new int[temps.length];
        for (int i = temps.length - 1; i >= 0; i--) {
            while (!integers.isEmpty() && temps[integers.peek()] <= temps[i]) {
                integers.pop(); // if the stack is not empty and
                                // current value is greater that top element in the stack
                                // keep removing the elements
            }
            if (integers.isEmpty()) { // if it's empty surely no elements is greater that it
                result[i] = 0;
            } else {
                result[i] = integers.peek() - i;
            }
            integers.push(i); // push the new max value;
        }
        return result;
    }
}
