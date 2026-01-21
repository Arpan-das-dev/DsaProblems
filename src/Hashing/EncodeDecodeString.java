package Hashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString {

    public String encode(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }


    public String[] decode(String encoded) {
        List<String> decoded = new ArrayList<>();
        int start = 0;
        int end = encoded.length();
        while (start < end) {
            int hashPosition = encoded.indexOf('#', start);
            int length = Integer.parseInt(encoded.substring(start, hashPosition));
            int startPositon = hashPosition + 1;
            int endPosition = startPositon + length;
            String decode = encoded.substring(startPositon, endPosition);
            decoded.add(decode);
            start = endPosition;
        }
        return decoded.toArray(new String[0]);
    }
}
