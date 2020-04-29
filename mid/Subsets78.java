package mid;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public List<List<Integer>> ls;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        ls = new ArrayList<>();
        process(nums, 0, new ArrayList<>());
        return ls;
    }

    public void process(int[] nums, int index, List<Integer> part) {
        List<Integer> p = new ArrayList<>(part);
        if (index == nums.length) {
            ls.add(p);
            return;
        }
        process(nums, index + 1, p);
        p.add(nums[index]);
        process(nums, index + 1, p);
    }

}
