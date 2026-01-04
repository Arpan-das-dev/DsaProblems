package TwoPointers;

public class ContainerWithMostWater {

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
