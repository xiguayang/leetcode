package Tree;

import Tree.TreeNode;

/**#116 Flatten BT to a linked list[M]
Given the root of a BT, the return linked list s
hould use the same TreeNode class w
here the right child pointer pointes to the next node in the list
and the left child pointer is always null.
And it should be in the same order
as a preorder traversal of the binary tree.

Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
*/
public class FlattenToLL{

  public void flatten(TreeNode root) {
    //base case
    if(root == null){
      return;
    }
    //1. flat the left treenode of the root to linked list
    flatten(root.left);
    TreeNode leftTree = root.left;
    //2. flat the right treenode of the root to linked list
    flatten(root.right);
    TreeNode rightTree = root.right;

    //3. make the whole leftTree as the root's right
    root.left = null;
    root.right = leftTree;

    //4. right flaten tree connect to the root's right tree's end
    //use a temp treenode pointer to get the end
    TreeNode p = root;
    while(p.right!=null){
      p = p.right;
    }
    p.right = rightTree;

  }

}
