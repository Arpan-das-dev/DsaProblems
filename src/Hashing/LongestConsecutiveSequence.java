package Hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int item : numbers) set.add(item);

        int maxStreak = 0; // default max streak
        for(int integer : set) { // loop run
            if(!set.contains(integer-1)) { // if 100 -9 is present means
                                           // it may be the start of the sequence
                int value = integer;
                int currentStreak = 1;  // default streak as 1;
                while (set.contains(value+1)) { // if 100 + 1 = 101 contains then run the loop
                    value ++; // increment to update values like 101>102>103
                    currentStreak ++; // and also increment current streak
                }
                maxStreak = Math.max(maxStreak,currentStreak); // putting only max value of the streak.
            }
        }
        return maxStreak;
    }
}
