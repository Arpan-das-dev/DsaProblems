package TwoPointers;
/**
 * Utility class for calculating the maximum area of water that can be contained
 * between two vertical lines on a coordinate plane.
 *
 * <p>Given an array of non-negative integers representing line heights, the goal
 * is to identify two lines that together with the x-axis form a container capable
 * of holding the maximum possible volume of water.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use a two-pointer technique, starting from both ends of the array.</li>
 *   <li>At each step, calculate the container area and move the pointer at the shorter line inward.</li>
 *   <li>This ensures linear-time traversal while maintaining the global maximum.</li>
 * </ul>
 *
 * <p>This method leverages the insight that increasing the shorter boundary may lead
 * to a larger area, whereas moving the taller one cannot improve the result.</p>
 *
 * <p><b>Time Complexity:</b> O(n), since the array is traversed once.<br>
 * <b>Space Complexity:</b> O(1), as only constant extra variables are used.</p>
 *
 * @author Arpan Das
 * @since 04/01/2026
 */
public class ContainerWithMostWater {

    /**
     * Computes the maximum amount of water that can be contained between two lines.
     *
     * <p>The water area between two lines at indices {@code left} and {@code right} is given by:</p>
     *
     * <pre>
     *   Area = min(height[left], height[right]) × (right - left)
     * </pre>
     *
     * <p>The algorithm iteratively narrows the search by updating pointers
     * from both ends and tracking the maximum area encountered.</p>
     *
     * @param heights an array of non-negative integers representing line heights
     * @return the maximum possible water area
     */
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int water = 0;
        while(left<right) {
            if(heights[left] < heights[right]) { // enter this block when left is the min limit
                int content = heights[left]*(right-left); // simple physics rule to calculate volume
                water = Math.max(content,water); // ensure only max amount is stored
                left ++; // updating pointers
            }
            else { // enter this block when right is the min limit or if they both are same
                int content = heights[right] * (right-left); // simple physics rule to calculate volume
                water = Math.max(content,water); // ensure only max amount is stored
                right--; // updating pointers
            }
        }
        return water;
    }
}
