package TreeTop100;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**637. Average of Levels in Binary Tree[E]
 * Given the root of a binary tree,
 * return the average value of the nodes on each level in the form of an array.
 * Answers within 10-5 of the actual answer will be accepted.
 * Example:
 * Input: root = [3,9,20,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].*/
public class AverageLevels {
    //Approach 1: DFS O(n), O(h)
    public List<Double> averageOfLevels(TreeNode root) {
        //List<Double> result = new ArrayList<Double>();
        List < Integer > count = new ArrayList < > ();
        List <Double> sum = new ArrayList < > ();
        traversalByLevel( root,0, count, sum);
        for(int i = 0; i<sum.size();i++){
            sum.set(i,(Double)(sum.get(i)/count.get(i)));
            //result.add(i,(Double)(sum.get(i)/count.get(i)));
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


    /*Approach 2: BFS: In BFS, we start by pushing the root node into a queue.
    Then, we remove an element(node) from the front of the queue.
     For every node removed from the queue, we add all its children to the back of the same queue.
      We keep on continuing this process till the queue becomes empty.
    In this way, we can traverse the given tree on a level-by-level basis.
    1. Put the root node into the queue.
    2. Initialize sum as 0. Queue.size is actually the number of nodes in each level
    3. Pop a node from the front of the queue. Add this node's value to the sum corresponding to the current level.
    4. Put the children nodes of the node last popped into the queue.
    5. Add the average of the level into result: sum/size.
    6. Continue steps 2 and 5 till queue becomes empty. .

*/
    public List<Double> averageOfLevelsBFS(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        double sum = 0;
        while(!queue.isEmpty()){
            //get the size of current queue, its the number of nodes in current level
            int size = queue.size();
            //get all the nodes from the queue, add their values to sum
            //if the node's left and right tree is not empty, put it into the queue
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                sum = sum + node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(sum/size);
            sum = 0;
        }
        return result;
    }

}
