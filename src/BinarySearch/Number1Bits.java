package BinarySearch;

public class Number1Bits {
    public int hammingWeightBrute(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if((n & 1) == 1) count++;
            n =n>>1;
        }
        return count;
    }

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            n = n & (n-1);
            result ++;
        }
        return result;
    }
}
