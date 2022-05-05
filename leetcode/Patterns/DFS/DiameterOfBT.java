/**543 Diameter of BT: the length of the longest path between any 2 nodes in a tree, may or may not pass through the root */
package Patterns.DFS;

import java.util.*;

import Patterns.TreeNode;
public class DiameterOfBT {
    // for every node, the diameter pass it is the max depth of its left node + max depth of its right node
    //int maxDiameter = 0;
    //This method has repeated calculating the depth 
    public int diameterOfBinaryTree(TreeNode root){
        if(root == null){
            return 0;
        }
        //dia of the root 
        int diameter = maxDepth(root.left)+maxDepth(root.right);
        // dia of the left tree
        int leftDiameter = diameterOfBinaryTree(root.left);
        //dia of the right tree
        int rightDiameter = diameterOfBinaryTree(root.right);
        return Math.max(diameter,Math.max(rightDiameter, leftDiameter));
        
    }
    //get the max depth of the node
    private int maxDepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    // Correct: 
    int maxDiameter = 0;
    public int diameterOfBinaryTree2(TreeNode root) {
        maxDepth2(root);
        return maxDiameter;
    }
    private int maxDepth2(TreeNode root){
        if(root==null) return 0;
        int leftMaxDepth = maxDepth2(root.left);
        int rightMaxDepth = maxDepth2(root.right);
        int myDiameter = leftMaxDepth + rightMaxDepth;
        maxDiameter = Math.max(maxDiameter, myDiameter);
        
        return Math.max(leftMaxDepth, rightMaxDepth)+1;
    }
}
