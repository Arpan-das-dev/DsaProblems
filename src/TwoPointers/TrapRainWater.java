package TwoPointers;
/**
 * Utility class to calculate the amount of water trapped after rainfall
 * given an elevation map represented by an integer array.
 *
 * <p>The algorithm uses an optimal <b>two-pointer technique</b> and
 * follows the physical rule that water trapped at any index is determined
 * by the <b>minimum of the maximum heights</b> on its left and right sides.</p>
 *
 * <p><b>Core Idea:</b>
 * <ul>
 *   <li>Two pointers traverse the array from both ends</li>
 *   <li>The side with the smaller height determines the water level (bottleneck)</li>
 *   <li>Maximum heights from left and right are tracked incrementally</li>
 * </ul>
 *
 * <p>This approach avoids extra space and processes each bar only once.</p>
 *
 * <p><b>Time Complexity:</b> O(n) — each index is visited once<br>
 * <b>Space Complexity:</b> O(1) — constant extra space</p>
 *
 * @author Arpan Das
 * @since 01/01/2025
 */
public class TrapRainWater {

    /**
     * Calculates the total amount of rainwater trapped between bars.
     *
     * <p>The method iteratively determines which side (left or right)
     * acts as the limiting boundary and accumulates water accordingly.</p>
     *
     * @param heights an array representing the elevation map where each element
     *                corresponds to the height of a bar
     * @return the total units of water trapped after rainfall
     */
    public int trackTrappedWater(int[] heights) {
        System.out.println("starting to calculate watter trapped by rain for size " + heights.length);
        System.out.println();
        int start = 0;
        int end = heights.length - 1;
        int leftMax = 0; // define the max height of bar on left side
        int rightMax = 0; // define the max height of bar on right side
        int water = 0;

        while (start < end) { // condition to run the loop while left pointer is less than right
            if (heights[start] < heights[end]) {
                // calculate left values when left side cause the bottleneck
                // therefore left side the max height where water can hold
                leftMax = Math.max(leftMax, heights[start]); // assign max value find till inside the loop
                if (leftMax - heights[start] > 0) {
                    water += leftMax - heights[start]; // cause the max amount hold by bars
                    // depends on the height of the bar
                }
                start++;
            } // all the logics used in the if block is used in else block
            // but here we used only right values
            else {
                rightMax = Math.max(rightMax, heights[end]);
                if (rightMax - heights[end] > 0) {
                    water += rightMax - heights[end];
                }
                end--;
            }
        }
        return water;
    }
}
