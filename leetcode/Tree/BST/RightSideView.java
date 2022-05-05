package Tree.BST;

//import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Tree.TreeNode;

/**199. Binary Tree Right Side View[M]
 Given the root of a binary tree,
 imagine yourself standing on the right side of it,
 return the values of the nodes you can see ordered from top to bottom.
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        if(root == null){
            return rightSide;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i<size;i++){
                TreeNode node = queue.poll();
                if(i == 0){
                    rightSide.add(node.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return rightSide;
    }

    public List<Integer> rightSideViewDFS(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        traverse(root, result, 0);
        return result;
    }
    public void traverse(TreeNode node, List<Integer> res, int level){
        if(node == null) return;
        if(res.size()==level)
            res.add(node.val);

        traverse(node.right, res, level + 1);
        traverse(node.left, res, level + 1);
    }

}
