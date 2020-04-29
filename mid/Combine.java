package mid;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    private List<List<Integer>> res;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new Combine().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || k < 1) {
            return new ArrayList<List<Integer>>();
        }
        res = new ArrayList<>();
        process(0, k, n, new ArrayList<>());
        return res;
    }

    public void process(int start, int k, int n, List<Integer> part) {
        if (part.size() == k) {
            res.add(new ArrayList<>(part));
            return;
        }
        for (int i = start; i < n; i++) {
            part.add(i + 1);
            process(i + 1, k, n, part);
            part.remove(part.size() - 1);
        }
    }

}
