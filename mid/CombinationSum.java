package mid;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> ls;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CombinationSum c = new CombinationSum();
        c.combinationSum(new int[]{2}, 7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        ls = new ArrayList<>();
        process(candidates, target, 0, 0, new ArrayList<>());
        return ls;
    }

    public void process(int[] candidates, int target, int index, int current, List<Integer> part) {
        if (target == current) {
            ls.add(part);
            return;
        }
        if (index == candidates.length) {
            return;
        }
        for (int num = 0; num * candidates[index] + current <= target; num++) {
            List<Integer> pp = new ArrayList<>(part);
            for (int i = 0; i < num; i++) {
                pp.add(candidates[index]);
            }
            process(candidates, target, index + 1, num * candidates[index] + current, pp);
        }
    }

}
