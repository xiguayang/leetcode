package LinkedList;

import java.util.List;

/*** #148 Sort List [M][TopInterview]
 * Given the head of a linked list,
 * return the list after sorting it in ascending order.
 *
 * Follow up: Can you sort the linked list in O(n logn) time
 * and O(1) memory (i.e. constant space)?
 * Constraints:
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 */
public class SortList {
    /**
     * Merge Sort is one of the efficient sorting algorithms
     * that is popularly used for sorting the linked list.
     * The merge sort algorithm runs in O(nlogn) time in all the cases
     *
     * Quicksort is also one of the efficient algorithms with the average time complexity of O(nlogn).
     * But the worst-case time complexity is O(n^2)
     *
     * Divide and conquer:
     * Step 1: Recursively split the original list into two halves.
     *         The split continues until there is only one node in the linked list (Divide phase).
     *         To split the list into two halves,
     *         we find the middle of the linked list
     *         using the Fast and Slow pointer approach as mentioned in Find Middle Of Linked List.
     *
     * Step 2: Recursively sort each sublist and combine it into a single sorted list. (Merge Phase).
     *         This is similar to the problem Merge two sorted linked lists
     * */
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    public static ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyHead = new ListNode(0);
        ListNode ptr = dummyHead;
        while(list1 !=null && list2 !=null){
            if(list1.val<= list2.val){
                ptr.next = list1;
                list1 = list1.next;
                /**!Attention: must move ptr to the next one!*/
                ptr = ptr.next;
            }else {
                ptr.next = list2;
                list2 = list2.next;
                ptr = ptr.next;
            }
        }
        if(list1 == null){
            ptr.next = list2;
        }else{
            ptr.next = list1;
        }
        return dummyHead.next;
    }
    /**!Attention!: after get the middle node, we need to split the original list to two parts
     *              the left part's last node.next should be null.
     *              so the slow pointer should start before head, and fast start from head
     *              we get the node previous middle when fast arrives at the end
     *              middle = slow.next
     *              slow.next = null*/
    public static ListNode middleNode(ListNode head){

        if(head == null && head.next==null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = new ListNode();
        slow.next = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;

    }

    public static void main(String[] args) {
        int[] arr = {10,1,60,30,5};
        ListNode l = new ListNode(arr);
        l.printList();
        l = sortList(l);
        l.printList();
    }

}
