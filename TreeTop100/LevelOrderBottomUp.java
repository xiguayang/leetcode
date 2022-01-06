package TreeTop100;

import java.util.ArrayList;
import java.util.List;

/**
 * 107. Binary Tree Level Order Traversal II
 * Given the root of a binary tree,
 * return the bottom-up level order traversal of its nodes' values.
 * (i.e., from left to right, level by level from leaf to root).
 * ===>
 * Approach 1. add the sub level list into the result from the list's front: use
 * add(0,val); DFS #102 small change
 * Approach 2. Reverse the ArrayList of LEVEL ORDER TRAVERSAL directly: use
 * java.util.Collections.reverse()
 */
public class LevelOrderBottomUp {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        traverseLevelOrder(result, root, 0);
        return result;
    }

    public void traverseLevelOrder(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            // change1: add the element from list's front
            result.add(0, new ArrayList<>());
        }
        // add the root's value into the sub arraylist, pay attention to the index
        // index: 0, 1, 2, 3, 4, 5, 6
        // level: 6, 5, 4, 3, 2, 1, 0
        // change 2: index=size-1-level
        result.get(result.size() - 1 - level).add(root.val);
        traverseLevelOrder(result, root.left, level + 1);
        traverseLevelOrder(result, root.right, level + 1);
    }
}
