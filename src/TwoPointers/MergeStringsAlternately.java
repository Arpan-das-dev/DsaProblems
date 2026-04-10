package TwoPointers;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int min = Math.min(word1.length(), word2.length());
        String bigger = word1.length() > word2.length() ? word1 : word2;

        StringBuilder res = new StringBuilder();
        int idx = 0;
        while (idx < min) {
            res.append(word1.charAt(idx));
            res.append(word2.charAt(idx));
            idx++;
        }

        if (idx < bigger.length()) {
            res.append(bigger.substring(idx));
        }
        return res.toString();
    }
}
