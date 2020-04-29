package mid;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, process(grid, i, j));
                }
            }
        }
        return max;
    }

    public int process(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return 0;
        }
        if (grid[x][y] == 0) {
            return 0;
        }
        if (grid[x][y] == 2) {
            return 0;
        }
        grid[x][y] = 2;
        return process(grid, x + 1, y) + process(grid, x - 1, y) +
                process(grid, x, y + 1) + process(grid, x, y - 1) + 1;
    }
}
