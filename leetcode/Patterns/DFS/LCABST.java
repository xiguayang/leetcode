package Patterns.DFS;

import java.util.*;

import Patterns.TreeNode;
public class LCABST {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Recursion O(n)
        //Traversal the tree
        //the first node n: p<=n <= q (p<q), n is the LCA
        //else: n < p < q, LCA is at n.right n==>n.right
        //else: n> q > p, LCA is at n.left n==>n.left
        
        // cleaner code:
        
        if(root.val<q.val && root.val<p.val){
            return lowestCommonAncestor(root.right,p,q);
        }else if(root.val> p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
            
        }else{
            return root;
        }
    }

    //Interactive
    //Time O(h) Space o(1)
    public TreeNode lowestCommonAncestorIteractive(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val)
                root = root.left;
            else if (root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
        
    }
}
