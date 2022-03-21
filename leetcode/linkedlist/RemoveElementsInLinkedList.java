package linkedlist;
/**#203. Remove Linked List Elements [E]
 * Given the head of a linked list and an integer val,
 * remove all the nodes of the linked list that has Node.val == val,
 * and return the new head.
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 104].
 * 1 <= Node.val <= 50
 * 0 <= k <= 50*/
public class RemoveElementsInLinkedList {
    public ListNode removeElements(ListNode head, int val) {
        //find the most left elements that is not equals to val
        while(head!=null && head.val == val){
            head = head.next;
        }
        ListNode curr = head;
        while(curr!=null && curr.next!=null){
            if(curr.next.val == val){
                curr.next= curr.next.next;
            }else{
                curr= curr.next;
            }
        }
        return head;
    }
}
