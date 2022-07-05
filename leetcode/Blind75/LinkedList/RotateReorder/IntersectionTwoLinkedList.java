package Leetcodes.Blind75.LinkedList.RotateReorder;

import Leetcodes.Blind75.LinkedList.ListNode;

public class IntersectionTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLenght(headA);
        int lenB = getLenght(headB);
        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB=headB.next;
            lenB--;
        }
        //now lenA == lenB
        //compare each node to get the intersection
        while(headA.val !=headB.val){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLenght(ListNode head) {
        int len = 0;
        ListNode cur =head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }
}
