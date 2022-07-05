package Leetcodes.Blind75.Tree.Easy.Recursion;


public class LCAofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //p, and q, p/q >=root && q/p<=root
        if((root.val>=p.val && root.val<=q.val)||(root.val<=p.val && root.val>=q.val)){
            return root;
        }
        //p,q both less than root
        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            //p,q both larger than root
            return lowestCommonAncestor(root.right, p, q);
        }
    }
    public TreeNode lowestCommonAncestorIteractive(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(p.val<root.val && q.val<root.val){
                root=root.left;
            }else if(p.val>root.val && q.val>root.val){
                root=root.right;
            }else{
                return root;
            }
        }
    }
}
