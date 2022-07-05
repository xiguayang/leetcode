package Leetcodes.Blind75.Tree.Easy.Recursion;



public class SubTree {
    public boolean isSubTree(TreeNode root, TreeNode sub){
        if(root ==null) return false;
        if(isSameTree(root.left, sub) || isSameTree(root.right, sub)){
            return true;
        }else{
            return isSubTree(root.left, sub) || isSubTree(root.right, sub);
        }
        
    }

    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return true;
        }
        if(root1.val!=root2.val) return false;
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
    
}
