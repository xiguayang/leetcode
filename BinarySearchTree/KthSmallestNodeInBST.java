package BinarySearchTree;

import java.util.LinkedList;

/**# 230 find the kth smallest element in BST[M]
 * Given the root of a binary search tree, and an integer k,
 * return the kth (1-indexed) smallest element in the tree
 * example:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 * Constraints:
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 *
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations)
 * and you need to find the kth smallest frequently, how would you optimize?
 *
 *    //===========> if we know the ranking of the current node is m, we could compare m with k:
 *     //              if m == k , it's the kth element
 *     //              if m > k, k is in the left subtree, go to the left subtree to search kth element
 *     //              if m < k, k is in the right subtree, go to the right subtree to search (k-m-1 )th element
 *     //====> the time complicity should be O(logN)
 *     //??????????How to get the ranking of each node? we need add more information of each node
 *     //===========> add int size in the TreeNode definition: records the total number of nodes of the tree whose root is this node
 *
 */


public class KthSmallestNodeInBST {
    /* ===>Approach 1: Recursive Inorder Traversal
    * inorder the BST, 得到升序排列的结果， 找到第K个值
    * inorder the BST, get the increasing traversal of all element
    * record the rank of each node, when it equals to k, return it
    * Complexity Analysis
    * Time complexity : O(N) to build a traversal.
    * Space complexity :O(N) to keep an inorder traversal.*/
    //use to record the smallest element
    int result = 0;
    //use to record the rank of the node
    int rank = 0;

    public int kthSmallest(TreeNode root, int k) {
        //use the inorder traverse to record
        traverse(root, k);
        return result;
    }

    public void traverse(TreeNode root, int k){
        if(root == null) return;

        traverse(root.left, k);
        /*** inorder traversal code**/
        rank++;
        if(k==rank){
            result = root.val;
            return;
        }
        /***********/
        traverse(root.right,k);
    }


    /**Approach 2: Iterative Inorder Traversal.
     * The above recursion could be converted into iteration,
     * with the help of stack.
     * This way one could speed up the solution
     * because there is no need to build the entire inorder traversal,
     * and one could stop after the kth element.
     */
    public int kthSmallest2(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }



}
