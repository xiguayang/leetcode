package Tree;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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
   //use HashSet to record subtrees of each node,
   //but it may have more than 2 duplicate subtree to be reocorded
   //====> use HashMap to record all the subTrees and the times they appear

    HashMap<String,Integer> memo = new HashMap<>();
    //Record duplicated subTree's root
    LinkedList<TreeNode> result = new LinkedList<>();
    /**Main method*/
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverseTree(root);
        return result;
    }
    /**helper method*/
    /*postorder the subtree if given a root: traverse left and right plus root itself*/
    public String traverseTree(TreeNode root){
        //for null node, use a special char to represent it "#"
        if(root == null){
           return "#";
        }
        //make the left and right subtree as string
        String left = traverseTree(root.left);
        String right= traverseTree(root.right);
        //plus the root itself
        String subTree = left + ","+right+","+root.val;

        //This method returns value mapped with the specified key, otherwise default value is returned.
        //v = getOrDefault(Object key, v defaultvalue)
        int frequency = memo.getOrDefault(subTree,0);
        if(frequency ==1){
           result.add(root);
        }
        memo.put(subTree,frequency+1);
        return subTree;
    }

    int count(TreeNode root){
      if(root == null){
        return 0;
      }
      //count nodes in left tree and right seperately
      int left = count(root.left);
      int right = count(root.right);
      int res = left + right +1;
      return res;
    }
}
