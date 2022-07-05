package Leetcodes.Blind75.Tree.Easy.Recursion;


public class SameTree {
    // Recursion DFS: O(P+Q)
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q ==null) return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
