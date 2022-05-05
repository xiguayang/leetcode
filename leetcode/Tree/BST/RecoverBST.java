//Q 99. swap 2 nodes to get correct BST
// BST, inorder traversal is ordered
// 对BST 中序遍历（left==>root==> right） 得到的是有序的， 找到中序遍历中非有序的两个node 进行swap
package Tree.BST;

import Tree.TreeNode;
public class RecoverBST {
    // record the 2 wrong ordered nodes
    TreeNode first = null;
    TreeNode second = null;

    // set a minimal value as TreeNode
    // 找一个最小自然数值的TreeNode 作为起始比较值
    TreeNode min = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorderTraverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        // root 小于前面的值
        if (root.val < min.val) {
            // root 不符合inorder
            if (first == null) {
                first = min;
            }
            second = root;
        }
        // 设置min
        min = root;
        inorderTraverse(root.right);
    }
}
