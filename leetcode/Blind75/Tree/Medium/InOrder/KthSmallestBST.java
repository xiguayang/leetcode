package Leetcodes.Blind75.Tree.Medium.InOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestBST {
        //Method1: using interactive inordertraversal to add nodes into arraylist inorder
        //get the k-1 index of the result list (not neccessary)
        //adding the nodes into list is inorder, the Kth means the kth time adding to list
        //==> every time adding to list: k-1
        //the first adding to list is k =1
        //so when k-1 ==0, break the loop and return the root.val
        public int kthSmallest(TreeNode root, int k) {
            //int res = -1;
            //List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while(root!=null ||!stack.isEmpty()){
                while(root!=null){
                    stack.add(root);
                    root=root.left;
                }
                root=stack.pop();
                //list.add(root.val);
                if(--k ==0) break;
                root=root.right;
            }
            return root.val; 
        }

        //using the rank to record the rank of current node
        int rank =0;
        int result=0;
        public int kthSmallestRecursion(TreeNode root, int k) {
            inOrderTraversal(root,k);
            return result;
        }
        public void inOrderTraversal(TreeNode root, int k){
            inOrderTraversal(root.left, k);
            rank++;
            if(rank==k){
                result=root.val;
                return;
            }
            inOrderTraversal(root.right, k);
        }
}
