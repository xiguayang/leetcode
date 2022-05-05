package LinkedList;
/** #2 Add Two Numbers[M][Top100]
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order,
 * and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Initialize current node to dummy head of the returning list.
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        //Initialize p,q to the head of l1 and l2 respectively
        ListNode p = l1;
        ListNode q = l2;
        //Initialize carry to 0 : the variable carry 1 to next if sum >=10
        int carry = 0;
        //loop through l1 and l2 until reach both ends of the lists
        while(p!=null || q!=null){
            //set x to node p's value, if p reaches the end, set it to 0
            int x = 0;
            if(p!=null){
                x = p.val;
            }else{
                x=0;
            }
            //set y to node q's value, if q reaches the end, set it to 0
            int y = (q !=null) ? q.val : 0;
            //set sum to calculate the sum of x,y and also carry
            int sum = carry + x + y;
            //carry gets 1 if over 10, else 0
            carry = sum/10;
            //Create a new node with the digit value of (sum \bmod 10)(summod10)
            //set it to current node's next, then advance current node to next.
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            //advance p and q
            if(p!=null) p = p.next;
            if(q!=null) q = q.next;
        }
        //Check if carry = 1carry=1, if so append a new node with digit 11 to the returning list.
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;

    }
}
