package mid;

public class GenerateMatrix {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int[][] generateMatrix(int n) {
        if (n < 1) {
            return new int[][]{};
        }
        int[][] matrix = new int[n][n];
        int index = 1;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            for (int i = l; i <= r; i++) {
                matrix[l][i] = index++;
            }
            for (int i = l + 1; i <= r; i++) {
                matrix[i][r] = index++;
            }
            for (int i = r - 1; i >= l; i--) {
                matrix[r][i] = index++;
            }
            for (int i = r - 1; i > l; i--) {
                matrix[i][l] = index++;
            }
            r--;
            l++;
        }
        if ((n & 1) == 1) {
            matrix[l][l] = index;
        }
        return matrix;
    }

}
