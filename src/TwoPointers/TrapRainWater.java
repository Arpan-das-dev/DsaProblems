package TwoPointers;

public class TrapRainWater {

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
