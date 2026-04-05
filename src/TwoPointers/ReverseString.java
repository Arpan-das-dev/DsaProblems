package TwoPointers;

public class ReverseString {
    public void reverseStringSwapBased(char[] s) {
        int length = s.length/2;
        for (int i = 0; i < length; i++) {
            swapIt(s,i,s.length-i-1);
        }
    }

    private void swapIt(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public void reverseString (char[] s){
        int left = 0, right = s.length-1;
        while (left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
