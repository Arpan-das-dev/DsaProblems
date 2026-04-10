package Greedy;

import java.util.Arrays;

public class ReOrganizeString {
    public String reorganizeString(String s) {
        if(s == null || s.isEmpty()) return "";

        int[] freq = new int[26];
        for (char ch: s.toCharArray()){
            freq[ch-'a']++;
        }

        int maxFreq = Arrays.stream(freq).max().getAsInt();
        if (maxFreq > (s.length() + 1) / 2) {
            return "";
        } // impossible

        StringBuilder res = new StringBuilder();
        while (res.length() < s.length()) {
            int maxFrequent = findMax(freq);
            appendAndDecrement(res,maxFrequent,freq);

            if(freq[maxFrequent] == 0) continue; // skip

            int temp = freq[maxFrequent];
            freq[maxFrequent] = Integer.MIN_VALUE;
            int nextFrequent = findMax(freq);
            appendAndDecrement(res,nextFrequent,freq);

            freq[maxFrequent] = temp;
        }
        return res.toString();
    }

    private void appendAndDecrement(StringBuilder sb, int idx, int[] freq){
        char toAppend = (char) (idx+'a');
        sb.append(toAppend);
        freq[idx]--;
    }
    private int findMax(int[] freq) {
        int index = 0;
        for (int i = 1; i < freq.length; i++) {
            if(freq[i] >  freq[index]) index = i;
        }
        return index;
    }
}
