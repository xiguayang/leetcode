// 21. Merge 2 Sorted Lists
package Patterns.TwoPointers;

import java.util.*;
public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dumyNode = new ListNode();
        ListNode pointer = dumyNode;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                pointer.next = list1;
                list1 = list1.next;
            }else{
                pointer.next = list2;
                list2= list2.next;
            }
            pointer = pointer.next;
        }
        if(list1==null){
            pointer.next = list2;
        }
        if(list2==null){
            pointer.next = list1;
        }
        return dumyNode.next;

    } 
}
