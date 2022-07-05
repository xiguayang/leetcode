package Leetcodes.Blind75.LinkedList.ReverseMergeCycle;

import org.xml.sax.ext.Locator2Impl;

import Leetcodes.Blind75.LinkedList.ListNode;

public class AddTwoNums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //Initialize current node to dummy head of the returning list.
            ListNode dummyHead = new ListNode(0);
            ListNode curr = dummyHead;
            //Initialize carry to 0 : the variable carry 1 to next if sum >=10
            int carry = 0;
            //loop through l1 and l2 until reach both ends of the lists
            while(l1!=null || l2!=null){
                //set x to node p's value, if p reaches the end, set it to 0
                int x = l1!=null ? l1.val:0;
                //set y to node q's value, if q reaches the end, set it to 0
                int y = (l2 !=null) ? l2.val : 0;
                //set sum to calculate the sum of x,y and also carry
                int sum = carry + x + y;
                //carry gets 1 if over 10, else 0
                carry = sum/10;
                //Create a new node with the digit value of (sum \bmod 10)(summod10)
                //set it to current node's next, then advance current node to next.
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                //advance p and q
                if(l1!=null) l1 = l1.next;
                if(l2!=null) l2= l2.next;
            }
            //Check if carry = 1carry=1, if so append a new node with digit 11 to the returning list.
            if(carry > 0){
                curr.next = new ListNode(carry);
            }
            return dummyHead.next;
        }
}
