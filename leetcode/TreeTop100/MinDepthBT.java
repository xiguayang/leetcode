public class MinDepthBT {
    public int minDepth(TreeNode root) {
        // BFS: start node: root; target node: node.left==null&& node.right ==null
        // data structure: queue, no need to record visited
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null)
            return 0;
        // initial set
        int depth = 1;
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                // check if cur is the target
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                // still not the target
                // expand to cur's surrounding nodes, add them to queue
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }
}
