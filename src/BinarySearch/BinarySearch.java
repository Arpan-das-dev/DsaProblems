package BinarySearch;

public class BinarySearch {
    public int search(int[] num, int target) {
        int left = 0;
        int right = num.length -1;
        while (left<=right){
            int mid = left + (right-left)/2;

            if(num[mid] == target) return mid;

            if(num[mid]<target) left = mid+1;
            if(num[mid]>target) right = mid-1;

        }
        return -1;
    }
}
