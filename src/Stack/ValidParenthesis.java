package Stack;

import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s){
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                characterStack.push(ch);
            }
            else if (ch == ')' || ch == '}' || ch == ']'){
                if(characterStack.isEmpty()) return false;
                char top = characterStack.peek();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
                characterStack.pop();
            }
        }
        return characterStack.isEmpty();
    }
}
