package TreeTop100;

import java.util.LinkedList;
import java.util.List;

/**94. Binary Tree Inorder Traversal[E]

 Given the root of a binary tree, return the inorder traversal of its nodes' values.

 */
public class InorderTraversal {
    private List<Integer> result = new LinkedList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        //inorder: left root right
        if(root == null) {
            return result;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }
}
