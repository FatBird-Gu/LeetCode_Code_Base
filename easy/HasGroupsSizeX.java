package easy;

public class HasGroupsSizeX {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new HasGroupsSizeX().hasGroupsSizeX(new int[]{
                1, 1, 1, 1, 2, 2, 2, 2, 2, 2
        }));
    }

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length < 2) {
            return false;
        }
        int[] numC = new int[15000];
        int len = 0;
        for (int i = 0; i < deck.length; i++) {
            numC[deck[i]]++;
            len = Math.max(len, deck[i]);
        }
        int min = 15000;
        for (int i = 0; i <= len; i++) {
            if (numC[i] == 0) {
                continue;
            }
            min = Math.min(min, numC[i]);
        }
        if (min == 1) {
            return false;
        }
        for (int i = 2; i <= min; i++) {
            boolean flag = true;
            for (int j = 1; j <= len; j++) {
                if (numC[j] % i != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

}
