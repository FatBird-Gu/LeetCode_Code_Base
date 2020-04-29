package mid;

public class CanCompleteCircuit {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currTank = 0;
        int totleTank = 0;
        int startStation = 0;
        for (int i = 0; i < cost.length; i++) {
            totleTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];
            if (currTank < 0) {
                currTank = 0;
                startStation = i + 1;
            }
        }
        return totleTank >= 0 ? startStation : -1;
    }

}
