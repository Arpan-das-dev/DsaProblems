package SlidingWindow;


import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString {
    public String minWindow(String s, String t) {
        if(s.equals(t)) return s;
        if(s.length()<t.length()) return "";

        Map<Character, Integer> requirement = new HashMap<>();
         for (Character ch : t.toCharArray()){
             requirement.put(ch,requirement.getOrDefault(ch,0)+1);
         }

         int left = 0;
         int start = 0;
         int required = t.length();
         int min = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            if (requirement.containsKey(rightChar)) {
                if (requirement.get(rightChar) > 0) {
                    required--;
                }
                requirement.put(rightChar, requirement.get(rightChar) - 1);
            }

            while (required == 0) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                if (requirement.containsKey(leftChar)) {
                    requirement.put(leftChar, requirement.get(leftChar) + 1);
                    if (requirement.get(leftChar) > 0) {
                        required++;
                    }
                }
                left ++;
            }
        }
        return min == Integer.MAX_VALUE ? "" :s.substring(start,start+min);
    }
}
