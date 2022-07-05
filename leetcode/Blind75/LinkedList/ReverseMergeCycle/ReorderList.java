package Leetcodes.Blind75.LinkedList.ReverseMergeCycle;

import Leetcodes.Blind75.LinkedList.ListNode;

public class ReorderList {
    // - Step1: using fast & slow pointers to find the middle of the list
    //          fast.next==null || fast.next.next==null ==>slow is now the last of left half
    // - Step2: reverse the half after slow
    // - Step3: start reorder one by one of the left and right half, remember to set last one.next=null
    public void reorderList(ListNode head) {
        if(head ==null|| head.next==null) return;
        //Step1: find the middle 
        ListNode f = head;
        ListNode s = head;
        ListNode leftEnd = null;// will be the last node of left half
        while(f!=null && f.next!=null){
            leftEnd = s;
            s=s.next;
            f=f.next.next;
        }
        //need to cut the left half
        leftEnd.next = null;
        // now s is the first node of right half
        //Step2: reverse the right half after s
        ListNode pre = null;
        while(s!=null){
            ListNode temp = s.next;
            s.next = pre;
            pre=s;
            s=temp;
        }

        //Step3: Start reorder one by one
        //merge 2 sub linked list
        //length of right half >= length of left half
        ListNode p1 = head;//left half
        ListNode p2 = pre;//right half
        //while(p2!=null){//right half >= left half
            // A tricky approach
            // ListNode temp = p1.next;
            // p1.next =p2;
            // p1 = p2;
            // p2 = temp;
       // }
        while(p1!=null){
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p1.next = p2;
            if(temp1 ==null) break;
            p2.next=temp1;
            p1=temp1;
            p2=temp2;
        }

    }
    
}
