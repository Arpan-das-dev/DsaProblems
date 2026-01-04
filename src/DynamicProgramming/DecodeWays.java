package DynamicProgramming;


public class DecodeWays {

    public int numDecoding(String s) {
        if (s == null || s.isEmpty()) return 0; // return zero for empty or null string;
        int length = s.length();

        int[] memoization = new int[length + 1]; // creating a new array with length of the string + 1
        memoization[0] = 1; // if the length of string = 0 then ways of decode = 1
        memoization[1] = s.charAt(0) == '0' ? 0 : 1; // check if it's zero
                                                    // then way of decode is 0 otherwise 1

        for (int i = 2; i <= length; i++) { // as we populated already
                                           //  so the value of first two index so i = 2
            int oneDigit = Integer.parseInt(s.substring(i - 1, i)); // getting exact the digit 11>x>0
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));  // getting two digit with
                                                                 // current index and previous index 26>x>10

            if (oneDigit >= 1) {
                memoization[i] += memoization[i - 1]; // if one digit is valid then increment i th position
                                                      // with the value of i-1
            }
            if (twoDigit >= 10 && twoDigit <= 26) {
                memoization[i] += memoization[i - 2]; // if two digit is valid then increment ith position
                                                      // with the value of i-2
            }
        }
        return memoization[length];
    }
}
