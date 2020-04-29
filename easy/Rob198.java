package easy;

public class Rob198 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Rob198 rob = new Rob198();
        System.out.println(rob.rob1(new int[]{1, 3, 1}));
        System.out.println(rob.rob(new int[]{1, 3, 1}));
    }

    public int rob1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        return process(nums, 0);
    }

    public int process(int[] nums, int index) {
        if (index >= nums.length)
            return 0;
        if (index == nums.length - 1) {
            return nums[index];
        }
        if (index == nums.length - 2) {
            return Math.max(nums[index + 1], nums[index]);
        }
        return Math.max(nums[index] + process(nums, index + 2), process(nums, index + 1));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (1 == nums.length) {
            return nums[0];
        }
        if (2 == nums.length) {
            return Math.max(nums[0], nums[1]);
        }
        int dp[] = new int[nums.length];
        dp[nums.length - 1] = nums[nums.length - 1];
        dp[nums.length - 2] = Math.max(nums[nums.length - 2], nums[nums.length - 1]);
        for (int i = nums.length - 1 - 2; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }
}
