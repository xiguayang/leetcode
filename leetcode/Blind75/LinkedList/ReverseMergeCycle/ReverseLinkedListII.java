package Leetcodes.Blind75.LinkedList.ReverseMergeCycle;

import Leetcodes.Blind75.LinkedList.ListNode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //move preReversed to the previous node of reversedPartial
        ListNode preReversed = dummy;
        while(left>1){
            preReversed=preReversed.next;
            left--;
        }
        ListNode start = preReversed.next;
        //move end to  the reversed partion end node
        ListNode end = dummy;
        while(right>0){
            end = end.next;
            right--;
        } 
        ListNode afterReversed = end.next;
        //break the reversed partial
        end.next =null;
        ListNode reversed = reverse(start);
        // adding back the reversed 
        preReversed.next = reversed;
        start.next = afterReversed;
        return dummy.next;
    }


    private ListNode reverse(ListNode head) {
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
