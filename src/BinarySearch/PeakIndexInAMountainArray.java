package BinarySearch;

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // increasing → peak is on right
                left = mid + 1;
            } else {
                // decreasing → peak is at mid or left
                right = mid;
            }
        }
        return left;
    }
}
