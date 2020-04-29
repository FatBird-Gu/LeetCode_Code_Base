package mid;


public class CanMeasureWater {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new CanMeasureWater().canMeasureWater(11, 3, 13));
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z)
            return false;
        if (x == 0 || y == 0)
            return z == 0 || x + y == z;
        return z % gcd(x, y) == 0;
    }

    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

}
