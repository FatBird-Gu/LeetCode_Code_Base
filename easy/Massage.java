package easy;

public class Massage {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new Massage().massage(new int[]{2}));
    }

    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < dp.length; i++) {
            if (i == 1) {
                dp[i] = Math.max(nums[1], dp[i - 1]);
            } else {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        }
        return dp[len - 1];
    }

}
