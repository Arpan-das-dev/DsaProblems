package Mathematical;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> integers = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return integers;

        int left = 0;
        int right = matrix[0].length - 1;

        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {

            // go left -> right
            for(int col = left; col<=right; col ++) {
                integers.add(matrix[top][col]);
            }
            // move to next row
            top++;
            // go top -> bottom
            for (int row = top; row <= bottom; row++){
                integers.add(matrix[row][right]);
            }
            right--;

            // reached bottom line
            if (top <= bottom) {
                // right → left
                for (int col = right; col >= left; col--) {
                    integers.add(matrix[bottom][col]);
                }
                bottom--;
            }

            if (left <= right) {
                // bottom → top
                for (int row = bottom; row >= top; row--) {
                    integers.add(matrix[row][left]);
                }
                left++;
            }
        }
        return integers;
    }


}
