package TreeTop100;

import java.util.ArrayList;
import java.util.List;

/**103. Binary Tree Zigzag Level Order Traversal
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 * level 0: left to right
 * level 1: right to left
 * level 2: left to right
 * ....
 * level n: if(n%2==0） left to right
 *          if(n%2==1) right to left*/
public class ZigZagLevelTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        traversalHelper(result, root, 0);
        return result;
    }
    public void traversalHelper(List<List<Integer>> result, TreeNode root, int level){
        if(root == null){
            return;
        }
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        if(level%2 == 0){
            result.get(level).add(root.val);
        }else{
            //add into the sub arraylist from front
            result.get(level).add(0,root.val);
        }
        traversalHelper(result,root.left,level+1);
        traversalHelper(result,root.right,level+1);
    }

}
