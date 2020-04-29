package easy;

public class MaxSubArray {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MaxSubArray m = new MaxSubArray();
        System.out.println(m.maxSubArray(new int[]{-2}));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp[i] = sum;
            max = Math.max(sum, max);
            for (int j = 0; j < i; j++) {
                max = Math.max(max, sum - dp[j]);
            }
        }
        return max;
    }

}
