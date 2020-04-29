package mid;

public class Search2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Search2().search(new int[]{1}, 0));
	}

	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[mid] == nums[l]) {
				l++;
			} else if (nums[l] < nums[mid]) {
				if (nums[l] <= target && target < nums[mid]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			} else {
				if (nums[mid] < target && target <= nums[r]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
		}
		return false;
	}

}
