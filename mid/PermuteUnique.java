package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        process(nums, ls, new boolean[nums.length], new ArrayList<>(), nums.length);
        return ls;
    }

    public void process(int[] nums, List<List<Integer>> ls, boolean[] rest, List<Integer> p, int depth) {
        if (depth == 0) {
            ls.add(p);
        }
        for (int i = 0; i < nums.length; i++) {
            if (rest[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !rest[i - 1]) {
                continue;
            }
            List<Integer> tmp = new ArrayList<>(p);
            tmp.add(nums[i]);
            rest[i] = true;
            process(nums, ls, rest, tmp, depth - 1);
            rest[i] = false;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
