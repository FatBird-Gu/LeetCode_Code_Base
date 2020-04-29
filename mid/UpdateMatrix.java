package mid;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix {
    private int[][] dist = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int[][] updateMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] in = queue.poll();
            int x = in[0], y = in[1];
            for (int i = 0; i < 4; i++) {
                int x1 = x + dist[i][0];
                int y1 = y + dist[i][1];
                if (x1 < 0 || x1 >= r || y1 < 0 || y1 >= c || visited[x1][y1]) {
                    continue;
                }
                matrix[x1][y1] = in[2] + 1;
                queue.add(new int[]{x1, y1, in[2] + 1});
                visited[x1][y1] = true;
            }
        }
        return matrix;
    }

}
