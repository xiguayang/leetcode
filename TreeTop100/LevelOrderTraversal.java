package TreeTop100;

import apple.laf.JRSUIUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A compilation of some level order traversal questions.

    Binary Tree Level Order Traversal
    Binary Tree Level Order Traversal II
    Binary Tree Zigzag Level Order Traversal
    Average of Levels in Binary Tree
    Binary Tree Right Side View
    Find Largest Value in Each Tree Row
    Populating Next Right Pointers in Each Node


 *  102. Binary Tree Level Order Traversal [M]
 *  Given the root of a binary tree,
 *  return the level order traversal of its nodes' values. (i.e., from left to right, level by level)
 *
 *  for root, get the root.left and root.right, they are in one level
 *  but for root.left, root.left.left, root.left.right, root.right.left root.right .right, they are in one level.
 *  so for each level, we have to know the uplevel and get the left and right nodes of each nodes in the uplevel
 *  */
public class LevelOrderTraversal {
    /**Approach 1: Recursively DFS(深度优先搜索)
     *          1. nodes in the same level group into one array;
     *          2. add level as argument in helper method
     *          Time: O(N)
     *          Space: O(N)*/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        traverseLevelOrder(result,root,0);
        return result;
    }
    /*A helper method**/
    public void traverseLevelOrder(List<List<Integer>> result, TreeNode root, int level){
        if(root == null){
            return;
        }
        //for root, level is 0; now result is empty, result.size()==0
        //so add the first arraylist in result, inside it is the value of root

        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        //next level: level+1; for left of the root, level is 1 and the result.size() is 1 too,
        // for level 1 add an arraylist to record all nodes in this level

        traverseLevelOrder(result,root.left,level+1);
        traverseLevelOrder(result,root.right,level+1);
    }


    /**Approach 2: Use Queue as helper structure when we have level order traversal BFS(广度优先搜索)
     * after we pop the current level's root, add next level's roots(Queue: FIFO)
     * 1. add root into the queue
     * 2. remove root from the queue
     * 3. if root.left != null, put root.left into the queue
     * 4. if root.right !=null, put root.right into the queue
     * */
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //Queue<TreeNode> queue = new LinkedList<>();
        //put the root into the queue and traverse the queue continually
        queue.add(root);
        while (!queue.isEmpty()) {
            //get the size of current queue, its the number of nodes in current level
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            //get all the nodes from the queue into temperate list
            //if the node's left and right tree is not empty, put it into the queue
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                //TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }





}
