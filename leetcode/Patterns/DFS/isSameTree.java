package Patterns.DFS;

import java.util.*;

import Patterns.TreeNode;
/**100 isSameTree */
public class isSameTree {
    //Method1:Time: O(N) Space: O(logN)in the best case of completely balanced tree 
    //and O(N) in the worst case of completely unbalanced tree, to keep a recursion stack. 
    public boolean isSameTreeRecursion(TreeNode p, TreeNode q) {
        if(p==null && q== null){
            return true;
        }
        if(p==null || q== null){
            return false;
        }
        if(p.val==q.val){
            return isSameTreeQueue(p.left,q.left) && isSameTreeQueue(p.right,q.right);
        }else{
            return false;
        }
    }
    //DFS: Stack process for Recursion
   
    //Method 2: Iteration, BFS using Queue
    //Time & Space same with DFS RECURSION
    public boolean isSameTreeQueue(TreeNode p, TreeNode q){
        Queue<TreeNode> queue = new LinkedList<>();
        if(p==null &&  q == null){
            return true;
        }
        if(p==null || q ==null){
            return false;
        }
        if(p!=null && q!=null){
            queue.offer(p);
            queue.offer(q);
        }
        while(!queue.isEmpty()){
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if(first==null && second==null) continue;
            if(first==null || second==null) return false;
            if(first.val != second.val) return false;
            queue.offer(first.left);
            queue.offer(second.left);
            queue.offer(first.right);
            queue.offer(second.right);
        }
        return true;
    }
}
