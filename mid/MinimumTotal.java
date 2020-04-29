package mid;

import java.util.List;

public class MinimumTotal {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        int len = triangle.size();
        int dp[] = new int[len];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(len - 1).get(i);
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int index = i; index >= 0; index--) {
                int tmp = triangle.get(i).get(index);
                dp[index] = Math.min(tmp + dp[index],
                        tmp + dp[index + 1]);
            }
        }
        return dp[0];
    }

}
