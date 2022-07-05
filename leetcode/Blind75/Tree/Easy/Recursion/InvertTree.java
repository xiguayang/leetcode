package Leetcodes.Blind75.Tree.Easy.Recursion;


//Invert a tree
//Recursion invert its left and right sub trees
public class InvertTree {
    public TreeNode invertTree(TreeNode root){
        if(root == null || (root.left == null && root.right ==null)) return root;
        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }
    
}
