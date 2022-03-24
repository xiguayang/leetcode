
/**876. Middle of the Linked List */
public class middleNode {
    public ListNode middleNode1(ListNode head) {
        //fast and slow 2 pointers
        //when fast.next || fast.next.next ==null,
        //slow arrives at the middle
        if(head.next ==null) return head;//1 node, return itself
        ListNode fast = new ListNode();
        ListNode slow = new ListNode();
        fast = head;
        slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
