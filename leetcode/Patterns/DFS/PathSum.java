package Patterns.DFS;

import java.util.*;

import Patterns.TreeNode;

/**
 * 112 PathSum: has a path(from root to leaf) sums up to target
 */

public class PathSum {

    //Method 1: Recursion PreOrder O(N)
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        //base case1: root is null
        if(root ==null) return false;
        //base case2: root arrives at leaf point
        if(root.left ==null && root.right ==null && root.val == targetSum){
            return true;
        }
        return (hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right,targetSum-root.val));

    }
    //Method 2: Interactive using Stack DFS
    public boolean hasPathSumStack(TreeNode root, int targetSum){
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();

        stack.push(root);
        sums.push(targetSum);
        while(!stack.isEmpty() && root!=null){
            int val = sums.pop();
            TreeNode node = stack.pop();
            //base case: if node is now the leaf
            if(node.left ==null && node.right ==null && node.val == val){
                return true;
            }
            if(node.left!=null){
                stack.push(node.left);
                sums.push(val-node.val);
            }
            if(node.right !=null){
                stack.push(node.right);
                sums.push(val-node.val);
            }
        }
        return false;
    }

    

}
