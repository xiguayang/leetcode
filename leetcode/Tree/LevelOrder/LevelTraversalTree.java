package Tree.LevelOrder;

import java.util.LinkedList;
import java.util.Queue;

import Tree.TreeNode;

public class LevelTraversalTree{
    void traverse(TreeNode root){
       if(root == null) return;
       //initalization queue, add the root into the queue
       Queue<TreeNode> q = new LinkedList<>();
       q.offer(root);

       while(!q.isEmpty()){
          //poll(): retreive and remove the head of the queue, return null if queue is empty
          TreeNode cur = q.poll();

          /*****level traverse code********/
          System.out.println (cur.val);
          /*******************************/

          // not record null, but in serialization: we need null
          if(cur.left !=null){
            q.offer(cur.left);
          }
          if(cur.right !=null){
            q.offer(cur.right);
          }

       }
    }

    String SEPERATE = ",";
    String NULL = "#";
    public String serialize(TreeNode root){
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        //初始化队伍， 将root加入Queue
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
          TreeNode cur = q.poll();

          if(cur == null){
            sb.append(NULL).append(SEPERATE);
            continue;
          }
          sb.append(cur.val).append(SEPERATE);

          q.offer(cur.left);
          q.offer(cur.right);
        }
        return sb.toString();












    }
}
