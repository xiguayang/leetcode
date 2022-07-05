package Leetcodes.Blind75.LinkedList;

import java.util.ArrayList;

public class LinkedList {

        // Head of the list
        Node head;
        Node left;

        public class Node
        {
            public int val;
            public Node next;

            // Linked list node
            public Node(int d)
            {
                val = d;
                next = null;
            }
        }

        // Initial parameters to this function are
        // &head and head
        boolean isPalindromeUtil(Node right)
        {
            left = head;
            // Stop recursion when right becomes null
            if (right == null)
                return true;

            // If sub-list is not palindrome then no need to
            // check for the current left and right, return
            // false
            boolean isp = isPalindromeUtil(right.next);
            if (isp == false)
                return false;

            // Check values at current left and right
            boolean isp1 = (right.val == left.val);


            // Move left to next node;
            return isp1;
        }

        // A wrapper over isPalindrome(Node head)
        boolean isPalindrome(Node head)
        {
            boolean result = isPalindromeUtil(head);
            return result;
        }

        public boolean isPalindromeUsingArray(Node head) {
            //Method 1: using array to store the nodes
            //   2 pointers from array start and end to be compared
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
        public boolean isPalindromeReverse(Node head) {
            if(head.next ==null) return true;
            //Step 1: using fast/slow pointers to find mid
            // 1 -> 2 -> 3 -> 2 -> 1 -> 2
            //                              f
            //                s
            Node fast = head;
            Node slow = head;
            //middle: the mid of odd length: ...slow...
            //        the first one of right part for even length: ...slow..
            while( fast!=null&& fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            }
            // now slow is the first node of right half
            //Step2: start to reverse right half
            //System.out.println(slow.val);
            Node pre = null;
            while(slow!=null){
                Node temp = slow.next;
                slow.next=pre;
                pre = slow;
                slow=temp;
            }
           // printList(head);
            //printList(pre);
            //now pre is the head of the reversed right half
            //Step3: compare the 2 sub lists
            //  since the half right is longer than left sublist(for odd length)
            while(pre!=null){
               // System.out.println(pre.val);
                //System.out.println(head.val);
                if(head.val!=pre.val) return false;
                head = head.next;
                pre = pre.next;
                
            }
            return true;
        }
        // Push a node to linked list. Note that
        // this function changes the head
        public void push(int new_data){

            // Allocate the node and put in the data
            Node new_node = new Node(new_data);

            // Link the old list off the the new one
            new_node.next = head;

            // Move the head to point to new node
            head = new_node;
        }

        // A utility function to print a
        // given linked list
        void printList(Node ptr)
        {
            while (ptr != null)
            {
                System.out.print(ptr.val + "->");
                ptr = ptr.next;
            }
            System.out.println("Null");
        }

        // Driver Code
        public static void main(String[] args)
        {
            LinkedList llist = new LinkedList();
            int[] nums = { 1,2,3,4,2,1};
            for(int i = 0; i < 6; i++)
            {
                llist.push(nums[i]);
                llist.printList(llist.head);

            }
            if (llist.isPalindromeReverse(llist.head))
            {
                System.out.println("Is Palindrome");
                System.out.println("");
            }
            else
            {
                System.out.println("Not Palindrome");
                System.out.println("");
            }
        }
        
}
