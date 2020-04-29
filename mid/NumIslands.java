package mid;

public class NumIslands {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int r = grid.length;
        int l = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    refill(grid, i, j, r, l);
                }
            }
        }
        return count;
    }

    public void refill(char[][] grid, int x, int y, int r, int l) {
        if (x >= r || y >= l || x < 0 || y < 0) {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '2';
            refill(grid, x + 1, y, r, l);
            refill(grid, x - 1, y, r, l);
            refill(grid, x, y + 1, r, l);
            refill(grid, x, y - 1, r, l);
        } else {
            return;
        }

    }

}
