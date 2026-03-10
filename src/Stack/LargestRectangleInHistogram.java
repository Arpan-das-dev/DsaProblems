package Stack;

import java.util.Stack;

/**
 * Utility class to find the largest rectangle area in histogram.
 *
 * <p>Given array {@code heights} where {@code heights[i]} = bar height and width=1, return area of
 * largest rectangle containing any contiguous bars. Area = min(height) × width of range.</p>
 *
 * <p><b>Approach:</b> Monotonic Stack (Next Smaller Element)</p>
 * <ul>
 *   <li>Maintain increasing stack of indices (sentinel -1)</li>
 *   <li>For each bar i: pop taller bars until shorter found</li>
 *   <li>For popped bar: height=h, width=i-left-1 (right=i, left=stack.top)</li>
 *   <li>Process remaining bars with right=n</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n), each bar pushed/popped once.<br>
 * <b>Space Complexity:</b> O(n) stack.</p>
 *
 * @author Arpan Das
 * @since 10/03/2026
 */

public class LargestRectangleInHistogram {

    /**
     * Returns largest rectangle area in histogram.
     *
     * <p>Monotonic stack finds width where each bar is minimum height.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: heights = [2,1,5,6,2,3]
     *        2 1 5 6 2 3
     * Stack processes: pop 6(width=2,h=6,area=12), pop 5(2,5,10), etc.
     * Largest: bars[2,3]=[5,6]→min5×2=10 ✓
     * Output: 10
     *
     * Input: heights = [2,4]
     * Output: 4 (bar1)
     * </pre>
     *
     * @param heights histogram bar heights
     * @return maximum rectangle area
     */
    public int maxArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();  // Monotonic increasing indices
        stack.push(-1);  // Left sentinel

        int maxArea = 0;
        int n = heights.length;

        // Process each bar
        for (int i = 0; i < n; i++) {
            // Pop taller bars (current i = right boundary)
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int leftBoundary = stack.peek();  // Previous smaller or sentinel
                int width = i - leftBoundary - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        // Process remaining bars (right boundary = n)
        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int leftBoundary = stack.peek();
            int width = n - leftBoundary - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}

