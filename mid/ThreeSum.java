package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ThreeSum t = new ThreeSum();
        t.threeSum(new int[]{-1, 0, 1, 2, -1, -4});

    }

    //	public List<List<Integer>> threeSum(int[] nums) {
//	if (nums == null || nums.length == 0 || nums.length<=2) {
//		return new ArrayList<List<Integer>>();
//	}
//		List<List<Integer>> ls = new ArrayList<>();
//        Arrays.sort(nums);
//        if (nums[0] > 0) {
//			return new ArrayList<List<Integer>>();
//		}
//        int L = 0;
//        while( L < nums.length && nums[L] <= 0 ) {
//        	for(int R = nums.length-1; nums[R]>= 0 && R-1 > L; R--) {
//        		for (int i = L+1; i < R; i++) {
//					if (nums[L] + nums[i] + nums[R] == 0) {
//						List<Integer> l = new ArrayList<>();
//						l.add(nums[L]);l.add(nums[i]);l.add(nums[R]);
//						if (!ls.contains(l)) {
//							ls.add(l);
//						}
//					}
//				}
//        	}
//        	L++;
//        }
//        return ls;
//    }
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length <= 2) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return new ArrayList<List<Integer>>();
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return ls;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                if (nums[i] + nums[L] + nums[R] == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[L]);
                    l.add(nums[i]);
                    l.add(nums[R]);
                    ls.add(l);
                    while (R > L && nums[R--] == nums[R]) {
                    }
                    while (L < R && nums[L++] == nums[L]) {
                    }
                } else if (nums[i] + nums[L] + nums[R] > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return ls;
    }

}
