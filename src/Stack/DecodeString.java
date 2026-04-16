package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.isEmpty()) return s;
        Deque<Integer> numbers = new ArrayDeque<>();
        Deque<String> strings = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int number = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '[') {
                numbers.push(number);
                strings.push(current.toString());
                current = new StringBuilder();
                number = 0;
            } else if (ch == ']') {
                int repeat = numbers.pop();
                StringBuilder temp = new StringBuilder(strings.pop());
                temp.append(String.valueOf(current).repeat(Math.max(0, repeat)));
                current = temp;
            } else {
                current.append(ch);
            }
        }
        return current.toString();
    }
}
