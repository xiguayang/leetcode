package Leetcodes.Blind75.Tree.Medium.LevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Leetcodes.Blind75.Tree.Medium.InOrder.TreeNode;

public class AverageLevelsBT {
    public List<Double> averageOfLevels(TreeNode root) {
        //List<Double> result = new ArrayList<Double>();       
        List < Integer > count = new ArrayList < > ();
        List <Double> sum = new ArrayList < > ();
        traversalByLevel( root,0, count, sum);
        for(int i = 0; i<sum.size();i++){
            //result.add(i,(Double)(sum.get(i)/count.get(i)));
            sum.set(i,(Double)(sum.get(i)/count.get(i)));
        }
        return sum;
    }
    public void traversalByLevel(TreeNode root, int level, List < Integer > count, List < Double > sum){
        if(root == null){
            return;
        }
        //count nodes in each level
        //if start a new level
        if(sum.size() == level){
            sum.add((double) root.val);
            count.add(1);
        }else{
            //move back to previous level and count other nodes in the level
            sum.set(level, sum.get(level)+root.val);
            count.set(level, count.get(level)+ 1);
        }
        traversalByLevel(root.left,level+1,count, sum);
        traversalByLevel(root.right,level+1, count, sum);
    }


    public List<Double> averageOfLevelsBFS(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            double sum=0;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                sum = sum+node.val;
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            res.add(sum/size);
        }
        return res;
    }
}
