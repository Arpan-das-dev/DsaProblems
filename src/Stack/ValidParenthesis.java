package Stack;

import java.util.Stack;
/**
 * Validates whether a given string of brackets is properly balanced.
 *
 * <p>A string is considered valid if:
 * <ul>
 *   <li>Every opening bracket has a corresponding closing bracket</li>
 *   <li>Brackets are closed in the correct order</li>
 *   <li>Only the following bracket types are allowed: {@code ()}, {@code {}}, {@code []}</li>
 * </ul>
 *
 * <p><b>Approach (Stack-based):</b>
 * <ol>
 *   <li>Traverse the string character by character</li>
 *   <li>Push opening brackets onto a stack</li>
 *   <li>On encountering a closing bracket:
 *     <ul>
 *       <li>Check if the stack is empty (invalid case)</li>
 *       <li>Verify the top of the stack matches the closing bracket</li>
 *       <li>Pop the matched opening bracket</li>
 *     </ul>
 *   </li>
 *   <li>After processing all characters, the stack must be empty for the string to be valid</li>
 * </ol>
 *
 * <p>The algorithm ensures that brackets are both <b>balanced</b> and <b>properly nested</b>.
 *
 * <p><b>Time Complexity:</b> O(n) — each character is processed once
 * <br>
 * <b>Space Complexity:</b> O(n) — stack space in the worst case
 *
 * <p><b>Why use a Stack?</b>
 * <ul>
 *   <li>Maintains the correct order of opening brackets</li>
 *   <li>Allows last-opened bracket to be closed first (LIFO)</li>
 *   <li>Standard and preferred approach in coding interviews</li>
 * </ul>
 * @author Arpan Das
 * @since 31/12/2025
 */
public class ValidParenthesis {

    /**
     *
     * @param s input a string of parenthesis
     * @return {@link Boolean} if condition satisfied
     */
    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                characterStack.push(ch);
            }
            // Process closing brackets
            else if (ch == ')' || ch == '}' || ch == ']') {

                // No matching opening bracket
                if (characterStack.isEmpty()) return false;

                char top = characterStack.peek();

                // Mismatched bracket type
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }

                // Valid match found
                characterStack.pop();
            }
        }

        // Stack must be empty for a valid string
        return characterStack.isEmpty();
    }
}
