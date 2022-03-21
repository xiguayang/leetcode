package BinarySearchTree;
/**450. Delete Node in a BST[M]
 * Given a root node reference of a BST and a key,
 * delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 *  1. Search for a node to remove.
 *  2. If the node is found, delete the node.
 *
 * Follow up: Can you solve it with time complexity O(height of tree)?*/
public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root.val == key ){
            //find the node and delete
            //CASE 1: if the node has no child, just delete it and set it to null
            if(root.left == null && root.right == null){
                root = null;
            }else if(root.left == null){
                //CASE 2: if the node has no left child, just make its right child upgraded
                root = root.right;
            }else if(root.right == null){
                //CASE 3: if the node has no right child, just make its left child upgraded
                root = root.left;
            }else if(root.right!=null && root.left !=null) {
                //To keep to be BST, 2 methods: if we call the node to be deleted A
                //1. find the largest node in A's left subtree to replace with A, and delete the largest node
                TreeNode max = findMax(root.left);
                root.val = max.val;
                root.left = deleteNode(root.left, max.val);
                //2. find the smallest node in A's right subtree to replace with A
                //TreeNode min = findMin(root.right);
                //root.val = min.val;
                //root.right = deleteNode(root.right, min.val);
            }
        }else if (root.val > key){
            //go to the left subtree
            root.left = deleteNode(root.left, key);
            //go to the right subtree
        }else if (root.val < key){
            root.right = deleteNode(root.right, key);
        }

        return root;
    }
    public TreeNode findMax(TreeNode root){
        //the most right node is the largest one
        while(root.right !=null){
            root = root.right;
        }
        return root;
    }
    public TreeNode findMin(TreeNode root){
        //the most left node is the smallest one
        while(root.left !=null){
            root = root.left;
        }
        return root;
    }
}
