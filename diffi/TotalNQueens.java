package diffi;


public class TotalNQueens {
    int count = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int totalNQueens(int n) {
        if (n < 1) {
            return count;
        }
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        permutation(arr, arr.length - 1);
        return count;
    }

    public void permutation(int nums[], int rest) {
        if (rest == 0) {
            if (istrue(nums)) {
                count++;
            }
            return;
        }
        for (int i = 0; i <= rest; i++) {
            swap(nums, i, rest);
            permutation(nums, rest - 1);
            swap(nums, rest, i);
        }
    }

    public boolean istrue(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j - i == nums[j] - nums[i] || i - j == nums[j] - nums[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
