package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms1 {
    public boolean canAttend(int[][] arr) {
        if(arr == null ||arr.length == 1) return true;
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int prevEnd = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            int [] curr = arr[i];
            if(prevEnd > curr[0]) return false;
            else prevEnd = curr[1];
        }
        return true;
    }
}
