/**105. Construct Binary Tree from Preorder and Inorder Traversal [M]

Given two integer arrays preorder and inorder
where preorder is the preorder traversal of a binary tree
and inorder is the inorder traversal of the same tree,
construct and return the binary tree.
Constraints:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.*/
public class ConstructBTPreAndInOrder{
  public TreeNode buildTree(int[] preorder, int[] inorder) {
      /*
      preorder: root -> left -> right
      inorder: left -> root -> right
      1. from preorder, the first element is root
      2. according to the root in #1, inorder can split into left subtree and right subtree
      3. the second element in preorder is the root of left subtree
      4. according to #3, left subtree in #2 can split to another two subtree;
      ....

      recursively: [lo...hi], lo as 0, hi as length-1
      1. preorder[], get the first element from preorder, preorder[0]
        according to preorder[0], find the item in inorder, position as x
        make x as root
        get the leftsubtree inorder[0,x-1] and rightsubtree inorder[x+1,hi]
      2. preorder [1,hi]
         leftsubtree: inorder[lo,x-1]
         rightsubtree: inorder[x+1,hi]
         recursive #1 in leftsubtree
      3. if leftsubtree is empty, make the num preorder[i] as root and recursive #1 in rightsubtree
      4. until the last element in preorder
      */

      int inStart = 0;
      int inEnd = inorder.length-1;
      int preStart = 0;
      return build(preorder, preStart, inorder,inStart,inEnd)；
  }


  public TreeNode build(int[] preorder, int preStart, int[]inorder, int inStart, int inEnd){
    if (preStart > preorder.length - 1 || inStart > inEnd ) return null;

    int index = findIndexInorder(preorder[preStart],inorder,inStart, inEnd);
    TreeNode root = new TreeNode(preorder[preStart]);

    root.left = build(preorder, preStart+1, inorder, inStart, index-1) ;
    //for the right tree, the started index in preorder is
    root.right = build(preorder, preStart+index-inStart+1, inorder, index+1, inEnd) ;
    return root;
  }
  public int findIndexInorder(int val, int[] inorder, int inStart, int inEnd){
    int index = 0;
    for(int i =inStart; i<=inEnd;i++){
      if(inorder[i]==val){
        index = i;
      }
    }
    return index;
  }




}
