package Tree.LevelOrder;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Tree.TreeNode;

/**515. Find Largest Value in Each Tree Row[M]
 Given the root of a binary tree,
 return an array of the largest value in each row of the tree (0-indexed).*/
public class LargestValueEachLevel {
    public List<Integer> largestValuesDFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverseMaxbyLevel(res, root, 0);
        return res;
    }
    public void traverseMaxbyLevel(List<Integer>res, TreeNode node, int level){
        if(node == null){
            return;
        }
        if(res.size()==level)
            res.add(node.val);

        if(node.val>res.get(level))
            res.set(level,node.val);

        traverseMaxbyLevel(res, node.left,level + 1);
        traverseMaxbyLevel(res, node.right,level + 1);
    }

    public List<Integer> largestValuesBFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.val> max){
                    max = node.val;
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(max);
        }
        return res;

    }

}
