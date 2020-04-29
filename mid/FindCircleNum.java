package mid;

import java.util.HashSet;

public class FindCircleNum {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        if (M.length == 1) {
            return 1;
        }
        int N = M.length;
        int p[] = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (M[i][j] == 1) {
                    int x = find(i, p);
                    int y = find(j, p);
                    if (x != y) {
                        p[x] = y;
                    }
                }
            }
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < N; i++) {
            hs.add(find(i, p));
        }
        return hs.size();
    }

    public int find(int x, int[] p) {
        if (x == p[x]) {
            return x;
        }
        return find(p[x], p);
    }

}
