package linkedlist;

public class PalindromeList {
    public static boolean isPalindrome(ListNode head) {
        /**if reverse entire list, the original list changes, can't compare the original list with the reversed one
         * find the middle of the list
         * reverse the right half of the list
         * and compare the right half list with the left*/
        ListNode midNode = middleNode(head);
        ListNode reverseRight = reverse(midNode);
        while(reverseRight!=null){
            if(reverseRight.val != head.val){
                return false;
            }
            else{
                reverseRight = reverseRight.next;
                head = head.next;
            }
        }
        return true;
    }
    public static ListNode middleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp  = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode l = new ListNode(new int[]{1,2,2, 1});
        //ListNode re = reverse(l);
        l.printList();
        //re.printList();
        System.out.println(isPalindrome(l));
    }
}
