import BinarySearch.KokoEatingBananas;
import BinarySearch.SearchInRotatedSortedArray;
import DynamicProgramming.*;
import Graphs.MaxAreaOfIsland;
import Hashing.*;
import SlidingWindow.BuyAndSellStocks;
import Stack.DailyTemperatures;
import Stack.MinStack;
import Stack.ValidParenthesis;
import TwoPointers.ContainerWithMostWater;
import TwoPointers.ThreeSum;
import TwoPointers.TrapRainWater;
import TwoPointers.ValidPalindrome;

import java.util.Arrays;

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
        System.out.println("04/01/2026 solved to find longest consecutive sequence inside an array");
        System.out.println(consecutiveSequence.longestConsecutive(new int[] {100,4,200,1,3,2}));
        System.out.println();

        DecodeWays ways = new DecodeWays();
        System.out.println("04/01/2026 solved how many we can decode a string");
        System.out.println(ways.numDecoding("11106"));
        System.out.println();

        MaxAreaOfIsland island = new MaxAreaOfIsland();
        System.out.println("05/01/2026 solved how to find max area of an island");
        int[][] waterBodyWithIsland = new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println("total area of a max island is -> "+island.maxAreaOfIsland(waterBodyWithIsland));
        System.out.println();

        DailyTemperatures temperatures = new DailyTemperatures();
        System.out.println("05/01/2026 solved to find to wait for next warmer days in an array");
        Arrays.stream(temperatures.dailyTempBrute(new int[]{73,74,75,71,69,72,76,73}))
                .forEach(item-> System.out.print(item+" "));
        System.out.println();
        System.out.println("optimal solution below");
        System.out.println();
        Arrays.stream(temperatures.dailyTempOptimal(new int[]{73,74,75,71,69,72,76,73}))
                .forEach(item-> System.out.print(item+" "));
        System.out.println();

        TwoSum1 sum1 = new TwoSum1();
        System.out.println("05/01/2026 solved to find elements in an array who can reach the given target");
        Arrays.stream(sum1.twoSum(new int[] {2,7,11,15},9))
                .forEach(item-> System.out.print(item+" "));
        System.out.println();

        ProductExceptSelf self = new ProductExceptSelf();
        System.out.println(Arrays.toString(self.productExceptSelf(new int[]{1,2,3,4})));


        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        System.out.println("09/01/2026 solved to search an element in a rotated sorted array");
        System.out.println(search.search(new int[] {1,3},0));
        System.out.println();

        ThreeSum threeSum = new ThreeSum();
        System.out.println("09/01/2026 solved 3 sum problem from leet-code ");
        System.out.println(threeSum.threeSum(new int[] {-1,0,1,2,-1,-4}));
        System.out.println();

        WordBreak wordBreak = new WordBreak();
        System.out.println("09/01/2026 solved word break problem");
        System.out.println();

        ClimbStairs stairs = new ClimbStairs();
        System.out.println("10/01/2026 solved how many ways we can climb stairs with taking 1/2 step");
        System.out.println(stairs.climbStairs(5));
        System.out.println();

        MinStack stack = new MinStack();
        System.out.println("10/01/2026 solved to design new stack with required methods as per statement");
        stack.push(2);
        System.out.println("value push in stack");
        System.out.println("top element of the stack is ->"+stack.top());
        System.out.println("min value inside the stack is ->" + stack.getMin());
        stack.pop();
        System.out.println("top value of stack is removed");
        System.out.println();

        HouseRobber2 robber2 = new HouseRobber2();
        System.out.println("12/01/2026 solved to rob houses in circular position");
        System.out.println(robber2.rob(new int[] {1,2,3,1}));
        System.out.println();

        KokoEatingBananas bananas = new KokoEatingBananas();
        System.out.println("12/01/2026 solved min time needed for coco to eat the banana in certain time");
        System.out.println(bananas.minEatingSpeed(new int[] {30,11,23,4,20}, 6));
        System.out.println();

        BuyAndSellStocks stocks = new BuyAndSellStocks();
        System.out.println("12/01/2026 solved to find max profit we can achieve");
        System.out.println(stocks.maxProfitBrute(new int[] {7,1,5,3,6,4}));
        System.out.println(stocks.maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println();

        CoinChange coinChange = new CoinChange();
        System.out.println("13/01/2026 solved dp problem to find min coins need to get the amount");
        System.out.println(coinChange.coinChange(new int[] {1,2,5},5));
        System.out.println();

        TopKElements elements = new TopKElements();
        System.out.println("13/01/2026 solved top frequent elements inside an array");
        System.out.println(Arrays.toString(elements.topKFrequent(new int [] {1,1,1,2,2,3},2)));
        System.out.println();

        ValidAnagram anagram = new ValidAnagram();
        System.out.println("15/01/2026 solved if two string are anagrams of each other");
        System.out.println(anagram.isAnagram("anagram","nagaram"));
        System.out.println();

        MaxProductSubarray productSubarray = new MaxProductSubarray();
        System.out.println("15/01/2026 solved max product of a sub array by using dp");
        System.out.println(productSubarray.maxProduct(new int[] {2,3,-2,4}));
        System.out.println();
    }
}