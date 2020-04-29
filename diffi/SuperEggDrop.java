package diffi;

public class SuperEggDrop {
    private static int[][] dp;

    /*public int superEggDrop(int K, int N) {
        this.dp = new int[K+1][N+1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = -1;
            }
        }
        return process(K, N);
    }*/
	/*
	 * ��ʱ
	 * public int process(int K, int N) {
		if (K == 1) {
			return N;
		}
		if (N == 0) {
			return 0;
		}
		if (dp[K][N] != -1) {
			return dp[K][N];
		}
		int res = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			res = Math.min(res,
					Math.max(process(K, N-i)+1, process(K-1, i-1) + 1)
					);
		}
		dp[K][N] = res;
		return res;
	}*/
	/*
	 * dp + ���ּ�֦
	 * public int process(int K, int N) {
		if (K == 1) {
			return N;
		}
		if (N == 0) {
			return 0;
		}
		if (dp[K][N] != -1) {
			return dp[K][N];
		}
		int l = 1;
		int r = N;
		int res = Integer.MAX_VALUE;
		while(l<=r) {
			int mid = (l+r)/2;
			int not_broken = process(K, N-mid)+1;
			int broken = process(K-1, mid-1)+1;
			if (not_broken > broken) {
				l = mid + 1;
				res = Math.min(res, not_broken);
			}
			if (not_broken == broken) {
				l = mid+1;
				res = Math.min(res, broken);
			}
			if (not_broken < broken) {
				r = mid-1;
				res = Math.min(res, broken);
			}
		}
		dp[K][N] = res;
		return res;
	}*/
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new SuperEggDrop().superEggDrop(3, 25));
    }

    public int superEggDrop(int K, int N) {
        int[] dp = new int[K + 1];
        int ans = 0;
        while (dp[K] < N) {
            for (int i = K; i > 0; i--) {
                dp[i] = dp[i] + dp[i - 1] + 1;
            }
            ans++;
        }
        return ans;
    }

}
