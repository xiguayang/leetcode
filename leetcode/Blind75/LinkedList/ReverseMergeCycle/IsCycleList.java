package Leetcodes.Blind75.LinkedList.ReverseMergeCycle;

import Leetcodes.Blind75.LinkedList.ListNode;

public class IsCycleList {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        //slow, fast pointer
        //slow move 1 step, fast move 2 steps
        //if there is a cycle, they will meet
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        //Step1:check if fast and slow pointers meet 
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                // fast and slow meet
                // m is moves from head to intersection
                // n is the distcance between the position f and s meets with intersection
                // D is the total distances of the cycle
                // total moves of fast: m+ k1(D) + n
                // total moves of slow: m+ k2(D) + n
                // fast = 2slow: m+k1D + n = 2m +2k2D + 2n
                // m = (k1-2k2)D -n
                // so if slow continue moves and start a new pointer from head
                // they will meet at the intersection
                ListNode slow2 = head;
                while(slow2!=slow){
                    slow2=slow2.next;
                    slow = slow.next;
                }
                return slow;
                
            }
        }
        return null;//not a cycle
    }
}
