package mid;

public class MinSubArrayLen {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MinSubArrayLen m = new MinSubArrayLen();
        System.out.println(m.minSubArrayLen(2, new int[]{2}));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0 || s < 0) {
            return 0;
        }
        int len = Integer.MAX_VALUE;
        int L = 0;
        int R = 0;
        int sum = nums[0];
        while (R < nums.length) {
            if (sum >= s) {
                len = Math.min(len, R - L + 1);
                sum -= nums[L++];
            } else {
                R++;
                if (R == nums.length) {
                    break;
                }
                sum += nums[R];
            }
        }
        if (len == Integer.MAX_VALUE) {
            len = 0;
        }
        return len;
    }

}
