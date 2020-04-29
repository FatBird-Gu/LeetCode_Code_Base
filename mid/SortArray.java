package mid;

public class SortArray {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new SortArray().sortArray(new int[]{5, 2, 3, 1});
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int L, int R) {
        if (L < R) {
            int[] p = partition(nums, L, R);
            quickSort(nums, L, p[0] - 1);
            quickSort(nums, p[1] + 1, R);
        }
    }

    public int[] partition(int[] nums, int L, int R) {
        int cur = L;
        int less = L - 1;
        int more = R;
        while (cur < more) {
            if (nums[cur] < nums[R]) {
                swap(nums, cur++, ++less);
            } else if (nums[cur] > nums[R]) {
                swap(nums, cur, --more);
            } else {
                cur++;
            }
        }
        swap(nums, more, R);
        return new int[]{less + 1, more};
    }

    public void swap(int[] nums, int L, int R) {
        int tmp = nums[L];
        nums[L] = nums[R];
        nums[R] = tmp;
    }

}
