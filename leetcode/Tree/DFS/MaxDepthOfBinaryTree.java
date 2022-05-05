package Tree.DFS;

import Tree.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree[E]
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes
 * along the longest path from the root node down to the farthest leaf node.
 */
public class MaxDepthOfBinaryTree {
    // method 1: DFS
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }

    // method 2: Traversal the tree and record the depth
    // record the depth of the current node
    int depth = 0;
    // record the maximum depth
    int res = 0;

    public int maxDepthByTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            // root == null ===> arrive the sub leaf, update the maxiumn depth
            res = Math.max(res, depth);
            return;
        }
        depth++;
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
