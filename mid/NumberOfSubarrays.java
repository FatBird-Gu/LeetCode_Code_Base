package mid;

import java.util.ArrayList;
import java.util.List;

public class NumberOfSubarrays {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new NumberOfSubarrays().numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int preEven = 0;
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if ((i & 1) == 0) {
                preEven++;
            } else {
                list.add(preEven + 1);
                preEven = 0;
            }
        }
        list.add(preEven + 1);
        // list.forEach(o-> System.out.println(o));
        int count = 0;
        for (int i = 0; i < list.size() - k; i++) {
            count += (list.get(i) * list.get(i + k));
        }
        return count;
    }

}
