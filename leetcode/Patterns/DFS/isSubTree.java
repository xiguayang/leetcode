/**572 SubTree of another tree
 * Tree Traverse Recursion */
package Patterns.DFS;

import java.util.*;

import Patterns.TreeNode;
public class isSubTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //DO not forget this case, root is null
        if(root==null) return false;
        if(isSameTree(root,subRoot)){
            return true;
        }else{
            return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        }
        
    }
    private boolean isSameTree(TreeNode t1, TreeNode t2){
        if(t1==null && t2 ==null) return true;
        if(t1 ==null || t2==null) return false;
        if(t1.val == t2.val) {
            return isSameTree(t1.left,t2.left) && isSameTree(t1.right,t2.right);
        }else{
            return false;
        }
        
    }
}
