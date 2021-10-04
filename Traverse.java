public class Traverse{


  void traverse(int[] arr){
    for(int i = 0 ; i< arr.length;i++){
      //迭代访问arr[i]
    }
  }

  /**基本的链表节点*/
  class ListNode{
    int val;
    ListNode next;
  }

  void traverseI(ListNode head){
    for(ListNode p = head; p!=null ; p = p.next){
      //迭代访问p.val
    }
  }
  void traverse(ListNode head){
    //递归访问 head.val
    traverse(head.next);
  }

  /**基本的二叉树节点
  class TreeNode{
    int val;
    TreeNode left, right;
  }
  void traverseII(TreeNode root){
    traverse(root.left);
    traverse(root.right);
  }
   */


  /**基本的 N叉树节点
  class TreeNode{
    int val;
    TreeNode[] children;
  }
  void traverse(TreeNode root){
    for(TreeNode child : root.children){
      traverse(child);
    }
  }
   */
































}
