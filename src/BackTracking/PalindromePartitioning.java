package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s == null || s.isEmpty()) return result;

        backTrack(s,result,0,new ArrayList<>());
        return result;
    }

    private void backTrack(String s, List<List<String>> result, int i, ArrayList<String> objects) {
        if(i >= s.length()){
            result.add(new ArrayList<>(objects));
            return;
        }

        for (int len = 1; len+i <= s.length(); len++) {
            String substring = s.substring(i, i + len);

            if(isValidPalindrome(substring)){
                objects.add(substring);
                backTrack(s,result,i+len,objects);
                objects.removeLast();
            }
        }
    }


    private boolean isValidPalindrome(String string) {
        if(string.length() == 1) return true;

        int left = 0;
        int right = string.length()-1;

        while (left < right){
            if(string.charAt(left) != string.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

}
