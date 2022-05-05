package Tree.LevelOrder;
import java.util.*;
import Tree.TreeNode;


/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * Given the root of a binary tree, return the zigzag level order traversal of
 * its nodes' values.
 * (i.e., from left to right, then right to left for the next level and
 * alternate between).
 * level 0: left to right
 * level 1: right to left
 * level 2: left to right
 * ....
 * level n: if(n%2==0） left to right
 * if(n%2==1) right to left
 */
public class ZigZagLevelTraversal {
    // Method 1: DFS, using helper method to add level as argument
    // similar to DFS 103 levelOrderTraversal: only chaning the order of adding node
    // value into sub level arraylist by level%2
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        traversalHelper(result, root, 0);
        return result;
    }

    public void traversalHelper(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            result.get(level).add(root.val);
        } else {
            // add into the sub arraylist from front
            result.get(level).add(0, root.val);
        }
        traversalHelper(result, root.left, level + 1);
        traversalHelper(result, root.right, level + 1);
    }

    // method 2: BFS: similar to BFS #102 level order
    // changes: using level%2 to check add node.val into sub level array list from
    // left to right or right to left
    public List<List<Integer>> zigzagLevelOrderBFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        // Queue<TreeNode> queue = new LinkedList<>();
        // put the root into the queue and traverse the queue continually
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            // get the size of current queue, its the number of nodes in current level
            int size = queue.size();
            ArrayList<Integer> levelRes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                // TreeNode node = queue.poll();
                if (level % 2 == 0) {
                    levelRes.add(node.val);
                } else {
                    levelRes.add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(levelRes);
            level++;
        }
        return result;
    }
}
