package BitManipulation;

public class ConcatenationOfConsecutiveBinaryNumbers {
    public int concatenatedBinary(int n) {
        if(n <=1) return n;

        final int MOD = 1_000_000_007;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            int shift = 32 -Integer.numberOfLeadingZeros(i);
            result = ((result << shift) | i) % MOD;
        }
        return result;
    }
}
