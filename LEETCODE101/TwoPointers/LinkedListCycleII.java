package TwoPointers;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer. Internally, pos
 * is used to denote the index of the node that tail's next pointer is connected
 * to. Note that pos is not passed as a parameter.
 * 
 * Notice that you should not modify the linked list.
 */

public class LinkedListCycleII {

    // Solution: Floyd slow and fast pointers approach
    // 1. Given two pointers both start from the start of the linked list. fast
    // moves two steps and slow move one step every time.
    // 2. If fast arrives the end(fast.next ==null), there is no cycle; else, there
    // is cycle and fast and slow will encounter with each other.
    // 3. When slow encounter with fast for the first time, move fast to the start
    // of linked list.
    // 4. Then both fast and slow move one step each time.
    // 5. The second time they meet with each other is the start of the cycle.
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

}
