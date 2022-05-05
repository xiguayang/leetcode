/**
 * 852. Peak Index in a Mountain Array
 * arr.length >=3, is guaranteed to be a mountain
 * return i where arr[i-1] < arr[i] > arr[i+1]
 */
package Patterns.BinarySearch.Easy;
public class PeakIndexMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        //return i where arr[i-1] < arr[i] > arr[i+1]
        // Binary Search
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if(arr[mid]<arr[mid+1]){//acsending, 上升期
                l = mid+1;//go to right half 
            }else{
                r = mid;//mid may be the peak or at the descending part
                // 可能在peak，也可能下降，所以左半部分，将mid包含
            }
        }
        return l;
    }
}
