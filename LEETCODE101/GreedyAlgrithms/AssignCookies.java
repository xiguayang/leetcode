package GreedyAlgrithms;

import java.util.Arrays;

/**
 * #455 [E] Assume you are an awesome parent and want to give your children some
 * cookies. But, you should give each child at most one cookie. Each child i has
 * a greed factor g[i], which is the minimum size of a cookie that the child
 * will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we
 * can assign the cookie j to the child i, and the child i will be content. Your
 * goal is to maximize the number of your content children and output the
 * maximum number.
 * 一组孩子和一组饼干，每个孩子有一个饥饿度，每个饼干有一个大小，每个孩子只能吃一个饼干，且只有饼干的大小不小于孩子的饥饿度时孩子才能吃饱，求解最多多少孩子能吃饱。
 * INPUT: [1,2], [1,2,3] OUTPUT: 2 EXPLANATION:
 * 可以喂【1，2】，【1，3】，【2，3】三种组合，最多两个孩子能吃饱 Solution: child with the smallest greed
 * factor is the easiest to be satisfied, we consider this child firstly. To
 * leave more cookies to satisfy other children, we assign the smallest cookie
 * which is larger or equal to the smallest greedy factor to the child. After
 * satisfy this child, we consider other children by Step 1,2 ==> key:
 * 给剩余孩子里最小饥饿度的孩子分配最小的能饱腹的饼干 Sort the children’s greedy factor and size of
 * cookies firstly, starts from the smallest element of each array. Sorting is
 * array or string is the common operation for comparisons
 */

public class AssignCookies {
    public static int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);
        int child = 0;
        int cookie = 0;
        while (child < children.length && cookie < cookies.length) {
            if (children[child] <= cookies[cookie]) {
                child = child + 1;
            }
            cookie = cookie + 1;
        }

        return child;
    }

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * This function takes last element as pivot, places the pivot element at its
     * correct position in sorted array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right of pivot
     */
    static int partition(int[] arr, int low, int high) {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

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
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] g = new int[] { 1, 2 };
        int[] s = new int[] { 1, 2, 3 };
        int r = findContentChildren(g, s);
        System.out.println(r);
    }

}
