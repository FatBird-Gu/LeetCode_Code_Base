package easy;

public class MajorityElement {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.print(new MajorityElement().majorityElement(new int[]{1}));
    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p[] = partition(nums, 0, nums.length - 1);
        int mid = nums.length >> 1;
        while (p[0] > mid || p[1] < mid) {
            if (p[0] > mid) {
                p = partition(nums, 0, p[0] - 1);
            } else {
                p = partition(nums, p[1] + 1, nums.length - 1);
            }
        }
        return nums[p[0]];
    }

    public int[] partition(int[] nums, int start, int end) {
        int rand = start + (int) (Math.random() * (end - start + 1));
        swap(nums, rand, end);
        int less = start - 1;
        int more = end;
        int cur = start;
        while (cur < more) {
            if (nums[cur] > nums[end]) {
                swap(nums, cur, --more);
            } else if (nums[cur] < nums[end]) {
                swap(nums, cur++, ++less);
            } else {
                cur++;
            }
        }
        swap(nums, end, more);
        return new int[]{less + 1, more};
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
