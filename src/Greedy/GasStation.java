package Greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSpent = 0;
        int totalFuelHas = 0;
        int startPoint = 0;

        for (int i = 0; i < gas.length; i++) {
            totalSpent += gas[i] - cost[i];
            totalFuelHas += gas[i] - cost[i];

            // if the tank has negative fuel it can't start from here
            if(totalFuelHas < 0) {
                // reset the start point and amount of fuel it has
                totalFuelHas = 0;
                startPoint = i+1;
            }
        }
        return totalSpent >= 0 ? startPoint : -1;
    }

}
