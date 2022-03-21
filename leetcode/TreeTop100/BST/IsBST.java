//Q98 check if the given BT a valid BST
//solution: inordertravel, if sorted, it is a BST
public class IsBST {
    // Method 1: Inorder Traver get a ArrayList, chech if the arraylist is sorted
    List<Integer> list = new ArrayList<Integer>();

    public boolean isValidBSTByInOrder(TreeNode root) {
        inOrder(root);
        return isSorted(list);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    // Method 2: Inorder Traversal Structure
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

    public boolean isValidBSTInOrderStructure(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val)
                return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    // Method 3: Recursion Method;
    TreeNode min = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST(root.left))
            return false;
        if (min != null && root.val < min.val)
            return false;
        min = root;

        if (!isValidBST(root.right))
            return false;

        return true;
    }
}