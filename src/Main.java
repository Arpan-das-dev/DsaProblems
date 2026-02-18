import BackTracking.CombinationSum;
import BackTracking.GenerateParenthesis;
import BackTracking.WordSearch;
import BinarySearch.FindMinInRotatedSortedArray;
import BinarySearch.KokoEatingBananas;
import BitManipulation.CountBits;
import BitManipulation.Number1Bits;
import BinarySearch.SearchInRotatedSortedArray;
import BitManipulation.ReverseBits;
import BitManipulation.SumOfTwoIntegers;
import DynamicProgramming.*;
import Graphs.CourseSchedule;
import Graphs.MaxAreaOfIsland;
import Graphs.NumberOfIsland;
import Graphs.PacificAtlanticWaterFlow;
import Greedy.*;
import Hashing.*;
import Mathematical.MissingNumber;
import Matrix.RotateImage;
import Matrix.SpiralMatrix;
import SlidingWindow.BuyAndSellStocks;
import SlidingWindow.LongestRepeatingCharReplacement;
import SlidingWindow.LongestSubstringWithoutRepeatingCharacters;
import SlidingWindow.MinWindowSubString;
import Stack.DailyTemperatures;
import Stack.MinStack;
import Stack.NextGreaterElement;
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

        LongestSubstringWithoutRepeatingCharacters characters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println("17/01/2026 solved to find min substring with unique chars");
        System.out.println(characters.lengthOfLongestSubstring("pwwkew"));

        EncodeDecodeString encodeDecodeString = new EncodeDecodeString();
        System.out.println("19/01/2026 solved to encode and and decode string");
        System.out.println(encodeDecodeString.encode(new String[] {"Hello","World"}));
        System.out.println(Arrays.toString(encodeDecodeString.decode(encodeDecodeString.
                encode(new String[] {"Hello","World"}))));
        System.out.println();

        NextGreaterElement greaterElement = new NextGreaterElement();
        System.out.println("20/01/2026 find solution to find next bigger element for each item");
        System.out.println(Arrays
                .toString(greaterElement.nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2})));
        System.out.println();

        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println("20/01/2026 add back tracking solution to generate valid parenthesis");
        System.out.println(generateParenthesis.generateParenthesis(3));
        System.out.println();

        FindMinInRotatedSortedArray minInRotatedSortedArray = new FindMinInRotatedSortedArray();
        System.out.println("20/01/2026 add method solution with binary search to find min in an sorted array (rotated)");
        System.out.println(minInRotatedSortedArray.findMin(new int[] {4,5,6,7,0,1,2,3}));
        System.out.println();

        LongestRepeatingCharReplacement charReplacement = new LongestRepeatingCharReplacement();
        System.out.println("20/01/2026 add sliding window solution to find char replacement");
        System.out.println(charReplacement.characterReplacement("ABBA",2));
        System.out.println();

        CarFleet fleet = new CarFleet();
        System.out.println("23/01/2026 add greedy solution to find car fleets count");
        System.out.println(fleet.carFleet(12, new int[] {10,8,0,5,3}, new int[] {2,4,1,1,3}));
        System.out.println();

        MissingNumber missingNumber = new MissingNumber();
        System.out.println("26/01/2026 add mathematical solution to find a missing number");
        System.out.println(missingNumber.missingNumber(new int[] {3,0,1}));
        System.out.println();

        CombinationSum combinationSum = new CombinationSum();
        System.out.println("27/01/2026 add combination sum with backtracking");
        System.out.println(combinationSum.combinationSum(new int[]{2,2,3},8));
        System.out.println();

        PacificAtlanticWaterFlow waterFlow = new PacificAtlanticWaterFlow();
        System.out.println("27/01/2026 add dfs solution for pacific atlantic water flow");
        System.out.println(waterFlow.pacificAtlantic(new int[][] {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        }));
        System.out.println();

        MaxSumSubArray sumSubArray = new MaxSumSubArray();
        System.out.println("28/01/2026 add dp solution for max sum for a subarray");
        System.out.println(sumSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println();

        NumberOfIsland ofIsland = new NumberOfIsland();
        System.out.println("28/01/2026 add recursive dp solution for count max no of island");
        System.out.println(ofIsland.numIslands(new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        }));
        System.out.println();

        CourseSchedule schedule = new CourseSchedule();
        System.out.println("29/01/2026 add solution with tropological sorting method");
        System.out.println(schedule.canFinish(4, new int[][] { {1, 0},{2, 1},{3, 2} }));
        System.out.println();

        NonOverLappingIntervals nonOverLappingIntervals = new NonOverLappingIntervals();
        System.out.println("29/01/2026 add greedy solution to find no of intervals need to remove");
        System.out.println(nonOverLappingIntervals.eraseOverlapIntervals(new int[][] {{1,2},{2,3},{3,4},{1,3}}));
        System.out.println();

        RotateImage rotateImage = new RotateImage();
        System.out.println("29/01/2026 add brute and optimal solution to rotate image");
        rotateImage.rotate(new int[][] {{1,2,3}, {4,5,6},{7,8,9}});
        System.out.println();

        Number1Bits bits = new Number1Bits();
        System.out.println("30/01/2026 add both optimal and brute force solution for count 1 bits");
        System.out.println(bits.hammingWeight(7));
        System.out.println();

        JumpGame1 game1 = new JumpGame1();
        System.out.println("30/01/2026 add greedy solution to find if can reach last step");
        System.out.println(game1.canJump(new int[] {3,2,1,0,4}));
        System.out.println();

        GasStation station = new GasStation();
        System.out.println("30/01/2026 add greedy solution for gas station");
        System.out.println(station.canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
        System.out.println();

        ReverseBits reverseBits = new ReverseBits();
        System.out.println("16/02/2026 add bit manipulation solution for reverse a bit");
        System.out.println(reverseBits.reverseBits(7));
        System.out.println("--");
        System.out.println(reverseBits.reverseBitsBitSafeApproach(7));
        System.out.println();

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println("16/02/2026 add solution for spiral matrix");
        System.out.println(spiralMatrix.spiralOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println();

        WordSearch wordSearch = new WordSearch();
        System.out.println("16/02/2026 add backtracking dfs solution to find word");
        System.out.println(wordSearch.exist(new char[][] {{'A','B','C','E'},
                                                          {'S','F','C','S'},
                                                          {'A','D','E','E'}},"ABCCED"));
        System.out.println();

        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println("17/02/2026 add greedy to solution to merge intervals");
        System.out.println(Arrays.deepToString(mergeIntervals.merge(new int[][]{{1,4},{4,5}})));
        System.out.println();

        CountBits countBits = new CountBits();
        System.out.println("17/02/2026 add bit manipulation solution to count bits");
        System.out.println(Arrays.toString(countBits.countBits(5)));
        System.out.println();

        MeetingRooms1 rooms1 = new MeetingRooms1();
        System.out.println("18/02/2026 add greedy solution to find if one can attend a meeting");
        System.out.println(rooms1.canAttend(new int[][] {{2,4},{7,10},{4,8}}));
        System.out.println();

        SumOfTwoIntegers twoIntegers = new SumOfTwoIntegers();
        System.out.println("18/02/20206 add partial sum with carry bit manipulation to find sum");
        System.out.println(twoIntegers.getSum(5,3));
        System.out.println();

        MinWindowSubString windowSubString = new MinWindowSubString();
        System.out.println("18/02/2026 add solution to find min window ");
        System.out.println(windowSubString.minWindow("ADOBECODEBANC","ABC"));
        System.out.println();
    }
}