package Hashing;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] num) {
        // finding length 1,2,3,4
        int n = num.length;
        // initializing an array for result;
        int[] result = new int[n];
        result[0] = 1; // initializing 0th index at default 1;
        for (int i = 1; i <n ; i++) {
            // get the left value from the result array
            int leftValue = result[i-1];
            // get the last value of the array (current) e.g. i = 2 then num[3-1] = 2 = 3(value)
            int currentLeft = num[i-1];
            result[i] = leftValue * currentLeft;
        }

        int rightProd = 1;
        for (int i = n-1; i >=0 ; i--) { // running a reverse loop
            result[i]*=rightProd; // first assign value otherwise it can cause Array Out of Bound Index Exception
            rightProd *= num[i]; // keep multiplying value of right results
        }
        return result;
    }
}
