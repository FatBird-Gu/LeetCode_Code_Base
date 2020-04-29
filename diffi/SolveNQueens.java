package diffi;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {
    List<List<String>> ls = new ArrayList<List<String>>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SolveNQueens s = new SolveNQueens();
        List<List<String>> ls = s.solveNQueens(4);
        for (List<String> p : ls) {
            for (String str : p) {
                System.out.println(str);
            }
            System.out.println("-------------------");
        }
    }

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return ls;
        }
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        permutation(arr, arr.length - 1);
        return ls;
    }

    public void permutation(int nums[], int rest) {
        if (rest == 0) {
            if (istrue(nums)) {
                ls.add(genMap(nums));
            }
            return;
        }
        for (int i = 0; i <= rest; i++) {
            swap(nums, i, rest);
            permutation(nums, rest - 1);
            swap(nums, rest, i);
        }
    }

    public List<String> genMap(int nums[]) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < nums.length; j++) {
                sb.append(nums[i] == j ? 'Q' : '.');
            }
            res.add(sb.toString());
        }
        return res;
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
