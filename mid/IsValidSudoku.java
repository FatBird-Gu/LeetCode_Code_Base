package mid;

import java.util.HashMap;

public class IsValidSudoku {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new IsValidSudoku().isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}

        }));
    }

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i <= 26; i++) {
            map.put(i, new int[10]);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (board[i][j] > '9' || board[i][j] < '1') {
                    return false;
                }
                int index = i / 3 * 3 + j / 3;
                int num = board[i][j] - '0';
                if (map.get(index)[num] == 1) {
                    return false;
                } else {
                    map.get(index)[num] = 1;
                }
                index = 9 + i;
                if (map.get(index)[num] == 1) {
                    return false;
                } else {
                    map.get(index)[num] = 1;
                }
                index = 18 + j;
                if (map.get(index)[num] == 1) {
                    return false;
                } else {
                    map.get(index)[num] = 1;
                }
            }
        }
        return true;
    }

}
