package linkedlist;
/** #328. Odd Even Linked List[M][TopInterviews]
 * Given the head of a singly linked list,
 * group all the nodes with odd indices together
 * followed by the nodes with even indices,
 * and return the reordered list.
 * The first node is considered odd,
 * and the second node is even, and so on.
 *
 * Constraints:
 * The number of nodes in the linked list is in the range [0, 104].
 * -106 <= Node.val <= 106*/
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        //the number of Nodes is less than 3, just return itself
        if(head == null || head.next == null || head.next.next==null){
            return head;
        }
        //>=3, create a new Node point to the second node as the dummyEven
        ListNode dummyEven = new ListNode();
        dummyEven = head.next;
        //create 2 pointer, odd pointer connect all odd nodes while even connect all even nodes
        ListNode odd = head;
        ListNode even = odd.next;
        //loop the list, until even arrives the last node
        while(even.next!=null){
            odd.next = even.next;
            odd = odd.next;

            if(odd.next!=null){
                even.next = odd.next;
                even = odd.next;
            }else{
                //odd arrives the last node
                even.next = null;
            }
        }
        odd.next = dummyEven;
        return head;
    }
}
