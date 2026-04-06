package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BaseBallGame {
    public int calPoints(String[] operations) {
        Deque<Integer> points = new ArrayDeque<>();
        for (String item: operations){
            switch (item){
                case "+" -> sumOfLastTwo(points);
                case "C" ->  points.pop();
                case "D" -> {
                    int curr = points.peek();
                    points.push(curr*2);
                }
                default -> points.push(Integer.parseInt(item));
            }
        }
        int res = 0;
        for(int item: points) res+= item;
        return res;
    }

    private void sumOfLastTwo(Deque<Integer> points) {
        if(points.size() < 2) return;;
        int a = points.pop();
        int b = points.peek();
        points.push(a);
        points.push(a+b);
    }
}
