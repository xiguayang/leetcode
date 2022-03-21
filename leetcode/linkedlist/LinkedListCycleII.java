package linkedlist;
/** #142 Linked List Cycle II [M][Top100]
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node
 * in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 * Notice that you should not modify the linked list.
 *
 * Constraints:
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 * */
public class LinkedListCycleII {
    /**different with linkedListCycle[E], just return true if has cycle
     * this problem needs to return the node the cycle begins
     * process:
     * Step1: use two pointers: fast and slow, fast moves 2 times faster than slow
     *         so if there is a cycle, fast and slow meet at the node P,
     *         suppose the node cycle started is at node Q:
     *           head>>>>>>Q>>>>>>>>P>>>>>
     *                     <<<<<<<<<<<<<<<
     *         so suppose the steps between head to Q is a, Q to P is b
     *         P to Q is c
     *         fast moves : a+b+c+b
     *         slow moves: a + b
     *         fast is 2 faster than slow : a+b+c+b = 2(a+b)
     *         ====> a==c
     * Step2: add one more pointer slow2 starts from head which is as fast as slow
     *        because of a==c, head to Q equals P to Q
     *        so slow2 will meet with slow at Q, Q is the node cycle starts*/
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                ListNode slow2 = head;
                while(slow2 !=slow){
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
