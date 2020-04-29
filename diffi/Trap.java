package diffi;

public class Trap {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] tmp = new int[height.length];
        int max = height[0];
        for (int i = 0; i < tmp.length; i++) {
            max = Math.max(max, height[i]);
            tmp[i] = max;
        }
        max = height[tmp.length - 1];
        int count = 0;
        for (int i = tmp.length - 1; i >= 0; i--) {
            max = Math.max(height[i], max);
            count += Math.min(max, tmp[i]) - height[i];
        }
        return count;
    }

}
