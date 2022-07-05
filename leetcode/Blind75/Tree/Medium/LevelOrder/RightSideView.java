package Leetcodes.Blind75.Tree.Medium.LevelOrder;

import java.util.ArrayList;
import java.util.List;

import Leetcodes.Blind75.Tree.Medium.InOrder.TreeNode;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        //recursion
        List<Integer> res = new ArrayList<>();
        rightSideViewHelper(res, root, 0);
        return res;
    }
    private void rightSideViewHelper(List<Integer>res, TreeNode cur, int level){
        if(cur ==null) return;
        if(res.size()==level){
            res.add(cur.val);
        }

        rightSideViewHelper(res, cur.right, level+1);
        rightSideViewHelper(res, cur.left, level+1);
    }
}
