package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> characterSet = new HashSet<>();
        int length = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right ++) {
            Character ch = s.charAt(right);
            while (characterSet.contains(ch)) {
                characterSet.remove(s.charAt(left));
                left++;
            }
            characterSet.add(ch);
            length = Math.max(length,(right - left + 1));
        }
        return length;
    }
}
