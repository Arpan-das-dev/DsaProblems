package BackTracking;

import java.util.*;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result,n,0,0,new StringBuilder());
        return result;
    }

    private void backTrack(List<String> result, int max, int open, int close, StringBuilder stringBuilder) {
        if(stringBuilder.length() == 2 * max){
            result.add(stringBuilder.toString());
            return;
        }
        if(open < max) {
            stringBuilder.append('(');
            backTrack(result,max,open+1,close,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if(close < open) {
            stringBuilder.append(')');
            backTrack(result,max,open,close+1,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
