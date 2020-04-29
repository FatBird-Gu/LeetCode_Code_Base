package easy;

public class CanThreePartsEqualSum {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CanThreePartsEqualSum c = new CanThreePartsEqualSum();
        System.out.println(c.canThreePartsEqualSum(new int[]{10, -10, 10, -10, 10, -10, 10, -10}));
    }

    public boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }

        int count = 0;
        int aim = sum / 3;
        sum = A[0];
        for (int i = 1; i < A.length; i++) {
            if (sum == aim) {
                count++;
                sum = 0;
            }
            sum += A[i];
        }
        if (sum == aim) {
            count++;
        }
        System.out.println(count);
        if (aim == 0 && count >= 3) {
            return true;
        }
        if (count < 3 || count > 3) {
            return false;
        }
        return true;
    }

}
