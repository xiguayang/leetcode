/**652. Find Duplicate Subtrees[M]

Given the root of a binary tree, return all duplicate subtrees.
For each kind of duplicate subtrees,
you only need to return the root node of any one of them.
Two trees are duplicate if they have the same structure with the same node values.*/

class findDuplicateSubtrees {
   /**
    1. how to describe the subtree: traverse the subtree use the given root
    2. how about other subtrees with different roots: Use HashSet, each node with a subTree

   */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

    }

    /*postorder the subtree if given a root: traverse left and right plus root itself*/
    public String traverse(TreeNode root){
        //for null node, use a special char to represent it "#"
        if(root == null){
           return "#";
        }
        //make the left and right subtree as string
        String left = traverse(root.left);
        String right= traverse(root.right);
        //plus the root itself
        String subTree = left + ","+right+","+root.val;
        return subTree;
    }

    int count(TreeNode root){
      if(root == null){
        return 0;
      }
      //count nodes in left tree and right seperately
      int left = count(root.left);
      int right = count(root.right);
      int res = left + right +1；
      return res;
    }
}
