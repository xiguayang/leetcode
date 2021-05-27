package BinarySearchTree;
/**538/1038 Convert BST to Greater (Sum)Tree
 * Given the root of a Binary Search Tree (BST),
 * convert it to a Greater Tree such that every key of the original BST
 * is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.*/
public class BSTtoGreaterTree {
    //对于BST，每个右子树都大于该节点,但是只考虑右子树是不行的，父节点也可能大于此节点
    //===>利用inorder遍历，可以升序反之也可以降序： 降序后，多维护一个外部累加sum变量，并把它赋值给该节点
    public TreeNode convertBST(TreeNode root) {
        traverseBDRDecrease(root);
        return root;
    }
    int sum = 0;
    public void traverseBDRDecrease(TreeNode root){
        if(root == null) return;

        traverseBDRDecrease(root.right);
        sum = sum + root.val;
        root.val  = sum;
        traverseBDRDecrease(root.left);
    }

}
