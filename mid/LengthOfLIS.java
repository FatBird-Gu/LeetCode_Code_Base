package mid;

public class LengthOfLIS {
    // O(N^2)
	/*public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int dp[] = new int[nums.length];
		dp[nums.length-1] = 1;
		int max = 1;
		for(int i = nums.length-2; i>=0; i--) {
			dp[i] = 1;
			for(int j = i+1; j<nums.length;j++) {
				if (nums[i]<nums[j]) {
					dp[i] = Math.max(dp[i],dp[j]+1);
					
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			max = Math.max(dp[i], max);
		}
		return max;
    }*/

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18, 19, 20}));
    }

    // O(nlogn)
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if (res == j) res++;
        }
        return res;
    }

}
