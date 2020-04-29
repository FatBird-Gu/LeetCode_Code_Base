package mid;

import java.util.LinkedList;
import java.util.Queue;

public class Solve {
    private int[][] dis = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public static void main(String[] args) {
        new Solve().solve(new char[][]{
                {'X', 'X', 'X', 'X'}
                , {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        });
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int r = board.length, c = board[0].length;
        if (r <= 2 || c <= 2) {
            return;
        }
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                bfs(board, visited, i, 0);
            }
            if (board[i][c - 1] == 'O' && !visited[i][c - 1]) {
                bfs(board, visited, i, c - 1);
            }
        }
        for (int i = 1; i < c - 1; i++) {
            if (board[0][i] == 'O' && !visited[0][i]) {
                bfs(board, visited, 0, i);
            }
            if (board[r - 1][i] == 'O' && !visited[r - 1][i]) {
                bfs(board, visited, r - 1, i);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }

    public void bfs(char[][] board, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] start = queue.poll();
            for (int i = 0; i < 4; i++) {
                x = start[0] + dis[i][0];
                y = start[1] + dis[i][1];
                if (!(x >= 0 && x < board.length && y >= 0 && y < board[0].length)) {
                    continue;
                }
                if (!visited[x][y] && board[x][y] == 'O') {
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }
}
