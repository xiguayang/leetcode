package LinkedList;
/**#876 [E]
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.*/
public class MiddleNode {
    /**Approach 1: Time: O(N) Space: O(n)*/
    public static ListNode middleNode(ListNode head) {
        int len = length(head);
        int mid = len/2;
        ListNode middle = head;
        int i = 0;
        while(i<mid){
            middle = middle.next;
            i++;
        }
        return middle;
    }
    private static int length(ListNode head){
        int len = 0;
        while(head!=null){
            head = head.next;
            len++;
        }
        return len;
    }

    /**Approach2 : Time: O(n); Space: O(1)*/
    public static ListNode middleNodeBy2Pointers(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }
    public static void main(String[] args) {
        //int[] arr = {1,3,4,5,6,2};
        int[] arr2 = {1,3,4,5,6,7};
        //ListNode l1 = new ListNode(arr);
        ListNode l2 = new ListNode(arr2);
        //ListNode mid1= middleNode(l1);
        ListNode mid2 = middleNodeBy2Pointers(l2);
        //mid1.printList();
        mid2.printList();
    }
}
