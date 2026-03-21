package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    private final Map<String, List<Pair>> pairMap;

    public TimeMap() {
        this.pairMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        pairMap
                .computeIfAbsent(key, k -> new ArrayList<>())
                .add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!pairMap.containsKey(key)) return "";

        List<Pair> pairs = pairMap.get(key);
        String result = "";
        int left = 0, right = pairs.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (pairs.get(mid).timeStamp <= timestamp) {
                result = pairs.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    static class Pair {
        int timeStamp;
        String value;

        public Pair(int timeStamp, String value) {
            this.timeStamp = timeStamp;
            this.value = value;
        }
    }
}
