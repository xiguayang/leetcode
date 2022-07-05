package Leetcodes.Blind75.LinkedList.RotateReorder;

import Leetcodes.Blind75.LinkedList.ListNode;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next =head;
        ListNode l = dummyNode;
        ListNode r = dummyNode;
        while(n>0&&r!=null){
            r=r.next;
            n--;
        }
        while(r.next!=null){
            l=l.next;
            r=r.next;
        }
        l.next = l.next.next;
        return dummyNode.next;
    }
    
}
