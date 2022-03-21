package TreeTop100;

import apple.laf.JRSUIUtils;

/**108. Convert Sorted Array to Binary Search Tree[E]
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 * A height-balanced binary tree is a binary tree in
 * which the depth of the two subtrees of every node never differs by more than one
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 *
 * BST: inordertraversal ==> get a sorted array, 反之
 * so the array could spit into two part, the left part all < mid, right part > mid*/
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length ==0){return null;}
        return buildHelper(nums,0,nums.length-1);
    }
    public TreeNode buildHelper(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (lo + hi)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildHelper(nums,lo,mid-1);
        root.right = buildHelper(nums,mid+1,hi);
        return root;
    }
}
