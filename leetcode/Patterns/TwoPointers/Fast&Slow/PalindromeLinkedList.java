/**234. Palindrome Linked List */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next ==null) return true;
        //1. get the middle of the linkedlist by fast/slow pointers
        //2. reverse the right half linked list
        //3. compare the left half and right reversed half list one by one
        
        ListNode mid = getMidNode(head);
        ListNode reverseHalf = reverse(mid);
        while(reverseHalf!=null){
            if(head.val == reverseHalf.val){
                head = head.next;
                reverseHalf= reverseHalf.next;
            }else{
                return false;
            }

        }
        return true;


    }
    private ListNode getMidNode(ListNode head){
        if(head ==null || head.next==null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        if(head ==null || head.next==null) return head;
        ListNode cur = head;
        ListNode pre = null;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next=pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
