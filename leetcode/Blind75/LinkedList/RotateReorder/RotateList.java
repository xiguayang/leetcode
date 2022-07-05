package Leetcodes.Blind75.LinkedList.RotateReorder;

import Leetcodes.Blind75.LinkedList.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
         // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        // k = 2
        if(head ==null|| head.next==null) return head;
        //get the length of the list
        ListNode tail = head;
        int length =1;
        while(tail.next!=null){
            tail=tail.next;
            length++;
        }
        //System.out.println(length);
        //shift the cur pointer: length-1-k%length times
        if(k%length == 0) return head;
        int moves = length-1-k%length;
        ListNode cur = head;
        while(moves>0){
            cur = cur.next;
            moves--;
        }
        //record the first node of right 
        ListNode res = cur.next;
        // now l is the last node of left sublist, break it
        cur.next = null;
        tail.next=head;
        return res;
    }
}
