package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static List<List<Integer>> ls;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(candidates);
        ls = new ArrayList<>();
        process(candidates, target, 0, 0, new ArrayList<>());
        return ls;
    }

    public void process(int[] candidates, int target, int index, int current, List<Integer> part) {
        if (target == current) {
            boolean flag = true;
            for (List<Integer> li : ls) {
                if (li.equals(part)) {
                    flag = false;
                }
            }
            if (flag) {
                ls.add(part);
            }
            return;
        }
        if (index == candidates.length) {
            return;
        }
        for (int num = 0; num * candidates[index] + current <= target && num <= 1; num++) {
            List<Integer> pp = new ArrayList<>(part);
            for (int i = 0; i < num; i++) {
                pp.add(candidates[index]);
            }
            process(candidates, target, index + 1, num * candidates[index] + current, pp);
        }
    }

}
