package Leetcodes.Blind75.Tree.Easy.Recursion;

public class DiameterOfTree {
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        //for each root node: diameter is maxDepth(root.left)+maxDepth(root.right);
        maxDepth(root);
        return maxDiameter;
    }
    public int maxDepth(TreeNode root){
        if(root ==null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        maxDiameter = Math.max(maxDiameter, leftDepth+rightDepth);
        return Math.max(leftDepth,rightDepth)+1;
    }
}
