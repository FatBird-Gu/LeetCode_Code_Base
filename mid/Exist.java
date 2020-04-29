package mid;

public class Exist {
    private final int[][] dist = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
    };
    private int r = 0;
    private int c = 0;
    private boolean[][] visited;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean exist(char[][] board, String word) {
        char[] chs = word.toCharArray();
        r = board.length;
        c = board[0].length;
        visited = new boolean[r][c];
        boolean flag = false;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!flag && board[i][j] == chs[0]) {
                    visited[i][j] = true;
                    flag = process(board, chs, 1, i, j);
                    visited[i][j] = false;
                }
            }
        }
        return flag;
    }

    public boolean process(char[][] board, char[] word, int index, int x, int y) {
        if (index == word.length) {
            return true;
        }
        for (int i = 0; i < dist.length; i++) {
            int x1 = x + dist[i][0];
            int y1 = y + dist[i][1];
            if (x1 >= 0 && x1 < r && y1 >= 0 && y1 < c && !visited[x1][y1] && word[index] == board[x1][y1]) {
                visited[x1][y1] = true;
                if (process(board, word, index + 1, x1, y1)) {
                    return true;
                }
                visited[x1][y1] = false;
            }
        }
        return false;
    }

}
