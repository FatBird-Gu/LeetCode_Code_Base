package easy;

public class MaxProfit121 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MaxProfit121 m = new MaxProfit121();
        System.out.println(m.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int max = 0;
        int dp[] = new int[prices.length];
        dp[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], prices[i]);
            max = Math.max(max, -prices[i] + dp[i + 1]);
        }
        return max;
    }

}
