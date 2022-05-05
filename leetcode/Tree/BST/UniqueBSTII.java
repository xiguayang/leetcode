package Tree.BST;
import java.util.*;
import Tree.TreeNode;

// Q95 similar with 96
// 罗列所有【1，n】组成的BST， 思路类似 96
// if choose i as root, 构造【1，i-1】所有 BST 及 【i+1,n】 所有BST
public class UniqueBSTII {
    public List<TreeNode> generateBST(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();
        // base case
        if (lo > hi) {
            res.add(null);
            return res;
        }
        // list all the root
        for (int i = lo; i <= hi; i++) {
            List<TreeNode> leftTrees = generateTrees(lo, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, hi);
            // for root i, 排列组合所有左右情况
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }

        }
        return res;
    }

}
