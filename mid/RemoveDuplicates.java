package mid;

public class RemoveDuplicates {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{1, 3, 4}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 1;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                count += 1;
            else
                count = 1;
            if (count <= 2) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

}
