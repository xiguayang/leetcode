/** #654 Maximum Binary Tree [M]
You are given an integer array nums with no duplicates.
A maximum binary tree can be built recursively from nums using the following algorithm:
  1. Create a root node whose value is the maximum value in nums.
  2.Recursively build the left subtree on the subarray prefix to the left of the maximum value.
  3.Recursively build the right subtree on the subarray suffix to the right of the maximum value.
  Return the maximum binary tree built from nums.
  Constraints:

  1 <= nums.length <= 1000
  0 <= nums[i] <= 1000
  All integers in nums are unique.
*/
public class MaxBT{
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //1. find the largest in nums, make it as the root
        //2. get the leftsubarray, find the largest, make it as the left tree's root
        //3. get the rightsubarray, find the largest, make it as teh right tree's root

        /* The first abstract idea
        int maxnumber = max(nums);
        TreeNode root = new TreeNode(maxnumber);
        root.left = constructMaximumBinaryTree(leftsubarray);
        root.right = constructMaximumBinaryTree(rightsubarray);
        return root;
        */

        /** The second idea ==> we need to find the max number of each sub arrary. how to build the sunArray
        //base case
        if(nums == null){
          return null;
        }
        //get the max value and the its index
        int maxVal = nums[0];
        int maxIndex = 0;
        for(int i = 0; i< nums.length; i++){
          if(nums[i]>maxVal){
            maxVal = nums[i];
            maxIndex = i;
          }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = constructMaximumBinaryTree(nums[0...maxIndex-1]);
        root.right = constructMaximumBinaryTree(nums[maxIndex+1,....ums.length-1]);
        */
        //subarray has two more parameters to represent the arrary
        return buildTree(nums, 0, nums.length-1);

    }
    public TreeNode buildTree(int[] nums, int lo, int hi){
      if(lo>hi){
        return null;
      }
      //get the max value and the its index
      int maxVal = nums[lo];
      int maxIndex = lo;
      for(int i = lo; i<=hi; i++){
        if(nums[i]>maxVal){
          maxVal = nums[i];
          maxIndex = i;
        }
      }
      TreeNode root = new TreeNode(maxVal);
      root.left = buildTree(nums, lo, maxIndex-1);
      root.right = buildTree(nums,maxIndex+1,hi);
      return root;
    }



}
