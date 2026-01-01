package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupOfAnagrams {
    public List<List<String>> groupAnagramsBrute(String [] strings) {
        Map<String , List<String>> stringListMap = new HashMap<>();

        for(String str : strings) {
            int [] frequencyArray = new int[26]; // initiating a 26 length array with '0' value
            for(char c : str.toCharArray()) {
                frequencyArray[c-'a']++; // increasing value as per char position in alphabet
                                            // eg- > e = 5-1, j = 10-1, t=20-1
            }
            // building unique signature key;
            StringBuilder key = new StringBuilder(); // using StringBuilder
                                                    // for efficient mutable string construction

            for(int i : frequencyArray) {
                key.append(i).append('#'); // generate a unique key with int value and # eg-> for 12 12#
            }
            // cheks the key is already present in the map
            // if yes then add the string into the list which generated the key
            // if not assign a new unique key with a new list adding that particular string
            // who generated that method
            /*
             * easy mode ->
             * if(map.containsKey(key) {
             * map.get(key).add(str)
             * } else {
             * map.put(key, new ArrayList()).add(key)
             * }
             */
            stringListMap.computeIfAbsent(key.toString(),string -> new ArrayList<>())
                    .add(str);
        }
        return new ArrayList<>(stringListMap.values());
    }

}
