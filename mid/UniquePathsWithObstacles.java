package mid;

public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        UniquePathsWithObstacles u = new UniquePathsWithObstacles();
        System.out.println(u.uniquePathsWithObstacles(new int[][]{{0}, {1}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int dp[][] = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] == 1) {
                break;
            } else {
                dp[i][n - 1] = 1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] == 1) {
                break;
            } else {
                dp[m - 1][i] = 1;
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}
