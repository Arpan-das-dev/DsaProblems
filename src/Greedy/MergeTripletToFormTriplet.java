package Greedy;

public class MergeTripletToFormTriplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean firstMax = false, secondMax = false,thirdMax=false;

        for(int[] trip:triplets)   {
            if(trip[0]>target[0]||trip[1]>target[1]||trip[2]>target[2]) continue;

            if(trip[0]==target[0]) firstMax=true;
            if(trip[1]==target[1]) secondMax=true;
            if(trip[2]==target[2]) thirdMax=true;
            if(firstMax && secondMax && thirdMax) return true;

        }
        return firstMax && secondMax && thirdMax;
    }
}
