package TwoPointers;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0, left = 0, right = people.length-1;
        while (left <= right) {
            int remain = limit - people[right--];
            res++;
            if(left <= right && remain >= people[left]) left++;
        }
        return res;
    }
}
