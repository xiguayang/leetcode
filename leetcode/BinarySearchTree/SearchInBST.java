package BinarySearchTree;
/**700. Search in a Binary Search Tree[E]
 You are given the root of a binary search tree (BST) and an integer val.
 Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 If such a node does not exist, return null.
 */
public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int target){
        //base case can't find the given val in the tree
        if(root == null) return null;
        //root's value equals target
        if(root.val == target) {
            return root;
            //the target is in the leftsubtree
        }else if(root.val >target){
            return searchBST(root.left,target);
            //the target is in the rightsubtree
        }else {
            return searchBST(root.right,target);
        }


    }
}
