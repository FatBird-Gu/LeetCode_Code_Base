package mid;

public class NextPermutation {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = new int[]{1, 1, 1};
        NextPermutation n = new NextPermutation();
        n.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int p;
        for (p = nums.length - 1; p >= 0; p--) {
            if (nums[p] > nums[i]) {
                break;
            }
        }
        swap(nums, i, p);
        reverse(nums, i + 1, nums.length - 1);
    }

    public void reverse(int arr[], int i, int j) {
        while (i <= j) {
            swap(arr, i++, j--);
        }
    }

    public void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
