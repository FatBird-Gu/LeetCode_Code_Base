package easy;

import java.util.PriorityQueue;

public class GetLeastNumbers {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        if (k >= arr.length) {
            return arr;
        }
        if (k == 0) {
            return new int[]{};
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }
        int res[] = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }

}
