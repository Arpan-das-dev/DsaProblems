package Hashing;
/**
 * Utility class for computing an output array where each element is the product
 * of all elements in the input array except the element at that index.
 *
 * <p>This solves the classic "Product of Array Except Self" problem without using
 * division and in linear time, using prefix and suffix products.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>First pass builds prefix products from the left and stores them in the result array.</li>
 *   <li>Second pass traverses from the right, maintaining a running suffix product and
 *       multiplying it with the existing prefix value in the result.</li>
 *   <li>Each index thus stores: product of all elements to the left × product of all elements to the right.</li>
 * </ul>
 *
 * <p>This approach optimizes space by reusing the result array for prefix products and
 * a single variable for suffix products instead of extra arrays.[web:11][web:14]</p>
 *
 * <p><b>Time Complexity:</b> O(n), where n is the length of the input array.<br>
 * <b>Space Complexity:</b> O(1) extra space (excluding the output array).[web:14][web:22]</p>
 *
 * @author Arpan Das
 * @since 08/01/2026
 */
public class ProductExceptSelf {

    /**
     * Returns an array where each element is the product of all elements
     * in the input array except the element at that index.
     *
     * <p>Does not use division and handles the entire computation via
     * prefix and suffix products in two passes.[web:11][web:14]</p>
     *
     * @param num the input array of integers
     * @return an array of products where result[i] is the product of all elements except num[i]
     */
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
