package easy;

public class ClimbStairs {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ClimbStairs c = new ClimbStairs();
        System.out.println(c.climbStairs(3));
    }

    //	public int climbStairs(int n) {
//        if (n <= 0) {
//			return 0;
//		}
//        return process(n, 0);
//    }
//	public int process(int n, int now) {
//		if (now >= n) {
//			return now == n? 1:0;
//		}
//		return process(n, now+1)+process(n, now+2);
//	}
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        return dp[0];
    }

}
