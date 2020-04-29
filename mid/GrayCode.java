package mid;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    private int[] add = new int[]{0, 1, 3, 2};

    public static void main(String[] args) {
        System.out.println(new GrayCode().grayCode(3));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }
}
