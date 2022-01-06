import java.util.Queue;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

public class VerticalOrderBT {
    // Given a binary tree, return the vertical order traversal of its nodes'
    // values. (ie, from top to bottom, column by column).
    // given every node a col: Root is 0, root.left is -1; root.right is 1
    // BFS
    public List<List<Integer>> vertialOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        // using 2 Queues to record each node, one for node itself, one for node's col
        // number
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> cols = new LinkedList<Integer>();
        // using a TreeMap as structure for results
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();

        q.add(root);
        cols.add(0);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = cols.poll();
            // check the map, if not contains col number, add one key-value
            if (!map.constainsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }
            // put the node to corresponding value ArrayList
            map.get(col).add(node.val);
            // deal with the left and right
            if (node.left != null) {
                q.add(node.left);
                cols.add(col - 1);
            }
            if (node.right != null) {
                q.add(node.right);
                cols.add(col + 1);
            }
        }
        res.addAll(map.values());
        return res;
    }
}
