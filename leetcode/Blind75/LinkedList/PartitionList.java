package Leetcodes.Blind75.LinkedList;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        //using 2 sublist: smallList is store all nodes < x
        //                 largeList is used to store all nodes >=x
        // records the tails for the 2 sublists for merging 
        ListNode small = new ListNode(0);
        ListNode smallTail = small;
        ListNode large = new ListNode(0);  
        ListNode largeTail = small;
        while(head!=null){
            if(head.val<x){
                smallTail.next = head;
                smallTail= smallTail.next;
            }else{
                largeTail.next = head;
                largeTail=largeTail.next;
            }
            head=head.next;
        }
        //after traverse all nodes of the list
        smallTail.next = large.next;
        largeTail.next = null;
        return small.next;
    }
}
