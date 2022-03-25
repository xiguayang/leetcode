import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * 111 Minimum Depth of Binary Tree
 * Shortest path from root to leaf
 * leaf==>node.left && node.right ==null
 */
public class MinDepthBT {
    //BST: level traversal
    //1. Using a Queue to store nodes in one level
    //2. for each node in one level, check if it is a leaf
    //3. if it is a leaf, return the level num
    //4. if it is not a leaf, add its left/right child into the queue
    //5. after traversing the level queue, increase the level number
    
    public int minDepth(TreeNode root) {
        //edge case
        if(root == null) return 0;
        // initial 
        Queue <TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while(!q.isEmpty()){
            //traverse all node in the level
            int size = q.size();
            for(int i =0;i<size;i++){
                //poll each node of the level
                TreeNode node = q.poll();
                //check if the node is a leaf
                if(node.left == null && node.right ==null){
                    return level;
                }
                //the node is not leaf,adding its children into the queue
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            //after traverse the level 
            level++;
        }
        return level;

    }
    

        // DFS: recursion
    // DFS: recursion
    public int minDepthDFS(TreeNode root) {
        if(root==null){
            return 0;
        }
       // if(root.left==null&&root.right==null){
         //   return 1;
        //}
        if(root.left==null){
            return minDepthDFS(root.right)+1;
        }
        if(root.right==null){
            return minDepthDFS(root.left)+1;
        }
        return Math.min(minDepthDFS(root.left),minDepthDFS(root.right))+1;
    }

}
