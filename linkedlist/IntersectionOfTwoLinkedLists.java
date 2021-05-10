package linkedlist;
/**# 160. Intersection of Two Linked Lists [E]
 *
 * Given the heads of two singly linked-lists headA and headB,
 * return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 * It is guaranteed that there are no cycles anywhere in the entire linked structure.
 * Note that the linked lists must retain their original structure after the function returns.
 * Constraints:
 * The number of nodes of listA is in the m.
 * The number of nodes of listB is in the n.
 * 0 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * intersectVal is 0 if listA and listB do not intersect.
 * intersectVal == listA[skipA + 1] == listB[skipB + 1] if listA and listB intersect.*/
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //can't reverse two lists
        //because they must retain their original structure after the function returns.

        //============================
        //get the difference of the lenght of the tow lists
        //remove the left nodes of the longer list over the smaller length
        int lenA = length(headA);
        int lenB = length(headB);

        //now two lists's current pointers are at
        //the same position tha the lenghts from the position to then end are same
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int length(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }
}
