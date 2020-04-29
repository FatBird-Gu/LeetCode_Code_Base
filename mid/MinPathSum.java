package mid;

public class MinPathSum {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    //	public int minPathSum(int[][] grid) {
//		if (grid == null) {
//			return 0;
//		}
//        return process(grid, 0, 0, 0);
//    }
//	public int process(int [][]grid, int x, int y,int path) {
//		if (x == grid.length-1 && y == grid[0].length-1) {
//			return path+grid[x][y];
//		}
//		if (x == grid.length-1) {
//			return process(grid, x, y+1, path+grid[x][y]);
//		}else if (y == grid[0].length-1) {
//			return process(grid, x+1, y, path+grid[x][y]);
//		}else {
//			return Math.min(process(grid, x+1, y, path+grid[x][y]), process(grid, x, y+1, path+grid[x][y]));
//		}
//	}
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        dp[row - 1][column - 1] = grid[row - 1][column - 1];
        for (int i = column - 2; i >= 0; i--) {
            dp[row - 1][i] = grid[row - 1][i] + dp[row - 1][i + 1];
        }
        for (int i = row - 2; i >= 0; i--) {
            dp[i][column - 1] = grid[i][column - 1] + dp[i + 1][column - 1];
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = column - 2; j >= 0; j--) {
                dp[i][j] = Math.min(grid[i][j] + dp[i + 1][j], grid[i][j] + dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

}
