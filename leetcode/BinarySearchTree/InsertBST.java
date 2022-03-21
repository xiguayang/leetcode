package BinarySearchTree;
/**701. Insert into a Binary Search Tree[M]
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 * Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.
 * Notice that there may exist multiple valid ways for the insertion,
 * as long as the tree remains a BST after insertion.
 * You can return any of them.
 * Example;
 * INPUT: root= [4,2,7,1,3], val = 5
 *      4                          4                    5
 *     / \                        /  \                 / \
 *    2   7             ==>      2    7      or       2   7
 *   / \                        / \  /               / \
 *  1   3                      1  3 5               1   3
 *                                                       \
 *                                                        4
 *
 * 遍历： =》 找
 * 访问： =》 改
 * 插入： =》 找到位置，改
 * */
public class InsertBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //base case
        if(root == null)
            return new TreeNode(val);
        //val < root.val , insert into the left subtree
        if(root.val > val){
            root.left = insertIntoBST(root.left,val);
            //val > root.val , insert into the right subtree
        }else if(root.val <val){
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
}
