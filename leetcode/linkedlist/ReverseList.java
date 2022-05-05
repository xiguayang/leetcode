package LinkedList;
/**#206
 * Given the head of a singly linked list, reverse the list,
 * and return the reversed list.*/
public class ReverseList {
    /**Approach1：
     * Recursion method:  time complexity O(n); space complexity O(n)*/
    public ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /** Approach2:
     * Iterative method : time complexity O(n); space complexity O(1)*/
    public ListNode reverseListIterative(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
