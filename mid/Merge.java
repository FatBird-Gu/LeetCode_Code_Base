package mid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Merge {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        List<int[]> l = new LinkedList<int[]>();
        Arrays.sort(intervals, new MyCmp());
        int end = 0;
        int index = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (l.isEmpty()) {
                l.add(intervals[i]);
                index++;
                continue;
            }
            int[] tmp = l.get(index - 1);
            if (tmp[1] < intervals[i][0]) {
                l.add(intervals[i]);
                index++;
                continue;
            }
            if (tmp[1] >= intervals[i][1]) {
                continue;
            }
            if (intervals[i][0] <= tmp[1]) {
                l.remove(tmp);
                l.add(new int[]{tmp[0], intervals[i][1]});
                continue;
            }
        }
        if (end == intervals.length - 2) {

        }
        int[][] res = new int[l.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = l.get(i);
        }
        return res;
    }

    public class MyCmp implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            // TODO Auto-generated method stub
            return o1[0] - o2[0];
        }

    }

}
