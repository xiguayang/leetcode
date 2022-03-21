package linkedlist;
/**#83 [E]
 * Given the head of a sorted linked list,
 * delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.*/
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        //use handler to track the node
        ListNode handler = head;
        //if the list is null or only one node, just return it
        if(head == null ||head.next ==null){
            return head;
        }
        //track the node from the left first
        //if the next node value equals the current node
        //jump the next node to the next one
        //else move the handler to next node for next comparision
        while(handler.next!=null){
            if(handler.val == handler.next.val){
                handler.next = handler.next.next;
            }
            else{
                handler = handler.next;
            }
        }

        return head;
        //track all nodes , O(N)

    }
}
