package mid;

public class WaysToChange {
    private int[] arr = new int[]{1, 5, 10, 25};

    public static void main(String[] args) {
        System.out.println(new WaysToChange().waysToChange(10));
    }

    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = arr[i]; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - arr[i]]) % 1000000007;
            }
        }
        return dp[n] % 1000000007;
    }

    public int dp(int cur, int sum) {
        if (sum == cur) return 1;
        if (sum < cur) return 0;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            count += dp(cur + arr[i], sum) % 1000000007;
        }
        return count % 1000000007;
    }
}
