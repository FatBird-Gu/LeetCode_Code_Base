package mid;

public class SearchRange {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] res = new int[2];
        SearchRange s = new SearchRange();
        res = s.searchRange(new int[]{0, 0, 2}, 0);
        System.out.println(res[0] + " " + res[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }
        int l;
        int r;
        int L = 0;
        int R = nums.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            l = mid;
            r = mid;
            if (nums[mid] == target) {
                while (l - 1 >= 0 && nums[l - 1] == nums[l]) {
                    l--;
                }
                while (r + 1 < nums.length && nums[r + 1] == nums[r]) {
                    r++;
                }
                return new int[]{l, r};
            } else if (nums[mid] > target) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
