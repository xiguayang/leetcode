package Leetcodes.Blind75.LinkedList.DeleteCopySturctureTrans;

import java.util.ArrayList;

import Leetcodes.Blind75.LinkedList.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindromeUsingArray(ListNode head) {
        //Method 1: using array to store the nodes
        //   2 pointers from array start and end to be compared
        // O(n), O(n)
        ArrayList<Integer> arr = new ArrayList<>();
        while(head!=null){
            arr.add(head.val);
            head=head.next;
        }
        int i=0;
        int j = arr.size()-1;
        while(i<=j){
            if(arr.get(i)!=arr.get(j)) return false;
            i++;
            j--;
        }
        return true;
    }
        //Method 2:  Space O(1)
        //1. find the middle node of the linkedlist
        //2. reverse the right half part
        //3. compare the 2 parts
        public boolean isPalindrome(ListNode head) {
            if(head.next ==null) return true;
            //Step 1: using fast/slow pointers to find mid
            // 1 -> 2 -> 3 -> 2 -> 1 -> 2
            //                              f
            //                s
            ListNode fast = head;
            ListNode slow = head;
            //middle: the mid of odd length: ...slow...
            //        the first one of right half for even length: ....slow ...
            while(fast!=null && fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            }
            // now slow is the first node of right half
            //Step2: start to reverse right half
            ListNode pre = null;
            while(slow!=null){
                ListNode temp = slow.next;
                slow.next=pre;
                pre = slow;
                slow=temp;
            }
            //now pre is the head of the reversed right half
            //Step3: compare the 2 sub lists
            //right half: pre --> null
            //right.length> left.length 
            while(pre!=null){
                if(head.val!=pre.val) return false;
                head = head.next;
                pre = pre.next;
            }
            return true;
        }

        
}
