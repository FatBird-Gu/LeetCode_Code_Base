package easy;

public class Rotate {
    public static void main(String[] args) {
        new Rotate().rotate(new int[]{0, 1, 2, 3, 4, 5, 6}, 5);
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int len = nums.length;
        k = k % len;
        if (k == 0) {
            return;
        }

        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int nums[], int l, int r) {
        if (l > r) {
            return;
        }
        for (int i = l; i <= (l + r) >> 1; i++) {
            swap(nums, i, r - (i - l));
        }
    }

    public void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
