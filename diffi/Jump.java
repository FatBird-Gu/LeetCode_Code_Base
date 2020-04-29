package diffi;

public class Jump {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Jump j = new Jump();
        System.out.println(j.jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));
    }

    /*public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res[] = new int[nums.length];
        res[nums.length-1] = 0;
        for(int i = nums.length-2; i>=0; i--) {
            if (nums[i] == 0) {
                continue;
            }
            res[i] = Integer.MAX_VALUE-10000;
            if (nums[i] + i >= nums.length-1) {
                res[i] = 1;
                continue;
            }
            for(int j = 1; j<=nums[i];j++) {
                if(nums[i+j] == 0)
                    continue;
                res[i] = Math.min(res[i+j], res[i]);
            }
            res[i]++;
        }
        return res[0];
    }*/
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //����������Զ��
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) { //�����߽磬�͸��±߽磬���Ҳ�����һ
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}
