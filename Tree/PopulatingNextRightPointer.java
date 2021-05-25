/**
#116填充每个节点的下一个右侧节点指针[M]
Populating next right pointers in each node
Given a perfect BT where all leaves are on the same level and every parent has two children.
Populate each next pointer to point to its next right node. if no next right node, the right next pointer should be set to null
Initially, all next pointers are set to NULL.
*/
public class PopulatingNextRightPointer{
    // Definition for a TreeNode.
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode next;

        public TreeNode() {}

        public TreeNode(int _val) {
            val = _val;
        }


          public TreeNode(int _val, TreeNode _left, TreeNode _right, TreeNode _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
          }

    }
    /**
            1                     1 -->null
          /   \                 /   \
        2      3              2  --> 3 -->null
      / \     / \           / \     / \
    4   5    6   7        4 -->5-->6-->7 -->null
    */
    //Node 5 and Node 6 are not from one parent root,
    //so we need connect two nodes not from one parent
    //we have to add paremeter, not from one root, but two adjcent nodes as roots
    //将每一层二叉树节点连接起来」可以细化成「将每两个相邻节点都连接起来」：
    public TreeNode connect(TreeNode root)
      //  primary function
      if (root==null) return null;
      connectTwoNodes(root.left, root.right);
      return root;
    }
    //helper method
    public void connectTwoNodes(TreeNode node1, TreeNode node2){
      if(node1 == null || node2 ==null){
        return;
      }
      /******前序遍历（中左右）********/
      //connct the given two nodes
      node1.next = node2;
      //connect two nodes shared one parent root
      connectTwoNodes(node1.left, node1.right);
      connectTwoNodes(node2.left, node2.right);
      //connect two nodes from two different parent
      connectTwoNodes(node1.right,node2.left);

    }

}
