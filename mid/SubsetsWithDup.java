package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    public static List<List<Integer>> ls;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SubsetsWithDup s = new SubsetsWithDup();
        ls = s.subsetsWithDup(new int[]{4, 4, 4, 1, 4});
        for (List<Integer> p : ls) {
            for (int t : p) {
                System.out.print(t + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        ls = new ArrayList<>();
        process(nums, 0, new ArrayList<>());
        return ls;
    }

    public void process(int[] nums, int index, List<Integer> part) {
        List<Integer> p = new ArrayList<>(part);
        if (index == nums.length) {
            if (!contain(ls, p)) {
                ls.add(p);
            }
            return;
        }
        process(nums, index + 1, p);
        p.add(nums[index]);
        process(nums, index + 1, p);
    }

    public boolean contain(List<List<Integer>> s, List<Integer> part) {
        for (List<Integer> t : s) {
            if (t.size() != part.size()) {
                continue;
            } else {
                boolean flag = true;
                for (int i = 0; i < t.size(); i++) {
                    if (part.get(i) != t.get(i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

}
