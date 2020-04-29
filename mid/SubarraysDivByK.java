package mid;

public class SubarraysDivByK {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int subarraysDivByK(int[] A, int K) {
        int dp[] = new int[A.length + 1];
        int sum = 0;
        int countR[] = new int[K];
        countR[dp[0]]++;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            dp[i + 1] = sum % K;
            countR[(dp[i + 1] + K) % K]++;
        }
        long res = 0;
        for (int i = 0; i < countR.length; i++) {
            if (countR[i] == 0) {
                continue;
            }
            res += (countR[i] * (countR[i] - 1)) / 2;
        }
        return (int) res;
    }

}
