package BitManipulation;

public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int shift = 31; shift >= 0; shift--) {
            // shifting left from current position
            result += (n & 1) << shift;
            // shifting n's bits by one (on right)
            n = n >> 1;
        }
        return result;
    }

    public int reverseBitsBitSafeApproach(int n) {
        int result = 0;
        for (int shift = 31; shift >= 0; shift--) {
            result |= (n & 1) << shift;
            n = n >>> 1;
        }
        return result;
    }

}
