package Patterns.DFS;

import Patterns.TreeNode;

public class invertBT {
    public TreeNode invertTree(TreeNode root) {
        if(root==null ) return root;
        if(root.left ==null && root.right ==null){
            return root;
        }
        // if(root.left == null){
        //     root.left = invertTree(root.right);
        //     root.right = null;
        // }else if(root.right ==null){
        //     root.right = invertTree(root.left);
        //     root.left = null;
        // }else{
            TreeNode temp = root.right;
            root.right = invertTree(root.left);
            root.left = invertTree(temp);
        // }
        return root;
    }
}
