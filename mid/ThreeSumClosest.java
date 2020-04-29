package mid;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ThreeSumClosest t = new ThreeSumClosest();
        System.out.println(t.threeSumClosest(new int[]{-1, 2, 1, -4, 1, -4, 6, 7, 1, 5, 2, 10}, -1));
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int tmp = nums[i] + nums[L] + nums[R];
                int sub = tmp - target;
                if (sub == 0) {
                    L++;
                } else if (sub < 0) {
                    L++;
                } else {
                    R--;
                }
                if (Math.abs(target - min) > Math.abs(sub)) {
                    min = tmp;
                }
            }
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return min;
    }

}
