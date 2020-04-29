package easy;

public class DistributeCandies {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DistributeCandies d = new DistributeCandies();
        int[] t = d.distributeCandies(0, 4);
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i]);
        }
    }

    public int[] distributeCandies(int candies, int num_people) {
        if (candies <= 0 || num_people <= 0) {
            return new int[num_people];
        }
        int[] ans = new int[num_people];
        int k = 1;
        while (findK(k, num_people, candies)) {
            k++;
        }
        // 1~k-1
        if (k - 1 > 0) {
            for (int i = 0; i < num_people; i++) {
                ans[i] = (i + 1 + (k - 2) * num_people + i + 1) * (k - 1) / 2;
                candies -= ans[i];
            }
        }
        for (int i = 0; i < num_people; i++) {
            int tmp = (k - 1) * num_people + i + 1;
            if (candies <= tmp) {
                ans[i] += candies;
                break;
            }
            ans[i] += tmp;
            candies -= tmp;

        }
        return ans;
    }

    public boolean findK(int k, int n, int total) {
        return (1 + k * n) * k * n <= 2 * total;
    }
}
