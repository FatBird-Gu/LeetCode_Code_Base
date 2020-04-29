package mid;

public class SearchMatrix {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int x = 0;
        int y = c - 1;
        while (x >= 0 && x < r && y >= 0 && y < c) {
            if (target == matrix[x][y]) {
                return true;
            } else if (target < matrix[x][y]) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }

}
