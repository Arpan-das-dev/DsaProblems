package SlidingWindow;

public class LongestRepeatingCharReplacement {
    public int characterReplacement(String s, int k) {
       int left = 0;
       int maxFreq = 0;
       int maxLength = 0;
       int [] charCount = new int[26];

       for (int right = 0; right<s.length(); right++) {
           char currentChar = s.charAt(right);

           charCount[currentChar - 'A']++;
           maxFreq = Math.max(maxFreq,charCount[currentChar-'A']);

           int window = right - left +1;

           if(window-maxFreq > k) {
               charCount[s.charAt(left)-'A'] --;
               left++;
           }
           maxLength = Math.max(maxFreq,right-left+1);
       }
       return maxLength;
    }
}
