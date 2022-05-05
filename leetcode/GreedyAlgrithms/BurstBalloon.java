package GreedyAlgrithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. Minimum Number of Arrows to Burst Balloons[M] There are some spherical
 * balloons spread in two-dimensional space. For each balloon, provided input is
 * the start and end coordinates of the horizontal diameter. Since it's
 * horizontal, y-coordinates don't matter, and hence the x-coordinates of start
 * and end of the diameter suffice. The start is always smaller than the end. An
 * arrow can be shot up exactly vertically from different points along the
 * x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart
 * ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An
 * arrow once shot keeps traveling up infinitely. Given an array points where
 * points[i] = [xstart, xend], return the minimum number of arrows that must be
 * shot to burst all balloons.
 * 
 */
public class BurstBalloon {
    // Solution: similar with Question435 NonOverLapIntervals
    // count the positions of balloon which are not overlapped, it's the number of
    // arrows needed
    // the differences is for the start and end of each position interval, they are
    // overlapped if they are same
    public static int findMinArrowShots(int[][] points) {
        // 1. Sort the array
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                // use compare instead of a[1]-b[1]
                return Integer.compare(a[1], b[1]);
            }
        });
        // 2. count the points intervals which are not overlapped
        int count = 1;
        int x_end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > x_end) {
                count = count + 1;
                x_end = points[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } };
        int x = findMinArrowShots(arr);
        System.out.println(x);

    }

}
