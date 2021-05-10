package linkedlist;
/**#21 [E]
 * Merge two sorted linked lists and return it as a sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * Constraints:
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both l1 and l2 are sorted in non-decreasing orde*/
public class Merge2SortedList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode handler = result;

        if(l1==null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                handler.next = l1;
                l1=l1.next;
            }else{
                handler.next = l2;
                l2 = l2.next;
            }
            handler=handler.next;
        }
        if(l1==null){
            handler.next= l2;
        }
        if(l2==null){
            handler.next = l1;
        }
        return result.next;

    }
/**Input: l1 = [1,2,4], l2 = [1,3,4]
 Output: [1,1,2,3,4,4]
 Example 2:
 Input: l1 = [], l2 = []
 Output: []
 Example 3:
 Input: l1 = [], l2 = [0]
 Output: [0]*/
    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{1, 2, 4});
        ListNode l2 = new ListNode(new int[]{1, 3, 4});
        ListNode result = Merge2SortedList.mergeTwoLists(l1,l2);
        result.printList();
        ListNode l3 = new ListNode();
        result = Merge2SortedList.mergeTwoLists(l3,l3);
        result.printList();
        ListNode l4 = new ListNode(0);
        result = Merge2SortedList.mergeTwoLists(l3,l4);
        result.printList();
    }
}
