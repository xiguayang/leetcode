package Leetcodes.Blind75.LinkedList.ReverseMergeCycle;

import Leetcodes.Blind75.LinkedList.ListNode;

public class MergeTwoSortedLinkedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //corner case
        if(list1==null) return list2;
        if(list2==null) return list1;
        
        ListNode res = new ListNode(-1);
        ListNode dummy = res;
        while(list1!=null && list2!=null){
            if(list1.val <=list2.val){
                res.next =list1;
                list1 = list1.next;
            }else{
                res.next=list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        if(list1==null){res.next = list2;}
        if(list2==null){res.next = list1;}
        return dummy.next;
        
    }
    public static void main(String[] args) {
        
    }
    
}
