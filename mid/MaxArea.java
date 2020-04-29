package mid;


public class MaxArea {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        for (; l < r; ) {
            int minH = height[l] < height[r] ? height[l++] : height[r--];
            max = max > (r - l + 1) * minH ? max : (r - l) * minH;
        }
        return max;
    }

}
