package linkedlist;
/**#19. Remove Nth Node From End of List[M][top100]
 * Given the head of a linked list,
 * remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz*/
public class RemoveNthNodeFromEnd {
    /**Approach 1 : time O(L), space:O(1)*/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int len = length(head);
        //len is the number of nodes in the list
        //the pos of first node is 0,
        //the Nth node from the end is at the pos: len-n
        //so we move the pointer curr to the node(len-n-1) left of the node we want to remove
        //and make curr.next = curr.next.next
        int posDelete = len-n;
        if(posDelete<=0){
            //move head to the next
            head=head.next;
        }else{
            //move the curr to the left node of the removed node
            while(posDelete>1){
                curr= curr.next;
                posDelete --;
            }
            //remove the node
            curr.next = curr.next.next;
        }
        return head;

    }
    private static int length(ListNode head){
        int len = 0;
        ListNode curr = head;
        while(curr!=null){
            curr= curr.next;
            len++;
        }
        return len;
    }

    /**Approach 2 : One pass algorithm
     *  time O(L), space:O(1)*/
    public ListNode removeNthFromEndBy2Pointers(ListNode head, int n) {
        /**use two pointers
         * add one dummynode left to head,in case we delete the head node
         * first and second pointers point to the dummynode
         * first pointer moves early than second pointer by n steps from the dummynode
         * and then they move together until first pointer arrives end node(f.next = null)
         * second pointer now is at the left node of the removed node
         * */
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode first = dummyNode;
        ListNode second = dummyNode;
        while(n>0){
            first= first.next;
            n--;
        }
        while(first.next!=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyNode.next;
    }
}
