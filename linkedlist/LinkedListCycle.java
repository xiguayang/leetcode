package linkedlist;
/**#141 check if a linked list has cycle inside [E]
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.*/
/**Constraints:
        The number of the nodes in the list is in the range [0, 104].
        -105 <= Node.val <= 105
        pos is -1 or a valid index in the linked-list.*/
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        //use two pointers, fast and slow,
        //fast moves 2 steps every time while slow moves 1 step every time
        //if is contains circle, fast and slow will finally meet at some position
        ListNode fast = new ListNode();
        ListNode slow = new ListNode();
        fast = head;
        slow = head;
        if(head==null){
            return false;
        }
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
