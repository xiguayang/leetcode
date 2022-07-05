package Leetcodes.Blind75.LinkedList.DeleteCopySturctureTrans;

import java.util.DuplicateFormatFlagsException;

import Leetcodes.Blind75.LinkedList.ListNode;

public class RemoveList {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next=head;
        ListNode pre = dummyNode;

       //move head one by one
        while(head!=null){
            if(head.val==val){
                pre.next = head.next;
            }else{
                pre.next = head;
            }
            head=head.next;
        }
        return dummyNode.next;
    }
}
