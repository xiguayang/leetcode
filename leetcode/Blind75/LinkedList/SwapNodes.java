package Leetcodes.Blind75.LinkedList;

public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        if(head ==null || head.next==null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode p1 = head;
        while(p1!=null &&p1.next!=null){
            ListNode p2 = p1.next;
            //1. save next pair
            ListNode temp = p2.next;
            //2. reverse this pair
            p2.next=p1;
            p1.next=temp;
            pre.next=p2;
            //3. update to next pair
            pre = p1;
            p1 = temp;
        }
        
        return dummy.next;
        
        
    }
}
