public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //1 or no node
        if(head ==null || head.next==null){
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        //condition: must be cur is null
        while(cur!=null){
            //4 steps:
            //1: use a temp node to record cur.next
            //2: cur.next point to previous node
            //3: move pre to cur
            //4: move cur to temp node
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
