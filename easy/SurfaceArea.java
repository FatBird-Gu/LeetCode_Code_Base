package easy;

public class SurfaceArea {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new SurfaceArea().surfaceArea(new int[][]{
                {2, 2, 2},
                {2, 1, 2},
                {2, 2, 2}
        }));
    }

    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int r = grid.length;
        int l = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                count += countTotle(grid[i][j]);
                if (i < r - 1) {
                    count -= Math.min(grid[i][j], grid[i + 1][j]);
                }
                if (i > 0) {
                    count -= Math.min(grid[i][j], grid[i - 1][j]);
                }
                if (j < l - 1) {
                    count -= Math.min(grid[i][j], grid[i][j + 1]);
                }
                if (j > 0) {
                    count -= Math.min(grid[i][j], grid[i][j - 1]);
                }
            }
        }
        return count;
    }

    public int countTotle(int num) {

        if (num == 1) {
            return 6;
        }
        return 2 * 5 + 4 * (num - 2);
    }

}
