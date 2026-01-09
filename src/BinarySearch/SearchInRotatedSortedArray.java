package BinarySearch;

public class SearchInRotatedSortedArray {

    // [4,5,6,7,0,1,2]
    public int search(int[] num , int target) {
      int n = num.length-1;
      int left = 0; int right = n;
      while (left<=right) {
          int mid = left + (right - left)/2;
          if(num[mid] == target) return mid;

          if(num[left] <= num[mid]) // discard the left part because it's sorted
          {
              /*
              lets assume mid = 3, target is 5
              num[left] = 4 < target && 5 < num[mid] = 7
               */
              if(num[left] <= target && target < num[mid]) {
                  right = mid-1; // right = mid-1 = 2[index] = 6
              } else {
                  left = mid + 1; // left = mid + 1 = 4 [index] = 0 which is invalid here
              }
          }
          else {
              /*
              assume mid = 5; target = 0;
              num[mid] = 1 < target && 1 <= num [right] 2
               */
              if(num[mid] < target && target <= num[right]) {
                  left = mid + 1;
              } else {
                  right = mid -1;
              }
          }
      }
      return -1;
    }

}
