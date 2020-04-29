package mid;

public class CoinChange {
//	public int coinChange(int[] coins, int amount) {
//		if (coins == null || coins.length == 0) {
//			return -1;
//		}
//		
//		return process(coins, amount, 0, 0) ;
//    }
//	
//	
//	public int process(int [] coins, int amount, int sum, int count) {
//		if (sum > amount) {
//			return -1;
//		}
//		if (sum == amount) {
//			return count;
//		}
//		int min = Integer.MAX_VALUE;
//		for (int i = 0; i < coins.length; i++) {
//			int tmp = process(coins, amount, sum+coins[i], count+1);
//			if (tmp!=-1) {
//				min = Math.min(tmp, min);
//			} 
//		}
//		if (min == Integer.MAX_VALUE) {
//			return -1;
//		}
//		return min;
//	}

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(new int[]{1, 2, 5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE - amount;
        }
        for (int sum = 0; sum <= amount; sum++) {
            for (int coin = 0; coin < coins.length; coin++) {
                if (sum >= coins[coin]) {
                    dp[sum] = Math.min(dp[sum], dp[sum - coins[coin]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE - amount ? -1 : dp[amount];
    }

}
