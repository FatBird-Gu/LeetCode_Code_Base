package mid;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Permute p = new Permute();
        List<List<Integer>> ls = p.permute(new int[]{0, 1, 2, 3, 4, 5});
        for (List<Integer> tmp : ls) {
            for (int t : tmp) {
                System.out.print(t + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ls = new ArrayList<>();
        process(nums, ls, new ArrayList<>(), nums.length);
        return ls;
    }

    public void process(int[] nums, List<List<Integer>> ls, List<Integer> p, int rest) {
        if (rest == 0) {
            ls.add(p);
            return;
        }
        for (int i = 0; i < rest; i++) {
            p.add(nums[i]);
            swap(nums, i, rest - 1);
            process(nums, ls, new ArrayList<>(p), rest - 1);
            swap(nums, rest - 1, i);
            p.remove(nums.length - rest);
        }
    }

    public void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
