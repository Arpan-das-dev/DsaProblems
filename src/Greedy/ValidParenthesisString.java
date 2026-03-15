package Greedy;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int max = 0; // max possible opening parentheses '('
        int min = 0; // min possible opening parentheses ')'

        for (char ch : s.toCharArray()) {
            if(ch == '(') {
                // if opening tag then increment to keep track remaining '(' to deal with
                max++;
                min++;
            } else if (ch == ')') {
                // if closing tag then decrement the both counter
                max--;
                min--;
            }
            else {
                max ++; // if '*' consider as '(' then max is incremented
                min --; // if '*' consider as ')' then min is decremented
            }

            // at any point if closing ')' counts are more than '(' then max will be decremented
            // and if it's < 0 then invalid
            if(max < 0) return false;

            // update the min counter cause for '*' considered as '(' can make it negative
            min = Math.max(min,0);
        }
        // in valid case it will be zero count
        return min == 0;
    }
}
