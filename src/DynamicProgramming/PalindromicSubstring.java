package DynamicProgramming;

public class PalindromicSubstring {
    public int countSubstringsBrute(String s) {
        if(s==null || s.isEmpty()) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if(isPalindrome(s,i,j)) count++;
            }
        }
        return count;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j --;
        }
        return true;
    }

    public int countSubstrings(String s) {
        if(s==null || s.isEmpty()) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
           count+= countPalindrome(s,i,i);
           count += countPalindrome(s,i,i+1);
        }
        return count;
    }

    private int countPalindrome(String s, int left, int right) {
        int count = 0;
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }

}
