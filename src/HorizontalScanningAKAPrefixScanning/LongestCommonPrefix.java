package HorizontalScanningAKAPrefixScanning;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];

        String pre = strs[0];
        int max = Integer.MAX_VALUE;

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            int minLength = Math.min(pre.length(),strs[i].length());
            while (j < minLength){
                if(pre.charAt(j) == strs[i].charAt(j)){
                    j++;
                }
                else break;
            }
            pre = pre.substring(0,j);
        }
        return pre;
    }
}
