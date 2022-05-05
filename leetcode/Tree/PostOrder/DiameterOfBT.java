package Tree.PostOrder;

import Tree.TreeNode;

// diameter: the length of the longest path between 2 nodes in a tree
// ==> max depth of left subTree + max depth of right subTree is kind of diameter of each node
public class DiameterOfBT {
    int maxDiameter = 0;

    public int diameterOfBT(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // post position
        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(myDiameter, maxDiameter);

        return 1 + Math.max(leftMax, rightMax);
    }

}
