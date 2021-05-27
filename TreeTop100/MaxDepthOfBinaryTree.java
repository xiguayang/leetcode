package TreeTop100;

import apple.laf.JRSUIUtils;

/**104. Maximum Depth of Binary Tree[E]
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes
 * along the longest path from the root node down to the farthest leaf node.
 * */
public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;

    }
}
