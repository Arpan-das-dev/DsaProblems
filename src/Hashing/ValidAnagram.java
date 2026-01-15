package Hashing;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // if their lengths are not same they can't be anagram
        if(s.length()!= t.length()) return false;
        if(s.equals(t)) return true;

        // transforming them into lower case
        s = s.toLowerCase();
        t = t.toLowerCase();

        // initialize an array with 26 size (as in alphabet we have 26 letters) with 0 value;
        int [] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char firstString = s.charAt(i); // char from first string at i th index
            char secondString = t.charAt(i); // char from second string at i th index

            freq[firstString - 'a'] ++; // for first string increment freq for the letter
            freq[secondString - 'a'] --; // for the second string decrement freq for the letter
        }

        // now if they are anagrams then all values in the array will be zero
        // because both the string has same freq of letters
        for (int count : freq) {
            if(count != 0) return false;
        }
        return true;
    }
}
