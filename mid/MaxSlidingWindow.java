package mid;

import java.util.LinkedList;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] res = new MaxSlidingWindow().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return null;
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        LinkedList<Integer> qmax = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!qmax.isEmpty() && nums[i] >= nums[qmax.peekLast()]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - k) {
                qmax.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[qmax.peekFirst()];
            }

        }
        return res;
    }

}
