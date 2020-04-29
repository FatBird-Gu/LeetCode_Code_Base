package mid;

public class MinIncrementForUnique {
    private final static int N = 40001;

    public static void main(String[] args) {


    }

    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0 || A.length == 1) {
            return 0;
        }
        int[] numCount = new int[N];
        for (int i = 0; i < A.length; i++) {
            numCount[A[i]]++;
        }
        int count = 0;
        for (int i = 1; i < numCount.length; i++) {
            if (A[i - 1] == 0) {
                continue;
            } else {
                numCount[i] = numCount[i - 1] - 1 + numCount[i];
                count += numCount[i - 1] - 1;
            }
        }
        count += numCount[N - 1] == 0 ? 0 : numCount[N - 1] - 1;
        return count;
    }
}
