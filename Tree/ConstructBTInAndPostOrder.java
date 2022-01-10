package Tree;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal[M]
 * Given two integer arrays inorder and postorder
 * where inorder is the inorder traversal of a binary tree
 * and postorder is the postorder traversal of the same tree,
 * construct and return the binary tree.
 * 
 */
class ConstructBTInAndPostOrder {
    /**
     * inorder: left => root => right
     * postorder: left=> right => root
     * so, the last element in postorder is the root
     * according to the root val in inorder, we could splict inorder into left and
     * right subarray
     * 
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int endPost = postorder.length - 1;
        int startIn = 0;
        int endIn = inorder.length - 1;
        return buildHelper(inorder, postorder, endPost, startIn, endIn);

    }

    public TreeNode buildHelper(int[] inorder, int[] postorder, int endPost, int startIn, int endIn) {
        if (endPost < 0 || startIn > endIn) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[endPost]);
        int index = findIndexInorder(root.val, inorder, startIn, endIn);

        root.right = buildHelper(inorder, postorder, endPost - 1, index + 1, endIn);
        // attention: the endIndex of postorder for left subarray should be the left
        // array (减去所有右边子树上node的个数)
        root.left = buildHelper(inorder, postorder, endPost - (endIn - index + 1), startIn, index - 1);
        return root;

    }

    public int findIndexInorder(int rootVal, int[] inorder, int startIn, int endIn) {
        int index = -1;
        for (int i = startIn; i <= endIn; i++) {
            if (rootVal == inorder[i]) {
                index = i;
            }
        }
        return index;
    }

    // Solution 2:
    // postOrder: leftSub rightSub root
    // inOrder: leftSub root rightSub
    // 1. get rootVal from postOrder: the last element
    // 2. base on root Val, traverse inOrder to get the index
    // 3. get the left sub tree size: index-inStart
    // 4. based on left subTree size, get the start and end positions for sub trees
    // 5. build trees recursively
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        int postEnd = postorder.length - 1;
        int inEnd = inorder.length - 1;
        return build(inorder, 0, inEnd, postorder, 0, postEnd);
    }

    private TreeNode build2(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postEnd < 0)
            return null;
        int rootVal = postorder[postEnd];
        // find the index of rootval in inorder
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build2(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        // attention: must be postEnd-1, remove root
        root.right = build2(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

}
