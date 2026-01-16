package Stack;

import java.util.*;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> numeric = new ArrayDeque<>();
        
        //["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        for (String item : tokens) {
            if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")) {
                int lastPrevious = numeric.pop();
                int secondPrevious = numeric.pop();
                switch (item) {
                    case "-" -> numeric.push(secondPrevious - lastPrevious);
                    case "*" -> numeric.push(secondPrevious * lastPrevious);
                    case "/" -> numeric.push(secondPrevious / lastPrevious);
                    default -> numeric.push(secondPrevious + lastPrevious);
                }
            }
            else numeric.push(Integer.parseInt(item));
        }
        return numeric.pop();
    }
}
