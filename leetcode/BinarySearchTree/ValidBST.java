package BinarySearchTree;
/**
 * 98. Validate Binary Search Tree【M】
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * root.val not only > root.left.val, but should > all left nodes
 * root.val not only < root.right.val, but should < all right nodes
 * every root could see its left and right values only, how to pass the control of all left and right nodes?
 * ====> add 2 more arguments in the method:
 *          min records the minimum value of right and max records maximum value of left
 *
 * */
public class ValidBST {
    public boolean isValidBST(TreeNode root){

       return isValidBST(root, null, null);
    }
    // so the root must : min.val< root.val < max.val
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
        //base case
        if(root == null) return true;
        if(min !=null && root.val<=min.val) return false;
        if(max !=null && root.val>=max.val) return false;
        //To left subtree, its max is root; To right subtree, its min is root
        return isValidBST(root.left, min, root) && isValidBST(root.right,root,max);

    }
}
