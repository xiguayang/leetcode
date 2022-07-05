package Leetcodes.Blind75.LinkedList.ReverseMergeCycle;

import Leetcodes.Blind75.LinkedList.ListNode;

public class MergeKSortedLinkedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0 || lists==null){
            return null;
        }
        return divideAndConquerMerge(lists, 0, lists.length-1);
    }

    private ListNode divideAndConquerMerge(ListNode[] lists, int lo, int hi) {
        if(lo>hi) return null;
        // size = 1
        if(lo == hi) return lists[lo];
        int mid = lo+(hi-lo)/2;
        ListNode left = divideAndConquerMerge(lists, lo, mid);
        ListNode right = divideAndConquerMerge(lists, mid+1, hi);
        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode cur = new ListNode(-1);
        ListNode dummy = cur;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                cur.next =l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur = cur.next;
        }
        if(l1==null){
            cur.next = l2;
        }
        if(l2==null){
            cur.next=l1;
        }
        return dummy.next;
    }
}
