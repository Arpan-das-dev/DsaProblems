package Greedy;

import java.util.Arrays;

public class MeetingRooms2 {
    public int minMeetingRooms(int[] start, int[] end) {
        Arrays.sort(start);
        Arrays.sort(end);

        int st = 0, en = 0;
        int rooms = 0, maxRooms = 0;

        while (st<start.length) {
            // if start time is less than ending then new room required
            if(start[st] < end[en]) {
                rooms++;
                st++;
            }else {
                rooms --;
                en++;
            }
            maxRooms = Math.max(maxRooms,rooms);
        }
        return maxRooms;
    }
}
