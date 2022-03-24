import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;
/**104 */
public class MaximumDepth {
    //Method 1 Recursion
    public int maxDepth(TreeNode root) {
        //Recursion
        if(root ==null) return 0;
        //if(root.left ==null && root.right ==null ) return 1;
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    //Method2 Iteraction BFS:  by level
    public int maxDepthIteractive(TreeNode root){
        if(root ==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- >0){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            //every level not empty, level++ 
            count++;
        }
        return count;
        
    }
}
