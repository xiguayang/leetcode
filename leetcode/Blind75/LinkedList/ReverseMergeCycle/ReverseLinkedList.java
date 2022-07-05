package Leetcodes.Blind75.LinkedList.ReverseMergeCycle;

import Leetcodes.Blind75.LinkedList.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next=pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
