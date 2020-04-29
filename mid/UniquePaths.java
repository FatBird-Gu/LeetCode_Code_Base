package mid;

public class UniquePaths {
//	public int uniquePaths(int m, int n) {
//        if (m<=0||n<=0) {
//			return 0;
//		}
//        return process(m, n, 1, 1);
//    }
//	public int process(int m, int n, int x, int y) {
//		if (m == x && n == y) {
//			return 1;
//		}
//		if (m == x) {
//			return process(m, n, x, y+1);
//		}else if (n == y) {
//			return process(m, n, x+1, y);
//		}else {
//			return process(m, n, x+1, y) + process(m, n, x, y+1);
//		}
//	}

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        UniquePaths u = new UniquePaths();
        System.out.println(u.uniquePaths(1, 1));
    }

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

}
