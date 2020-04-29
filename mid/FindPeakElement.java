package mid;

public class FindPeakElement {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FindPeakElement f = new FindPeakElement();
        System.out.println(f.findPeakElement(new int[]{-2147483648}));
    }

    public int findPeakElement(int[] nums) {
        if (nums == null) {
            return -1;
        }
        return process(nums, -1, nums.length);
    }

    public int process(int nums[], int l, int r) {
        if (r - l + 1 < 3) {
            return -1;
        }

        int mid = (l + r) / 2;
        long left, right;
        if (mid + 1 == nums.length) {
            right = Long.MIN_VALUE;
        } else {
            right = nums[mid + 1];
        }
        if (mid - 1 == -1) {
            left = Long.MIN_VALUE;
        } else {
            left = nums[mid - 1];
        }
        if ((nums[mid] > right && nums[mid] > left)) {
            return mid;
        }
        int tmp = process(nums, mid, r);
        return tmp == -1 ? process(nums, l, mid) : tmp;
    }

}
