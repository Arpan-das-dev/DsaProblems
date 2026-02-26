package Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    private final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> rotten = new LinkedList<>();
        int fresh = 0;
        int min = 0;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 2) rotten.offer(new int[]{r, c});
                if(grid[r][c] == 1) fresh++;
            }
        }

        while (!rotten.isEmpty() && fresh > 0) {
            int size = rotten.size();

            for (int i = 0; i < size; i++) {
                int[] rot = rotten.poll();
                for (int[] dir : directions) {
                    int nr = rot[0] + dir[0];
                    int nc = rot[1] + dir[1];

                    if (nc >= 0 && nr >= 0 && nr < row && nc < col) {
                        if(grid[nr][nc] == 1) {
                            grid[nr][nc] = 2;
                            rotten.offer(new int[]{nr, nc});
                            fresh--;
                        }
                    }
                }
            }
            min++;
        }
        return fresh == 0 ? min : -1;
    }
}
