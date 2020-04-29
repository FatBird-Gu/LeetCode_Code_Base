package diffi;

public class FirstMissingPositive {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{
                1, 2, 0
        }));
    }

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // ������ָ����Χ�ڡ�����û�з�����ȷ��λ���ϣ��Ž���
                // ���磺��ֵ 3 Ӧ�÷������� 2 ��λ����
                swap(nums, nums[i] - 1, i);
            }
        }

        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // ����ȷ�򷵻����鳤�� + 1
        return len + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
