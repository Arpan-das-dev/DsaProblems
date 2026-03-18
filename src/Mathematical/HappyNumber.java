package Mathematical;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        Set<Integer> integers = new HashSet<>();

        while (n != 1){
            if(integers.contains(n)) return false;

            integers.add(n);
            n = getNextInt(n);
        }
        return true;
    }

    private int getNextInt(int n) {
        int sum = 0;
        while (n > 0){
            int digit = n%10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}