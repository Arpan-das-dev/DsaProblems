package Mathematical;
//Input: matrix = [[1,2,3],
//                 [4,5,6],
//                 [7,8,9]]
//Output: [[7,4,1],
//         [8,5,2],
//         [9,6,3]]
public class RotateImage {
    public void rotateBrute(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] rotated = new int[cols][rows];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                rotated [c][rows-1-r] = matrix[r][c];
            }
        }
    }

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int c = 0;
            int d = matrix.length - 1;
            while (c < d) {
                int temp = matrix[i][c];
                matrix[i][c] = matrix[i][d];
                matrix[i][d] = temp;
                c++;
                d--;
            }
        }
    }
}
