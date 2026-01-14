package DynamicProgramming;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null || s.isEmpty() || s.length() == 1) return s;

        int start = 0 , maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            // odd length
            int oddLength = expandStringIfPalindrome(s,i,i);
            // even length
            int evenLength = expandStringIfPalindrome(s,i,i+1);

            int current = Math.max(oddLength,evenLength);
            if(current > maxLength) {
                maxLength = current;
                start = i - (current-1)/2;
            }
        }
        return s.substring(start,maxLength+start);
    }
    private int expandStringIfPalindrome(String s, int start, int maxLength) {
        while (start>=0 && maxLength < s.length() && s.charAt(start) == s.charAt(maxLength)) {
            start --;
            maxLength++;
        }
        return maxLength-start-1;
    }
}
