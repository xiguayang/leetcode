package Leetcodes.Blind75.Tree.Easy.Recursion;
class PopulateNextRightPointers {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    //primary method
    public Node connect(Node root) {
        if(root == null) return root;
        connectTwoNodes(root.left, root.right);
        return root;
    }
    
    //a helper method to connect two nodes
    public void connectTwoNodes(Node node1, Node node2){
        if(node1 == null || node2 ==null){
            return;
        }
        //root, root.left, root.right
        //connect the two passed nodes
        node1.next = node2;
        //connect the left and right nodes of each passed node
        connectTwoNodes(node1.left, node1.right);
        connectTwoNodes(node2.left, node2.right);
        //connect the two nodes not from one parent
        connectTwoNodes(node1.right,node2.left);
        
    }
}