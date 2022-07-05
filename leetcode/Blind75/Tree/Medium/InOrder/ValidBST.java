package Leetcodes.Blind75.Tree.Medium.InOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidBST {
    //Recursion: DFS O(n)
    public boolean isValidBST(TreeNode root){
        return isValidBSTRecursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTRecursion(TreeNode root, long minValue, long maxValue) {
        if(root==null) return true;
        return isValidBSTRecursion(root.left, minValue,root.val) && isValidBSTRecursion(root.right, minValue, maxValue);
    }

    //interactive traversal: Inorder Traversal structure to check if a valid bst
    TreeNode min = null;
    public boolean isValidBSTInOrder(TreeNode root){
        if(root==null) return true;
        Stack<TreeNode> stack= new Stack<>();
        TreeNode preNode = null;
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.add(root);
                root=root.left;
            }
            root=stack.pop();
            //pre is the leftnode of the root, or the root of current node
            if(preNode!=null && root.val<=preNode.val) return false;
            preNode=root;
            root=root.right;
        }
        return true;
    }

    
    public List<Integer> inOrderIteractiveTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack<>();
        //1. root == null: the current subtree is null, go to stack to find the parent node
        //2. stack ==null: go to traversal the current subtree(right of parent)
        //3. root and stack are both null: end the traversal
        while(root != null || !stack.empty()){
            //find the mostleft node
            //after while loop: adding the nodes from root to leftmost node into the stack
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            //root now is the leftmost node
            root = stack.pop();
            //add root val into list
            list.add(root.val);
            //since there's no left node
            //go to right node
            root = root.right;
        }
        return list;
    }


}
