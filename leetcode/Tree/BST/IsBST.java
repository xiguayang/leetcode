package Tree.BST;
import java.util.ArrayList;
import java.util.*;

import Tree.TreeNode;

//Q98 check if the given BT a valid BST
//solution: inordertravel, if sorted, it is a BST
public class IsBST {
    // Method 1: Inorder Traver get a ArrayList, chech if the arraylist is sorted
    List<Integer> list = new ArrayList<Integer>();

    public boolean isValidBSTByInOrder(TreeNode root) {
        inOrder(root);
        return isSorted(list);
    }
    private boolean isSorted(List<Integer> list)
    {
        boolean sorted = true;        
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1).compareTo(list.get(i)) > 0) sorted = false;
        }
        return sorted;
    }
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    // Method 2: Inorder Traversal Structure DFS
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

    public boolean isValidBSTInOrderStructure(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val)
                return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    // Method 3: Recursion Method;
    TreeNode min = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST(root.left))
            return false;
        if (min != null && root.val < min.val)
            return false;
        min = root;

        if (!isValidBST(root.right))
            return false;

        return true;
    }

    //DFS
    public boolean isValidBSTDFS(TreeNode root){
        return isValidBSTDFS(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBSTDFS(TreeNode root, long minValue, long maxValue) {
        if(root==null) return true;
        if(root.val>= maxValue || root.val<minValue) return false;

        return isValidBSTDFS(root.left,minValue,root.val) && isValidBSTDFS(root.right,root.val,maxValue);
    }
}
