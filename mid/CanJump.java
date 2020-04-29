package mid;

public class CanJump {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CanJump c = new CanJump();
        System.out.println(c.canJump(new int[]{3, 2, 1, 1, 0}));
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int end = 0;
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPos = Math.max(i + nums[i], maxPos);
            if (i == end) {
                end = maxPos;

            }
            if (i > end) {
                return false;
            }
        }
        return true;
    }

}
