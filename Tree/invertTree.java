 /**# 226 invert BT
 only need to switch the left and right node of each root
*/
class invertTree {
   
    public TreeNode invertTree(TreeNode root) {

        //base case
        if(root == null){
            return root;
        }
        /*root, root.left, root.right*/
        //for root, exchange the left and right node
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //for each son nodes, invert them dividlly
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
