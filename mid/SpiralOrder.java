package mid;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new SpiralOrder().spiralOrder(new int[][]{
                {1, 2, 5},
                {4, 3, 5},
//			{ 7 ,7,8},
//			{0,0,0}
        }));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int r = matrix.length - 1;
        int c = matrix[0].length - 1;
        int start = 0;
        int end = 0;
        while (start <= r && end <= c) {
            addValue(matrix, start, end, r, c, list);
            start++;
            end++;
            r--;
            c--;
        }
        return list;
    }

    public void addValue(int[][] matrix, int x1, int y1, int x2, int y2, List<Integer> list) {
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) {
                list.add(matrix[x1][i]);
            }
        } else if (y1 == y2) {
            for (int i = x1; i <= x2; i++) {
                list.add(matrix[i][y1]);
            }
        } else {
            for (int i = y1; i <= y2; i++) {
                list.add(matrix[x1][i]);
            }
            for (int i = x1 + 1; i <= x2; i++) {
                list.add(matrix[i][y2]);
            }
            for (int i = y2 - 1; i >= y1; i--) {
                list.add(matrix[x2][i]);
            }
            for (int i = x2 - 1; i > x1; i--) {
                list.add(matrix[i][y1]);
            }
        }
    }

}
