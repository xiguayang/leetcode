package GreedyAlgrithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Question 435. Non-overlapping Intervals【M】 Given an array of
 * intervals intervals where intervals[i] = [starti, endi], return the minimum
 * number of intervals you need to remove to make the rest of the intervals
 * non-overlapping. Input: [[1,2], [2,4], [1,3]] Output: 1 Explanation: remove
 * [1, 3 ], remaining intervals are non-overlapping Solution: Remaining most
 * non-overlapping intervals, for each interval, the end of it is smaller, the
 * remaining space for other intervals is more. 优先保留结尾小且不相交的区间。 (1)sort
 * intervals by the end of each interval [1,2],[1,3],[2,4] (2)select the
 * interval with smallest end and with no overlaps with previous interval
 */
public class NonOverlapIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        // (1)sort intervals by the end of each interval
        // Arrays.sort(intervals, new Comparator<int[]>() {
        // public int compare(int[] a, int[] b) {
        // return a[1] - b[1];
        // }
        // });
        // self quick sort method:
        quickSortIntervalsByEnd(intervals, 0, intervals.length - 1);

        // (2)select the interval with smallest end and with no overlaps with previous
        // interval
        int eraseNum = 0;
        // int remain = 0;
        int x_end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < x_end) {
                eraseNum = eraseNum + 1;
            } else {
                x_end = intervals[i][1];
            }
        }
        return eraseNum;
    }

    // A utility function to swap two elements
    public static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * This function takes last element as pivot, places the pivot element at its
     * correct position in sorted array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right of pivot
     */
    public static int partition(int[][] arr, int low, int high) {

        // pivot
        int pivot = arr[high][1];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j][1] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /*
     * The main function that implements QuickSort arr[] --> Array to be sorted, low
     * --> Starting index, high --> Ending index
     */
    public static void quickSortIntervalsByEnd(int[][] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSortIntervalsByEnd(arr, low, pi - 1);
            quickSortIntervalsByEnd(arr, pi + 1, high);
        }
    }
    // { { 1, 2 }, { 2, 4 }, { 1, 3 }, { 2, 2 } }
    // arr[0]= {1,2}

    public static void main(String[] args) {
        int[][] arr = new int[][] { { 1, 2 }, { 2, 3 }, { 1, 3 }, { 3, 4 } };
        int re = eraseOverlapIntervals(arr);
        System.out.println(re);
    }

}
