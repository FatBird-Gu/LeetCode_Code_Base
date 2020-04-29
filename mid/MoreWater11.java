package mid;

public class MoreWater11 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution s = new Solution();
        System.out.println(s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static class Solution {
        public int maxArea(int[] height) {
            if (height == null) {
                return 0;
            }
            int max = 0;
            for (int i = 0, j = height.length - 1; i < j; ) {
                int minH = height[i] < height[j] ? height[i++] : height[j--];
                max = Math.max(max, (j - i + 1) * minH);
            }
            return max;
        }
    }

}
