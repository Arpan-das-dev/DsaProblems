package Stack;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTempBrute(int[] temps) {
        int[] day = new int[temps.length];

        for (int i = 0; i < temps.length - 1; i++) {
            for (int j = i+1; j < temps.length ; j++) {
                if(temps[j] > temps[i]) {
                    day[i] = j-i;
                    break;
                }
            }
        }
        return day;
    }

    public int[] dailyTempOptimal(int[] temps) {
        // stack is the best option cause order matters here with index stored
        Stack<Integer> integers = new Stack<>();
        int[] result = new int[temps.length];
        for (int i = temps.length - 1; i >= 0; i--) {
            while (!integers.isEmpty() && temps[integers.peek()] <= temps[i]) {
                integers.pop(); // if the stack is not empty and
                                // current value is greater that top element in the stack
                                // keep removing the elements
            }
            if (integers.isEmpty()) { // if it's empty surely no elements is greater that it
                result[i] = 0;
            } else {
                result[i] = integers.peek() - i;
            }
            integers.push(i); // push the new max value;
        }
        return result;
    }
}
