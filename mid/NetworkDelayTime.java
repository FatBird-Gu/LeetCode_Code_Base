package mid;

public class NetworkDelayTime {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int networkDelayTime(int[][] times, int N, int K) {
        boolean visited[] = new boolean[N];
        K--;
        int[] d = new int[N];
        int minIndex = 0;
        for (int i = 0; i < N; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[K] = 0;
        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            minIndex = 0;
            for (int j = 1; j < N; j++) {
                if (min > d[j] && !visited[j]) {
                    min = d[j];
                    minIndex = j;
                }
            }
            if (min == Integer.MAX_VALUE) {
                return -1;
            }
            visited[minIndex] = true;
            for (int j = 0; j < times.length; j++) {
                if (times[j][0] == minIndex) {
                    d[times[j][1]] = d[times[j][1]] > (d[minIndex + times[j][2]])
                            ? (d[minIndex + times[j][2]]) : d[times[j][1]];
                }
            }
        }
        return d[minIndex];
    }

}
