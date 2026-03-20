package Simulation;

public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        if(nums == null || nums.length == 0) return new int [] {};

        int length = nums.length;
        int[] result = new int[length *2];

        for(int i = 0; i<result.length; i++){
            if(i>=length){
                result[i] = nums[i-length];
            }
            else result[i] = nums[i];
        }
        return result;
    }
}
