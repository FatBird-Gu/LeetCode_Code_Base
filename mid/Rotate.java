package mid;

public class Rotate {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Rotate r = new Rotate();
        int a[][] = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        r.rotate(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) {
            return;
        }
        int l = 0;
        int r = matrix[0].length - 1;
        while (l < r) {
            for (int i = 0; i < r - l; i++) {
                int tmp = matrix[l][l + i];
                matrix[l][l + i] = matrix[r - i][l];
                matrix[r - i][l] = matrix[r][r - i];
                matrix[r][r - i] = matrix[l + i][r];
                matrix[l + i][r] = tmp;
            }
            l++;
            r--;
        }
    }

}
