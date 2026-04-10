import BackTracking.*;
import BinarySearch.*;
import BitManipulation.*;
import DivideAndConquer.FindKthLargestElement;
import DynamicProgramming.*;
import Graphs.*;
import Greedy.*;
import Hashing.*;
import Heaps.KClosestPointToOrigin;
import Heaps.KthLargest;
import Heaps.LastStoneWeight;
import Heaps.MinIntervalToIncludeEachQuery;
import HorizontalScanningAKAPrefixScanning.LongestCommonPrefix;
import LinkedLists.LRUCache;
import Mathematical.*;
import Matrix.*;
import Simulation.ConcatenationOfArray;
import Simulation.MultiplyStrings;
import SlidingWindow.*;
import Stack.*;
import Trees.ConstructBinaryTree;
import TwoPointers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        WordSearch2 search2 = new WordSearch2();
        System.out.println("19/02/26 add solution to find words from a 2d array");
        System.out.println(search2.findWords(new char[][] {
                                {'o','a','a','n'},
                                {'e','t','a','e'},
                                {'i','h','k','r'},
                                {'i','f','l','v'}
                        },
                        new String[] {"oath","pea","eat","rain"}
                )
        );
        System.out.println();

        LongestCommonSubSequence subSequence = new LongestCommonSubSequence();
        System.out.println("19/02/2026 add dp solution to find common subsequence");
        System.out.println(subSequence.longestCommonSubsequence("abcdef","abc"));
        System.out.println();

        GraphIsTree isTree = new GraphIsTree();
        System.out.println("20/02/2026 add dfs solution to check if a graph is tree");
        System.out.println(isTree.isTree(4,3,new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(0, 1)),
                new ArrayList<>(Arrays.asList(0, 2)),
                new ArrayList<>(Arrays.asList(2, 3))))));
        System.out.println();

        MeetingRooms2 rooms2 = new MeetingRooms2();
        System.out.println("20/02/2026 add greedy solution to find min room to run overlapping meetings");
        System.out.println(rooms2.minMeetingRooms(new int[]{2,9,6},new int[] {4,12,16}));
        System.out.println();

        ConstructBinaryTree binaryTree = new ConstructBinaryTree();
        System.out.println("20/02/2026 add recursive split solution to create original tree");
        System.out.println(binaryTree.buildTree(new int[]{3,9,20,15,7},new int[] {9,3,15,20,7}));
        System.out.println();

        InsertIntervals insertIntervals = new InsertIntervals();
        System.out.println("21/02/2026 add greedy solution to insert intervals");
        System.out.println(Arrays.deepToString(insertIntervals.insert(new int[][]{{1,3},{6,9}},new int[]{2,5})));
        System.out.println();

        AlienDictionary dictionary = new AlienDictionary();
        System.out.println("22/02/2026 add topological sort technique with graph to solve alien dictionary");
        System.out.println(dictionary.findOrder(new String[] {"baa", "abcd", "abca", "cab", "cad"}));
        System.out.println();

        BinaryGap gap = new BinaryGap();
        System.out.println("22/02/2026 add solution with right shift bit manipulation to find max distance between 1s");
        System.out.println(gap.binaryGap(22));
        System.out.println();

        MedianOfSortedArrays sortedArrays = new MedianOfSortedArrays();
        System.out.println("23/02/2026 add binary search solution to find median of 2 sorted arrays");
        System.out.println(sortedArrays.findMedianSortedArrays(new int[]{1,4,7,10,12}, new int[]{2,3,5,6,8,9,11}));
        System.out.println();

        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println("23/02/2026 add math based reverse integer solution");
        System.out.println(reverseInteger.reverse(123));
        System.out.println();

        StringHasKbinaryCombination hasKbinaryCombination = new StringHasKbinaryCombination();
        System.out.println("23/02/2026 add bit manipulation to check if all k no of combination present in a string");
        System.out.println(hasKbinaryCombination.hasAllCodes("0110",2));
        System.out.println();

        SortByNumberOfBits numberOfBits = new SortByNumberOfBits();
        System.out.println("26/02/2026 add solution to sort numbers based on bits");
        System.out.println(Arrays.toString(numberOfBits.sortByBits(new int[]{1, 4, 6, 3, 8, 9, 3})));
        System.out.println();

        StepsToMakeOneBit makeOneBit = new StepsToMakeOneBit();
        System.out.println("26/02/2026 add solution to count how many steps need to make a binary as one bit");
        System.out.println(makeOneBit.numSteps("1011"));
        System.out.println();

        RottingOranges oranges = new RottingOranges();
        System.out.println("26/02/2026 add solution to find min time required so the all oranges are rotten");
        System.out.println(oranges.orangesRotting(new int[][] {{2,1,1},{1,1,0},{0,1,1}}));
        System.out.println();

        CoinChange2 coinChange2 = new CoinChange2();
        System.out.println("26/02/2026 add dp solution to find all possible way to reach given amount");
        System.out.println(coinChange2.change(11,new int[]{5,3,2,1}));
        System.out.println();

        RegularExpressionMatching expressionMatching = new RegularExpressionMatching();
        System.out.println("28/02/2026 add dp solution to find valid expression matches or not");
        System.out.println(expressionMatching.isMatch("abb","b."));
        System.out.println();

        LetterCombinationOfPhoneNo combinationOfPhoneNo = new LetterCombinationOfPhoneNo();
        System.out.println("28/02/2026 add backtracking solution to find all combination from digits");
        System.out.println(combinationOfPhoneNo.letterCombinations("23"));
        System.out.println();

        ConcatenationOfConsecutiveBinaryNumbers concatenation = new ConcatenationOfConsecutiveBinaryNumbers();
        System.out.println("28/02/2026 add bit manipulation and left shift operation to find consecutive binary num");
        System.out.println(concatenation.concatenatedBinary(3));
        System.out.println();

        CombinationSum2 sum2 = new CombinationSum2();
        System.out.println("01/03/2026 add backtracking to solve combination sum 2");
        System.out.println(sum2.combinationSum2(new int[] {10,5,6,3,2,1,4,7},8));
        System.out.println();

        ValidSudoku sudoku = new ValidSudoku();
        System.out.println("01/03/2026 add partial row column and sub-box based validation to check valid condition");
        System.out.println(sudoku.isValidSudoku(new char[][] {
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}
                })
        );
        System.out.println();

        PartitionIntoMinimumDeciBinaryNumbers partition = new PartitionIntoMinimumDeciBinaryNumbers();
        System.out.println("01/03/2026 add greedy approach to find max value to get max possible partition");
        System.out.println(partition.minPartitions("12"));
        System.out.println();

        JumpGame2 game2 = new JumpGame2();
        System.out.println("04/03/2026 add greedy approach to solve to find min steps to reach last index");
        System.out.println(game2.jump(new int[] {2,3,1,1,4}));
        System.out.println();


        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println("04/03/2026 add simulation with carry propagation to multiply strings");
        System.out.println(multiplyStrings.multiply("12","11"));
        System.out.println();

        PowXN power = new PowXN();
        System.out.println("06/03.2026 add solution to find exp value of a number");
        System.out.println(power.myPow(2.0,3));
        System.out.println();

        PermutationsOfNumber permutations = new PermutationsOfNumber();
        System.out.println("06/03/2026 add backtracking solution to find distinct combination");
        System.out.println(permutations.permute(new int[] {1,2,3}));
        System.out.println();

        NQueens queens = new NQueens();
        System.out.println("08/03/2026 add backtracking solution to find distinct unbeatable n queens position");
        System.out.println(queens.solveNQueens(4));
        System.out.println();

        PlusOne plusOne = new PlusOne();
        System.out.println("08/03/2026 add both optimal and non optimal way to find +1 value of an array");
        System.out.println(Arrays.toString(plusOne.plusOneNonOptimal(new int[]{9})));
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{9, 8, 9})));
        System.out.println();

        EditDistance editDistance = new EditDistance();
        System.out.println("08/03/2026 add 2D DP solution to find solution");
        System.out.println(editDistance.minDistance("horse","ros"));
        System.out.println();

        SubSets subSets = new SubSets();
        System.out.println("08/03/2026 add backtracking solution to generate subset of an array");
        System.out.println(subSets.subsets(new int[]{1,2,3}));
        System.out.println();

        InterleavingString interleavingString= new InterleavingString();
        System.out.println("09/03/2026 add 2d dp solution to find if two string's inter living combo is same as input");
        System.out.println(interleavingString.isInterleave("aab","axy","aaxaby"));
        System.out.println();

        LargestRectangleInHistogram rectangleInHistogram = new LargestRectangleInHistogram();
        System.out.println("09/03/2026 add stack based next greater and previous greater approach solution");
        System.out.println(rectangleInHistogram.maxArea(new int[] {2,1,5,6,2,3}));
        System.out.println();

        TaskScheduler scheduler = new TaskScheduler();
        System.out.println("10/03/2026 add greedy solution to schedule task in cpu");
        System.out.println(scheduler.leastInterval(new char[] {'A','B','B','B','A','A','A'},2));
        System.out.println();

        DistinctSubsequences subsequences = new DistinctSubsequences();
        System.out.println("10/03/2026 add 2d DP solution to find max numb of distinct subsequences");
        System.out.println(subsequences.numDistinct("babgbag","bag"));
        System.out.println();

        LastStoneWeight stoneWeight = new LastStoneWeight();
        System.out.println("10/03/2026 add queue based solution to solve last stone weight problem");
        System.out.println(stoneWeight.lastStoneWeight(new int[]{2,7,4,1,8,1}));
        System.out.println(stoneWeight.lastStoneWeightCollectionVersion(new int[] {2,7,4,1,8,1}));
        System.out.println();

        SurroundedRegions regions = new SurroundedRegions();
        System.out.println("10/03/2026 add dfs based solution to mark uncapturable O in a 2D matrix");
        regions.solve(new char[][] {
                {'X','X','X','X'},
                {'X','0','0','X'},
                {'X','X','0','X'},
                {'X','0','X','X'}
        });
        System.out.println();

        PalindromePartitioning partitioning = new PalindromePartitioning();
        System.out.println("13/03/2026 as backtracking based solution to find palindromic partitions");
        System.out.println(partitioning.partition("aab"));
        System.out.println();

        SingleNumber singleNumber = new SingleNumber();
        System.out.println("13/03/2026 add hashmap/bit manipulation technique to identify single occurrence of an element");
        System.out.println(singleNumber.singleNumber(new int[] {4,2,3,1,2,3,1}));
        System.out.println(singleNumber.singleNumberMapVersion(new int[] {1,1,2,4,5,3,2,5,3}));
        System.out.println();

        WordLadder wordLadder = new WordLadder();
        System.out.println("13/03/2026 add bfs based solution to solve word ladder");
        System.out.println(wordLadder.ladderLength("hit","cog", List.of("hot","dot","dog","log","cog")));
        System.out.println();

        MinCostToClimbStairs costToClimbStairs = new MinCostToClimbStairs();
        System.out.println("14/03/2026 add dp memoization technique to find min cost to climb all stairs");
        System.out.println(costToClimbStairs.minCostClimbingStairs(new int[] {10,15,20}));
        System.out.println();

        LRUCache lruCache = new LRUCache(4);
        System.out.println("14/03/2026 designed a doubly linked list based cache");
        lruCache.put(2,5);
        System.out.println(lruCache.get(3));
        lruCache.put(4,2);
        System.out.println(lruCache.get(2));
        System.out.println();

        ValidParenthesisString validParenthesisString = new ValidParenthesisString();
        System.out.println("15/03/2026 add greedy approach to validate parenthesis string");
        System.out.println(validParenthesisString.checkValidString("(*)"));
        System.out.println();

        SubSets2 subSets2 = new SubSets2();
        System.out.println("17/03/2026 add backtracking method to create unique subset from duplicate array");
        System.out.println(subSets2.subsetsWithDup(new int[]{1,2,3,4,2}));
        System.out.println();

        DetectSquares detectSquares = new DetectSquares();
        System.out.println("17/03/2026 add hashing with co-ordinate geometry to solve detect square");
        detectSquares.add(new int[]{3,10});
        detectSquares.add(new int[] {11,2});
        detectSquares.add(new int[] {3,2});
        System.out.println("squares detected for -> "+detectSquares.count(new int[]{11,10}));
        System.out.println();

        HappyNumber isHappy = new HappyNumber();
        System.out.println("18/03/2026 add method to find if a number is happy or not");
        System.out.println(isHappy.isHappy(17));
        System.out.println();

        FindKthLargestElement kthLargestElement = new FindKthLargestElement();
        System.out.println("18/03/2026 add min heap and divide & conquer method to find kth largest element");
        System.out.println(kthLargestElement.findKthLargest(new int[]{3,2,1,5,6,4},2));
        System.out.println(kthLargestElement.findKthLargestHeap(new int[]{3,2,1,5,6,4},2));
        System.out.println();

        ConcatenationOfArray concatenationOfArray = new ConcatenationOfArray();
        System.out.println("20/03/2026 add solution to find solution of concatenation of an array");
        System.out.println(Arrays.toString(concatenationOfArray.getConcatenation(new int[]{1, 4, 1, 2})));
        System.out.println();

        MinCostToConnectAllPoints costToConnectAllPoints = new MinCostToConnectAllPoints();
        System.out.println("20/03/2026 add prim's algorithm both queue and non queue based solution");
        int[][] points = new int[][] {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(costToConnectAllPoints.minCostConnectPoints(points));
        System.out.println(costToConnectAllPoints.minCostConnectPointsPrims(points));
        System.out.println();

        RedundantConnection redundantConnection = new RedundantConnection();
        System.out.println("21/03/2026 add DSU method to find redundant connection");
        int[][] edges = new int[][] {{1,2},{2,3},{3,4},{1,4},{1,5}};
        System.out.println(Arrays.toString(redundantConnection.findRedundantConnectionDSU(edges)));
        System.out.println(Arrays.toString(redundantConnection.findRedundantConnection(edges)));

        SubArraySumK subArraySumK = new SubArraySumK();
        System.out.println("21/03/2026 add prefix sum method to find sub array sum == k");
        System.out.println(subArraySumK.subarraySum(new int[]{2,-1,1,2},2));
        System.out.println();

        UniquePaths uniquePaths = new UniquePaths();
        System.out.println("22/03/2026 add 2d dp problem to find all possible way to find paths");
        System.out.println(uniquePaths.uniquePaths(3,7));
        System.out.println();

        SlidingWindowMaximum windowMaximum = new SlidingWindowMaximum();
        System.out.println("22/03/2026 add deque based sliding window pattern to find max for each window");
        System.out.println(Arrays.toString(windowMaximum.maxSlidingWindow(new int[]{1,2,1,0,4,2,6}, 3)));
        System.out.println();

        SetZeros setZeros = new SetZeros();
        System.out.println("22/03/2026 used a marker based solution to make row and cols zero for a matrix");
        setZeros.setZeroes(new int[][] {{1,1,1}, {1,0,1}, {1,1,1}});
        System.out.println();

        SwimInRisingWater risingWater = new SwimInRisingWater();
        System.out.println("23/03/26 used DFS + Binary search to find min time to reach to end");
        System.out.println(risingWater.swimInWater(new int[][]{
                {0,1,2,3,4}, {24,23,22,21,5}, {12,13,14,15,16}, {11,17,18,19,20}, {10,9,8,7,6}
        }));
        System.out.println();

        CourseSchedule2 schedule2 = new CourseSchedule2();
        System.out.println("23/03/26 using topological sort with indegree to return probable schedule");
        System.out.println(Arrays.toString(schedule2.findOrder(4,new int[][] {{1,0},{2,0},{3,1},{3,2}})));
        System.out.println();

        MinIntervalToIncludeEachQuery includeEachQuery = new MinIntervalToIncludeEachQuery();
        System.out.println("23/03/26 used sorting and heap based on time to find query time");
        System.out.println(Arrays.toString(includeEachQuery
                .minInterval(new int[][] {{1,4},{2,4},{3,6},{4,4}},new int[] {2,3,4,5})));
        System.out.println();

        NetworkDelay networkDelay = new NetworkDelay();
        System.out.println("23/03/26 used dijkstra algo to find min cost to reach all nodes");
        System.out.println(networkDelay.networkDelayTime(new int[][] {{2,1,1},{2,3,1},{3,4,1}},4,2));
        System.out.println();

        ConnectedComponentsInAUnidirectedGraph components = new ConnectedComponentsInAUnidirectedGraph();
        System.out.println("23/03/26 used DFS based solution to return connected components");
        System.out.println(components.getComponents(5,new int[][] {{0,1},{2,1},{3,4}}));
        System.out.println();

        LongestIncreasingPathInAMatrix longestIncreasingPathInAMatrix = new LongestIncreasingPathInAMatrix();
        System.out.println("27/03/2026 add dp with DFS based solution to find max increasing path");
        System.out.println(longestIncreasingPathInAMatrix.longestIncreasingPath(new int[][] {
                {9,9,4}, {6,6,8}, {2,1,1}
        }));
        System.out.println();

        TargetSum targetSum = new TargetSum();
        System.out.println("27/03/2026 add dp based solution to find ways to reach target with + and - values");
        System.out.println(targetSum.findTargetSumWays(new int[] {1,1,1,1,1},3));
        System.out.println(targetSum.findTargetSumWaysBrute(new int[] {1,1,1,1,1},3));
        System.out.println();

        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println("27/03/2026 add greedy solution to find solution");
        System.out.println(partitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println();

        PeakIndexInAMountainArray peak = new PeakIndexInAMountainArray();
        System.out.println("28/03/2026 add a binary search method to find max peak of an array");
        System.out.println(peak.peakIndexInMountainArray(new int[] {1,2,3,4,5,4,3,2}));
        System.out.println();

        MinSwapsToGroupAllOnes minSwapsToGroupAllOnes = new MinSwapsToGroupAllOnes();
        System.out.println("28/03/2026 add sliding window to find min swaps req to group all one");
        System.out.println(minSwapsToGroupAllOnes.minSwaps(new int[]{1,1,0,1,0}));
        System.out.println();

        KthLargest kthLargest = new KthLargest(3,new int []{74,64,87});
        System.out.println("29/03/2026 add a class to find kth highest value from a stream");
        System.out.println(kthLargest.add(89));
        System.out.println();

        MergeTripletToFormTriplet toFormTriplet = new MergeTripletToFormTriplet();
        System.out.println("29/03/2026 add greedy solution to find can triplet can be made or not");
        System.out.println(toFormTriplet.mergeTriplets(new int[][] {{2,5,3},{1,8,4},{1,7,5}},new int[] {2,7,5}));
        System.out.println();

        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        System.out.println("29/03/2026 solved Eulerian Path problem on a directed graph to find correct itinerary");
        System.out.println(reconstructItinerary
                .findItinerary(List.of(
                        List.of("MUC","LHR"),List.of("JFK","MUC"),List.of("SFO","SJC"),List.of("LHR","SFO"))
                ));
        System.out.println();

        KClosestPointToOrigin closestPointToOrigin = new KClosestPointToOrigin();
        System.out.println("04/04/2026 add heap based solution to find kth closest point to origin");
        System.out.println(Arrays
                .deepToString(closestPointToOrigin.kClosest(new int[][]{{1, 1}, {4, 3}, {3, -9}}, 2)));
        System.out.println();

        PartitionEqualSubsetSum subsetSum = new PartitionEqualSubsetSum();
        System.out.println("04/04/2026 add dp based solution to find if the array can be divided into two subset of same sum");
        System.out.println(subsetSum.canPartition(new int[] {5,5,1,11}));
        System.out.println();

        LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
        System.out.println("05/04/2026 add horizontal scanning mechanism to find longest common prefix");
        System.out.println(commonPrefix.longestCommonPrefix(new String[]{"bat","bag","ball"}));
        System.out.println();

        ReverseString reverseString = new ReverseString();
        System.out.println("05/04/2026 add both swap and two pointer based solution to reverse string");
        char[] str = new char[] {'b','a','t','f'};
        reverseString.reverseString(str);
        reverseString.reverseStringSwapBased(str);
        System.out.println();

        BoatsToSavePeople toSavePeople = new BoatsToSavePeople();
        System.out.println("05/04/2026 add two pointer greedy approach to find min number of boats required");
        System.out.println(toSavePeople.numRescueBoats(new int[] {5,1,4,2},6));
        System.out.println();

        BaseBallGame baseBallGame = new BaseBallGame();
        System.out.println("05/04/2026 add stack based solution to find final scorecard of baseball game");
        System.out.println(baseBallGame.calPoints(new String[] {"5","2","C","D","+"}));
        System.out.println();

        GuessTheNumber guessTheNumber = new GuessTheNumber(15);
        System.out.println("08/04/2026 add a binary search based number guess game method");
        System.out.println(guessTheNumber.guessNumber(20));
        System.out.println();

        SortColors sortColors = new SortColors();
        System.out.println("10/04/2026 add a dutch flag algorithm to sort colors");
        sortColors.sortColors(new int[] {1,1,0,2,0});
        System.out.println();

        ReOrganizeString reOrganizeString = new ReOrganizeString();
        System.out.println("10/04/2026 add greedy based solution to add most frequent char first");
        System.out.println(reOrganizeString.reorganizeString("apple"));
        System.out.println();

        MergeStringsAlternately alternately = new MergeStringsAlternately();
        System.out.println("10/04/2026 add two pointer approach to generate string with alternate chars");
        System.out.println(alternately.mergeAlternately("apple","pokemon"));
        System.out.println();
    }
}