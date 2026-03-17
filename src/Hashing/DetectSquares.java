package Hashing;

import java.util.HashMap;
import java.util.Map;

public class DetectSquares {
    Map<Integer, Map<Integer,Integer>> coordinates;

    public DetectSquares() {
        this.coordinates = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        coordinates.putIfAbsent(x,new HashMap<>());
        Map<Integer,Integer> corresponding = coordinates.get(x);
        corresponding.put(y,corresponding.getOrDefault(y,0)+1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        if(!coordinates.containsKey(x)) return 0;
        int count = 0;

        Map<Integer,Integer> yMap = coordinates.get(x);
        for (int item : yMap.keySet()){
            if(item == y) continue;

            int side = item-y;
            int xAxis = x + side;

            count += yMap.get(item)
                    * coordinates.getOrDefault(xAxis,new HashMap<>()).getOrDefault(y,0)
                    * coordinates.getOrDefault(xAxis,new HashMap<>()).getOrDefault(item,0);

            xAxis = x - side;
            count+= yMap.get(item)
                    * coordinates.getOrDefault(xAxis,new HashMap<>()).getOrDefault(y,0)
                    * coordinates.getOrDefault(xAxis,new HashMap<>()).getOrDefault(item,0);
        }
        return count;
    }
}
