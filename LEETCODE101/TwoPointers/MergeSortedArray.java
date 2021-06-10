package TwoPointers;

/**
 * Question 88. Merge two Sorted Array【E】 You are given two integer
 * arrays nums1 and nums2, sorted in non-decreasing order, and two
 * integers m and n, representing the number of elements
 * in nums1 and nums2 respectively. Merge nums1 and nums2 into a single array
 * sorted in non-decreasing order. The final sorted array should not be returned
 * by the function, but instead be stored inside the array nums1. To accommodate
 * this, nums1 has a length of m + n, where the first m elements denote the
 * elements that should be merged, and the last n elements are set to 0 and
 * should be ignored. nums2 has a length of n.
 */
/*
 * Solution: use two pointers for two arrays. And another pointer points to the
 * position to be filled up. nums1 add n spaces for nums2 and filled up with 0.
 * we use pointers start from end, because the end of the array is empty. Every
 * time, we compare the elements two pointers point to, copy the larger one to
 * the end of the nums1, and move the third pointer one step to the left.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // use pointer i for nums1 and starts from the end
        int i = m - 1;
        // use pointer j for nums2 and starts from the end
        int j = n - 1;
        // use pointer p points to the position to be filled up in nums1
        int p = m + n - 1;
        while (i >= 0 && j >= 0) {
            // compare the elements in two arrays
            // put the larger one in the position p
            if (nums1[i] > nums2[j]) {
                // p--: decrease p, the return value is still p
                // --p: decrease p, the return value is p-1
                nums1[p--] = nums1[i--];
            } else {
                nums1[p--] = nums2[j--];
            }
        }
        // if nums2 still has elements, copy the left elements into nums1
        while (j >= 0) {
            nums1[p--] = nums2[j--];
        }
    }
}
