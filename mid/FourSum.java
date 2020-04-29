package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FourSum f = new FourSum();
        f.fourSum(new int[]{0, 0, 0, 0}, 0);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 4; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j <= nums.length - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int L = j + 1, R = nums.length - 1;
                while (L < R) {
                    if (nums[i] + nums[j] + nums[L] + nums[R] == target) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[L]);
                        l.add(nums[R]);
                        res.add(l);
                        while (R > L && nums[R--] == nums[R]) {
                        }
                        while (L < R && nums[L++] == nums[L]) {
                        }
                    } else if (nums[j] + nums[i] + nums[L] + nums[R] > target) {
                        R--;
                    } else {
                        L++;
                    }
                }
            }
        }
        return res;
    }

}
