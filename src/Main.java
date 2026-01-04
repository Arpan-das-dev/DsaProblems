import DynamicProgramming.DecodeWays;
import DynamicProgramming.HouseRobber1;
import Hashing.ContainsDuplicate;
import Hashing.GroupOfAnagrams;
import Hashing.LongestConsecutiveSequence;
import Stack.ValidParenthesis;
import TwoPointers.ContainerWithMostWater;
import TwoPointers.TrapRainWater;
import TwoPointers.ValidPalindrome;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ValidPalindrome palindrome = new ValidPalindrome();
        ContainsDuplicate duplicate = new ContainsDuplicate();
        System.out.println(palindrome.palindrome("race a car"));
        System.out.println("31/12/2025 next contains duplicate -->");
        int [] duplicateArray = {1,2,3,4};
        System.out.println("Ans -> "+duplicate.containsDuplicate(duplicateArray));

        ValidParenthesis parenthesis = new ValidParenthesis();
        System.out.println("31/12/2025 check if a string contains valid parenthesis");
        System.out.println(parenthesis.isValid("([)]"));
        System.out.println();

        TrapRainWater rainWater = new TrapRainWater();
        System.out.println("01/01/2026 check rain water trapped by bars");
        System.out.println(rainWater.trackTrappedWater(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println();

        GroupOfAnagrams anagrams = new GroupOfAnagrams();
        System.out.println("01/01/2026 returns group of anagrams as a list which is a list of strings");
        System.out.println(anagrams.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
        System.out.println();

        HouseRobber1 robber1 = new HouseRobber1();
        System.out.println("01/01/2026 checking max amount can be looted from multiple home");
        System.out.println(robber1.maxMoneyStolen(new int[]{2,7,9,3,1}));
        System.out.println();

        ContainerWithMostWater mostWater = new ContainerWithMostWater();
        System.out.println("04/01/2026 solved how to check max amount of water stored by container");
        System.out.println(mostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println();

        LongestConsecutiveSequence consecutiveSequence = new LongestConsecutiveSequence();
        DecodeWays ways = new DecodeWays();
    }
}