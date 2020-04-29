package mid;

public class SetZeroes {
	/*//  O(mn) �Ķ���ռ� (40%s)
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] = matrix[i][j];
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					setRow(res, i, n);
					setCol(res, j, m);
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = res[i][j];
			}
		}
    }
	public void setRow(int[][] matrix, int i, int n) {
		for (int k = 0; k < n; k++) {
			matrix[i][k] = 0;
		}
	}
	public void setCol(int[][] matrix, int j, int m) {
		for (int k = 0; k < m; k++) {
			matrix[k][j] = 0;
		}
	}*/
	
	/*// O(m + n) �Ķ���ռ� (99%)
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		boolean row[] = new boolean[m];
		boolean col[] = new boolean[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			if (row[i]) {
				setRow(matrix, i, n);
			}
		}
		for (int j = 0; j < n; j++) {
			if (col[j]) {
				setCol(matrix, j, m);
			}
		}
    }
	public void setRow(int[][] matrix, int i, int n) {
		for (int k = 0; k < n; k++) {
			matrix[i][k] = 0;
		}
	}
	public void setCol(int[][] matrix, int j, int m) {
		for (int k = 0; k < m; k++) {
			matrix[k][j] = 0;
		}
	}*/

    // �����ռ�Ľ������

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
