package easy;

public class NumRookCaptures {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int numRookCaptures(char[][] board) {
        if (board == null || board[0].length == 0) {
            return 0;
        }
        int index[] = findR(board);
        if (index.length != 2) {
            return 0;
        }
        return searchInDir(board, index[0], index[1], 1, 0) + searchInDir(board, index[0], index[1], -1, 0)
                + searchInDir(board, index[0], index[1], 0, -1) + searchInDir(board, index[0], index[1], 0, 1);
    }

    public int searchInDir(char[][] board, int x, int y, int dx, int dy) {
        x += dx;
        y += dy;
        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            if (board[x][y] == 'B' || board[x][y] == 'R') {
                return 0;
            }
            if (board[x][y] == 'p') {
                return 1;
            }
            x += dx;
            y += dy;
        }
        return 0;
    }

    public int[] findR(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

}
