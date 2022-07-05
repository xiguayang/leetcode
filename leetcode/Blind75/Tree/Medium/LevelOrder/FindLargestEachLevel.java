package Leetcodes.Blind75.Tree.Medium.LevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Leetcodes.Blind75.Tree.Medium.InOrder.TreeNode;

public class FindLargestEachLevel {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if(cur.val>max){
                    max = cur.val;
                }
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
