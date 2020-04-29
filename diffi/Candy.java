package diffi;

public class Candy {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Candy c = new Candy();
		System.out.println(c.candy(new int[]{1, 1, 1, 1, 2}));
	}

	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		int pre;
		int sum = (ratings.length == 1 || ratings[0] <= ratings[1]) ? 1 : 2;
		pre = sum;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				sum += pre + 1;
				pre++;
			} else {
				if (pre == 1) {
					pre = 1;
				} else {
					pre--;
				}
				sum += pre;
			}
		}
		return sum;
	}

}
