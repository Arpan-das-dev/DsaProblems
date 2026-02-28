package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNo {
    private static final String [] KEYS = new String[] {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits == null || digits.isEmpty()) return result;

        backTrackingDfs(digits,result,0,new StringBuilder());
        return result;
    }

    private void backTrackingDfs(String digits, List<String> result, int index, StringBuilder stringBuilder) {
        if(index == digits.length()){
            result.add(stringBuilder.toString());
            return;
        }
        int key = digits.charAt(index) -'0';
        String options = KEYS[key];

        for (char letter : options.toCharArray()) {
            stringBuilder.append(letter);
            backTrackingDfs(digits,result,index+1,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
