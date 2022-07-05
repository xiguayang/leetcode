package Leetcodes.Blind75.Tree.Medium.LevelOrder;

import java.util.ArrayList;
import java.util.List;

import Leetcodes.Blind75.Tree.Medium.InOrder.TreeNode;

public class LevelOrderZigZag {
    public List<List<Integer>> levelOrderZigZagRecursion(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelOrderZigZagRecursionHelper(res,root,0);
        return res;
    }

    private void levelOrderZigZagRecursionHelper(List<List<Integer>> res, TreeNode root, int level) {
        if(root==null) return;
        //when starts a new level
        //adding the subList from start of res;
        if(res.size()==level){
            List<Integer> subList = new ArrayList<>();
            res.add(0,subList);
        }
        if(level%2 ==0){
            res.get(level).add(root.val);
        }else{
            res.get(level).add(0,root.val);
        }

        levelOrderZigZagRecursionHelper(res, root.left,level+1);
        levelOrderZigZagRecursionHelper(res, root.right,level+1);
    }
}
