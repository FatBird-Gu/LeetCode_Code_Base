package mid;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxDistance {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new MaxDistance().maxDistance(new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        }));
    }

    /*private int[][] dis= new int[][] {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int r = grid.length;
        int c = grid[0].length;
        int max = -1;
        for(int i = 0;i<r;i++) {
            for(int j = 0; j<c;j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                max = Math.max(max, bfs(grid, i, j, r, c));
                if (max == -1) {
                    return -1;
                }
            }
        }
        return max;
    }
    public int bfs(int[][]grid, int x, int y, int r, int c) {
        boolean[] visited = new boolean[r*c];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] {x,y,0});
        visited[x*c+y] = true;
        while(!queue.isEmpty()) {
            int[] index = queue.poll();
            visited[index[0]*r+index[1]] = true;;
            for (int i = 0; i < 4; i++) {
                int[] tmp = new int[3];
                tmp[0] = index[0] +dis[i][0];
                tmp[1] = index[1] + dis[i][1];
                tmp[2] = index[2] + 1;
                if (tmp[0]>=0 && tmp[0]<r && tmp[1] >=0 && tmp[1]<c
                        && !visited[tmp[0]*c + tmp[1]]) {
                    if (grid[tmp[0]][tmp[1]] == 1) {
                        return tmp[2];
                    }
                    queue.add(tmp);
                }
            }

        }
        return -1;
    }*/
    public int maxDistance(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        // �Ȱ����е�½�ض���ӡ�
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // �Ӹ���½�ؿ�ʼ��һȦһȦ�ı����������������ĺ��������½����Զ�ĺ���
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];
            // ȡ�����е�Ԫ�أ��������ܵĺ�����ӡ�
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                    continue;
                }
                grid[newX][newY] = grid[x][y] + 1; // ������ֱ���޸���ԭ���飬��˾Ͳ���Ҫ�������������־�Ƿ����
                hasOcean = true;
                queue.offer(new int[]{newX, newY});
            }
        }

        // û��½�ػ���û�к��󣬷���-1��
        if (point == null || !hasOcean) {
            return -1;
        }

        // �������һ�α������ĺ���ľ��롣
        return grid[point[0]][point[1]] - 1;

    }

}
