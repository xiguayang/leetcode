public class CycleLinkedList {
    public boolean hasCycle(ListNode head){
        //if the given linkedlist is null, return false
        if(head ==null) return false;
        ListNode fast = new ListNode();
        ListNode slow = new ListNode();
        fast = head;
        slow = head;
        //make sure the end condiftion: fast.next and fast.next.next be null
        while(fast.next!=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            //at one position, fast and slow pointer meet
            if(fast == slow){
                return true;
            }
        }
        //by default return false
        return false;
    }
}
