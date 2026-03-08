package Mathematical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlusOne {
    public int[] plusOneNonOptimal(int[] digits) {
        if(digits == null || digits.length == 0) return digits;
        List<Integer> store = new ArrayList<>();

        int carry = 1;
        int index = digits.length-1;

        for (int i = digits.length-1; i >= 0 ; i--) {
            int sum = carry+digits[i];
            store.add(sum%10);
            carry = sum/10;
        }
        if(carry != 0) store.add(carry);

        Collections.reverse(store);
        int size = store.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = store.get(i);
        }

        return result;
    }

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
