package mid;

public class SortColors {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int target = 1;
        int l = -1;
        int r = nums.length;
        int cur = 0;
        while (cur < r) {
            if (nums[cur] > target) {
                swap(nums, cur, --r);
            } else if (nums[cur] < target) {
                swap(nums, cur++, ++l);
            } else {
                cur++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
