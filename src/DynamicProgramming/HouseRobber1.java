package DynamicProgramming;

public class HouseRobber1 {
    public int maxMoneyStolen(int[] money) {
        if(money.length==0) return 0;
        if(money.length==1) return money[0];
        // assign zero values at the start
        int previous1 = 0;
        int previous2 = 0;
        for(int amount : money) { // starting loop
            // the amount Aurthur Moragan stolen from day 2 + today
            int pick = previous2+amount;
            // he needs to skip the last day's loot otherwise Pinkerton will be alerted
            int skip = previous1;
            // checking the current value to choose which is greater
            int current = Math.max(pick,skip);
            previous2 = previous1;
            previous1 = current;
        }
        return previous1;
    }
}
