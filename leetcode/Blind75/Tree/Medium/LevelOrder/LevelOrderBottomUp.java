package Leetcodes.Blind75.Tree.Medium.LevelOrder;

import java.util.ArrayList;
import java.util.List;

import Leetcodes.Blind75.Tree.Medium.InOrder.TreeNode;

public class LevelOrderBottomUp {
    public List<List<Integer>> levelOrderBottomUpRecursion(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelOrderBottomUpRecursionHelper(res,root,0);
        return res;
    }

    private void levelOrderBottomUpRecursionHelper(List<List<Integer>> res, TreeNode root, int level) {
        if(root==null) return;
        //when starts a new level
        //adding the subList from start of res;
        if(res.size()==level){
            List<Integer> subList = new ArrayList<>();
            res.add(0,subList);
        }
        res.get(res.size()-level-1).add(root.val);
        levelOrderBottomUpRecursionHelper(res, root.left,level+1);
        levelOrderBottomUpRecursionHelper(res, root.right,level+1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(0,1);
        test.add(0,2);
        test.add(0,3);
        System.out.println(test.toString());
    }
}
