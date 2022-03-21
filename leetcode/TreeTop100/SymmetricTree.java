package TreeTop100;

import Tree.PopulatingNextRightPointer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    public boolean isMirror(TreeNode n1, TreeNode n2){

        if(n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null) return false;
        return (n1.val == n2.val)&& isMirror(n1.right,n2.left) && isMirror(n1.left, n2.right);
    }


}
