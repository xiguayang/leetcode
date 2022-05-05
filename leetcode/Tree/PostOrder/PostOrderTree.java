package Tree.PostOrder;

import java.util.ArrayList;
import java.util.LinkedList;

import Tree.TreeNode;

/**# 297. Serialize and Deserialize Binary Tree[H]*/

public class PostOrderTree{
    // left ==> right ==> root
    public String serialize(TreeNode root) {
        //key for recursion: focus on a single node
        if(root == null) return "null";

        String leftSubTree = serialize(root.left);
        String rightSubTree = serialize(root.right);

        return leftSubTree + ","+rightSubTree +","+ root.val;

    }



    //use StringBuilder to serizalize
    //可以用于高效拼接字符串，所以也可以认为是一个列表
    String SEPERATE = ",";
    String NULL = "null";
    public String serializeI(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    public void serialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(SEPERATE);
            return;
        }

        /********************/
        serialize(root.left, sb);
        serialize(root.right, sb);

        /**PostOrder traverse*/
        sb.append(root.val).append(SEPERATE);
    }


    // Decodes your encoded data to tree.
    /*Main method*/
    public TreeNode deserialize(String data) {
        //use linked list to represent the string: as a queue
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(",")){
            nodes.add(s);
        }
        //its now a linkedlist to store all nodes, use a helper method
        return deserialize(nodes);
    }
    /*a helper method for deserialize*/
    public TreeNode deserialize(LinkedList<String> nodes){
        if(nodes.isEmpty()) return null;
        /********postOrder*********/
        //The last element of the arraylist is the root
        String last = nodes.removeLast();
        if(last.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(last));
        /*************************/
        // rightsubtree firstly then left
        root.right = deserialize(nodes);
        root.left = deserialize(nodes);

        return root;
    }

}
