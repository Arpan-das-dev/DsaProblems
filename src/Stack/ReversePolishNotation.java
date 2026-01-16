package Stack;

import java.util.*;

/**
 * Utility class for evaluating an arithmetic expression in Reverse Polish Notation (RPN).
 *
 * <p>In RPN (postfix notation), operators follow their operands. For example, "3 4 +"
 * means 3 + 4. The expression is evaluated using a stack: numbers are pushed onto
 * the stack, and when an operator is encountered, the required operands are popped,
 * the operation is performed, and the result is pushed back.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use a stack (Deque) to store intermediate integer values.</li>
 *   <li>Traverse each token in the input array:
 *     <ul>
 *       <li>If the token is an operator (+, −, *, /), pop the top two values (secondPrevious, lastPrevious),
 *           apply the operation, and push the result back.</li>
 *       <li>If the token is a number, parse it and push it onto the stack.</li>
 *     </ul>
 *   </li>
 *   <li>After processing all tokens, the stack contains exactly one value: the result.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n), where n is the number of tokens.<br>
 * <b>Space Complexity:</b> O(n), for the stack in the worst case.</p>
 *
 * @author Arpan Das
 * @since 16/01/2026
 */
public class ReversePolishNotation {

    /**
     * Evaluates an arithmetic expression in Reverse Polish Notation (postfix notation).
     *
     * <p>Valid operators are "+", "−", "*", and "/". Division truncates toward zero.
     * The input is guaranteed to be a valid RPN expression with at least one token.</p>
     *
     * @param tokens array of strings representing numbers and operators in RPN
     * @return the evaluated integer result of the expression
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> numeric = new ArrayDeque<>();

        for (String item : tokens) {
            if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")) {
                int lastPrevious = numeric.pop();        // Top element (right operand)
                int secondPrevious = numeric.pop();      // Next element (left operand)

                switch (item) {
                    case "-" -> numeric.push(secondPrevious - lastPrevious);
                    case "*" -> numeric.push(secondPrevious * lastPrevious);
                    case "/" -> numeric.push(secondPrevious / lastPrevious);
                    default  -> numeric.push(secondPrevious + lastPrevious);
                }
            } else {
                numeric.push(Integer.parseInt(item));    // Push number onto stack
            }
        }
        return numeric.pop();  // Final result
    }
}

