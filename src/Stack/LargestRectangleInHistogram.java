package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int maxArea(int [] heights ) {
        if(heights == null || heights.length == 0) return 0;

        Stack<Integer> boundaries = new Stack<>();
        boundaries.push(-1);

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            while (boundaries.peek()!=-1 && heights[i] <= heights[boundaries.peek()]) {
                int height = heights[boundaries.pop()];
                int left = heights[boundaries.peek()];
                int width = i-left-1;
                maxArea = Math.max(maxArea,height*width);
            }
            boundaries.push(i);
        }

        while (boundaries.peek()!= -1) {
            int height = boundaries.pop();
            int left = boundaries.peek();
            int width = heights.length - left - 1;
            maxArea = Math.max(maxArea,height*width);
        }
        return maxArea;
    }
}
