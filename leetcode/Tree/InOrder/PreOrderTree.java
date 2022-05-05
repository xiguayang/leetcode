package Tree.InOrder;

import java.util.LinkedList;

import Tree.TreeNode;

/**# 297. Serialize and Deserialize Binary Tree[H]*/

public class PreOrderTree{
    /* root ==> left ==> right*/
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //key for recursion: focus on a single node
        if(root == null) return "null";

        String leftSubTree = serialize(root.left);
        String rightSubTree = serialize(root.right);

        return root.val + ","+leftSubTree + rightSubTree;

    }

    //use StringBuilder to serizalize
    //可以用于高效拼接字符串，所以也可以认为是一个列表
    String SEPERATE = ",";
    String NULL = "null";
    /*Mian method*/
    public String serializeUsingStringBuffer(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    /*helper method*/
    public void serialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(SEPERATE);
            return;
        }

        /**Preorder traverse*/
        sb.append(root.val).append(SEPERATE);
        /********************/
        serialize(root.left, sb);
        serialize(root.right, sb);
    }


    // Decodes your encoded data to tree.
    /*Main method*/
    public TreeNode deserialize(String data) {
        //use linked list to represent the string: as a queue
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(",")){
            nodes.addLast(s);
        }
        //its now a linkedlist to store all nodes, use a helper method
        return deserialize(nodes);
    }
    /*a helper method for deserialize*/
    public TreeNode deserialize(LinkedList<String> nodes){
        if(nodes.isEmpty()) return null;
        /********preorder*********/
        //The first element of the linkedlist is the root
        String first = nodes.removeFirst();
        if(first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        /*************************/
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }


}
