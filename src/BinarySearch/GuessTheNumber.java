package BinarySearch;

public class GuessTheNumber {
    private final int picked;
    public GuessTheNumber(int picked){
        this.picked = picked;
    }
    public int guessNumber(int n) {
        int max = n;
        int min = 0;
        while (min <= max){
            int mid = min + (max-min)/2;
            int res = guess(mid);

            switch (res){
                case 0 -> {
                    return mid;
                }
                case -1 -> max = mid-1;
                default -> min = mid+1;
            }
        }
        return -1;
    }

    private int guess(int num) {
        return Integer.compare(picked, num);
    }

}
