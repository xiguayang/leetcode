public class RemoveElementsLinkedList {
    //interative method: 
    // must have a dummyNode to record new linkedlist
    //1. cur is the pointer always pointing to the previous node of head
    //2. traverse the linked list by head;
    //3. if head is at the position need to be removed, cur.next points to head.next
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode();
        ListNode cur = new ListNode();
        cur.next = head;
        dummyNode = cur;
        while(head!=null){
            if(head.val ==val){
                cur.next = head.next;
            }else{
                cur = cur.next;
            }
            head = head.next;

        }
        return dummyNode.next;
    }

    public ListNode removeElementsByRecursive(ListNode head, int val){
        //recursively removeElements of the right side linkedlist of head
        if(head ==null) return null;
        ListNode headRight = removeElementsByRecursive(head.next, val);
        if(head.val == val){
            return headRight;
        }else{
            head.next = headRight;
        }
        return head;
        
    }
}
