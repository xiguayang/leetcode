package TestDome.JAVA;

import java.util.Stack;

class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class IsBST {
    public static boolean isBSTAndContains(Node root, int value) {
        //check is a valid BST, check if value in BST
        if(root ==null) return false;
        boolean isContain = false;
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        while(root !=null || !stack.isEmpty()){
            while(root!=null){
                if(root.value == value) isContain=true;
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre!=null && root.value<=pre.value){
                return false;
            }
            pre = root;
            root = root.right;
        }
        return isContain;
        
    }
    //is a BST, just check if contains
    public static boolean contains(Node root, int value) {
        //check is a valid BST, check if value in BST
        if(root ==null) return false;
  
        while(root!=null){
            if(root.value == value){
                return true;
            }else if(root.value>value){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return false;
    }
        
    
    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);
        
        System.out.println(contains(n2, 3));
    }
}
