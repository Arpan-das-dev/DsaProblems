package BitManipulation;

/**
 * this is not from {@code neetcode 150} sheet
 */
public class BinaryGap {
    public int binaryGap(int n) {
       n >>= Integer.numberOfTrailingZeros(n);
        if(n == 1) return 0;

       int gap = 0, max = 0;
       while (n > 0){
           if((n & 1) == 1) {
               max = Math.max(gap,max);
               gap = 0;
           }
           else gap++;
           n = n>>1;
       }
       return max+1;
    }
}
