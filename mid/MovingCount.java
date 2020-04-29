package mid;

public class MovingCount {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new MovingCount().movingCount(2, 3, 1));
    }

    public int movingCount(int m, int n, int k) {
        if (m < 0 || n < 0 || k < 0) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        return process(m, n, k, 0, 0, visited);
    }

    public int process(int m, int n, int k, int x, int y, boolean[][] visited) {
        if (x >= m || x < 0 || y < 0 || y >= n) {
            return 0;
        }
        int count = 0;
        if (!visited[x][y] && check(x, y, k)) {
            visited[x][y] = true;
            count = process(m, n, k, x + 1, y, visited)
                    + process(m, n, k, x - 1, y, visited)
                    + process(m, n, k, x, y - 1, visited)
                    + process(m, n, k, x, y + 1, visited) + 1;
        }
        return count;
    }

    public boolean check(int x, int y, int k) {
        int totle = 0;
        while (x != 0) {
            totle += x % 10;
            x /= 10;
        }
        while (y != 0) {
            totle += y % 10;
            y /= 10;
        }
        return totle <= k;
    }

}
