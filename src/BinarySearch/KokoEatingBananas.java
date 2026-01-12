package BinarySearch;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1; // default speed can eat one per hour
        int maxSpeed = 0; // max speed == max item of the array;
        for (int banana : piles){
            maxSpeed = Math.max(banana,maxSpeed); // assign the max item of the array;
        }
        while (minSpeed < maxSpeed) { // running the binary search
            int mid = minSpeed + (maxSpeed-minSpeed)/2; // calculating mid position
            if(canEat(mid,piles,h)) maxSpeed = mid; // he can eat let's try with smaller.
            else minSpeed = mid + 1; // too slow update the pointer
        }
        return minSpeed; // as per question requested to get min speed
    }

    private boolean canEat(int speed, int[] piles, int time) {
        int timeTaken = 0;
        for (int banana : piles) {
            timeTaken += (int) Math.ceil((double) banana /speed); // updating the time values with ceil values
        }
        return timeTaken<=time; // if > return false if <=  returns true;
    }
}
