package Mathematical;

public class MissingNumber {
    public int missingNumber (int [] nums) {
        // simple mathematical equation for sum of n numbers of natural numbers;
        // sum = (n*(n+1))/2;
        int n = nums.length;
        int sum = (n * (n+1)) /2;
        for(int value : nums) {
            sum -= value;
        }
        return sum;
    }
}
