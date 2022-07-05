package Leetcodes.Blind75.LinkedList.DeleteCopySturctureTrans;

import java.util.HashMap;

public class CopyListwithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> records= new HashMap<>();
        //first pass: deep copy all nodes and put the copy node as value into the HashMap
        Node cur = head;
        while(cur!=null){
            Node copy = new Node((cur.val));
            records.put(cur, copy);
            cur = cur.next;
        }
        //second pass to add pointers of each node
        cur = head;
        while(cur!=null){
            Node copy = records.get(cur);
            copy.next = records.get(cur.next);
            copy.random = records.get(cur.random);
            cur = cur.next;
        }
        return records.get(head);

    }
}
