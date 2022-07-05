package Leetcodes.Blind75.Tree.Medium.LevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Leetcodes.Blind75.Tree.Medium.InOrder.TreeNode;

public class LevelOrder {
    //Method1: DFS
    // Using a helper function to record result and level number
    public List<List<Integer>> levelOrderRecursion(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        levelOrderRecursionHelper(results, root, 0);
        return results;
    }

    private void levelOrderRecursionHelper(List<List<Integer>> results, TreeNode root, int level) {
        if(root==null) return;
        
        //for root, level is 0, results size is 0;
        // each time for a new level, adding a new arraylist into the results
        if(results.size()==level){
            results.add(new ArrayList<>());
        }
        //add the node into the level arraylist
        results.get(level).add(root.val);

        //for next level
        level++;
        levelOrderRecursionHelper(results, root.left, level);
        levelOrderRecursionHelper(results, root.right, level);

    }

    //Method2: Interactive BFS using queue to store nodes of level
    public List<List<Integer>> levelOrderInteractive(TreeNode root) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if(root==null) return results;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode cur = queue.peek();
                if(cur.left !=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
                subList.add(queue.poll().val);
            }
            results.add(subList);

        }
        return results;
    }
    
}
    
