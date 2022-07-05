package Leetcodes.Blind75.LinkedList.ReverseMergeCycle;

import Leetcodes.Blind75.LinkedList.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        //using merge sort
        //1. find the mid of the list
        //2. seperate the list to 2 sublists: [head -> ...-> mid ->null]
        //                                    [mid.next -> ... -> end-> null]
        //3. recursively merge sort th sublists
        //4. merge 2 sorted sublist

        //base case:
        if(head == null || head.next ==null) return head;
        ListNode left = head;
        ListNode mid = findMid(head);
        //break the list into to sublist
        ListNode right = mid.next;
        mid.next = null;
        //sort two sublist recursively
        left = sortList(left);
        right = sortList(right);
        return mergeSortedList(left,right);
    }
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            // 1, 2, 3, 4, 5, 6
            //              f
            //       s
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private ListNode mergeSortedList(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                cur.next = l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        if(l1==null) cur.next = l2;
        if(l2==null) cur.next = l1;
        return dummy.next;
        
    }


}
