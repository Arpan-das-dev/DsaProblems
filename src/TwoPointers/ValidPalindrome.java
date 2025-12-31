package TwoPointers;

public class ValidPalindrome {
    /**
     * A phrase is a palindrome if, after converting all uppercase letters
     * into lowercase letters and removing all non-alphanumeric characters,
     * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
     * @param s
     * @return {@boolean}
     */

    public boolean palindromeBrute(String s) {
        if(s.isEmpty()) return true;
        else{
            String reverse = "";
            String inverse = "";
            for (int i = 0; i < s.length(); i++) {
                if(Character.isLetterOrDigit(s.charAt(i))) {
                    reverse = reverse+s.charAt(i);
                    inverse = s.charAt(i)+inverse;
                }
            }
            System.out.println("reverse --> "+reverse);
            System.out.println("inverse --> "+inverse);
            return reverse.equals(inverse);
        }
    }

    public boolean palindrome(String s){
        if(s.isEmpty()) return true;
        int start = 0;
        int end = s.length()-1;
        while (start<end) {
            while (start<end && !Character.isLetterOrDigit(s.charAt(start))) start ++;
            while (start<end &&!Character.isLetterOrDigit(s.charAt(end))) end--;

            char leftChar = Character.toLowerCase(s.charAt(start));
            char rightChar = Character.toLowerCase(s.charAt(end));

            if(leftChar!=rightChar) return false;
            start ++;
            end --;
        }
        return true;
    }
}
