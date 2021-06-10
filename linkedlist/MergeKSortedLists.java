package linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** # 23 Merge K sorted Lists[H][Top Interviews]
 * You are given an array of k linked-lists lists,
 * each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list
 * and return it
 *
 * Constraints:
 *      k == lists.length
 *      0 <= k <= 10^4
 *      0 <= lists[i].length <= 500
 *      -10^4 <= lists[i][j] <= 10^4
 *      lists[i] is sorted in ascending order.
 *      The sum of lists[i].length won't exceed 10^4.*/
public class MergeKSortedLists {
    /** Approach 1 : Brute Force
     * Travel all lists and get all nodes' values into an array
     * 	O(N)
     * Sort and iterate the array to get the propery value
     * 	O(NlogN)
     * Create a new node list add node one by one
     * 	O(N)*/
    public static ListNode mergeKLists(ListNode[] lists) {
        /**
        /**it's better to use arrayList*/
        List<Integer> al = new ArrayList<Integer>();
        for(ListNode ln : lists){
            while(ln!=null){
                al.add(ln.val);
                ln=ln.next;
            }
        }
        Collections.sort(al);

        ListNode result = new ListNode(0);
        ListNode cur = result;
        for(int i : al){
            ListNode x = new ListNode(i);
            cur.next = x;
            cur = cur.next;
        }
        cur.next = null;
        return result.next;
    }

    /**Approach 2: Compare one by one
     * Compare every k nodes (head of every linked list) and get the node with the smallest value.
     * Extend the final sorted linked list with the selected nodes.

     * Time complexity : O(kN) where k is the number of linked lists.
     * Almost every selection of node in final linked costs O(k) (k-1 times comparison).
     * There are N nodes in the final linked list.
     * Space complexity :
     * O(n) Creating a new linked list costs O(n) space.
     * O(1) It's not hard to apply in-place method - connect selected nodes instead of creating new nodes to fill the new linked list.*/
    public static ListNode mergeKListsTwo(ListNode[] lists) {
        /**compare the current node of each list, find the smallest one, put it to the new list
         * just move the cur pointer to next node
         * make next comparison*/
        ListNode result = new ListNode(0);
        ListNode dummyhead = result;
        //if the lists is empty just return null
        if(lists.length==0){return null;}
        //if only one list, return the list
        if(lists.length==1){return lists[0];}
        //smallIndex records the list which has current small node
        int smallIndex= 0;
        //emptyList used to count the number of lists whose current nodes has arrived the end
        int emptyList=0;
        while(true){
            emptyList=0;
            for(int i=0;i<lists.length;i++){
                if(lists[smallIndex]==null){
                    smallIndex=i;
                }
                if(lists[i]==null){
                    //if the list arrives the end,
                    // add one to emptyList and jump to next list
                    emptyList++;
                    continue;
                }
                if(lists[i].val<lists[smallIndex].val){
                    smallIndex = i;
                }
            }
            //if the node at smallIndex is not null, add it to the result, and move to next
            if(lists[smallIndex]!=null) {
                dummyhead.next = new ListNode(lists[smallIndex].val);
                lists[smallIndex] = lists[smallIndex].next;
            }else{
                //if the node at smallIndex is null, set smallIndex to 0
                smallIndex=0;
            }
            //move dummyhead to next
            if(dummyhead!=null){
                dummyhead = dummyhead.next;
            }
            //if all the lists has been traversed
            if(emptyList>=lists.length){
                break;
            }

        }
        if(dummyhead!=null){
            dummyhead.next = null;
        }

        return result.next;
    }


    /**Approach 3: Compare one by one use Priority Queue*/

    /**Approach 4: Merge list one by one
     * Complexity Analysis:
     * Time complexity : O(kN) where k is the number of linked lists.
     * We can merge two sorted linked list in O(n) time where nn is the total number of nodes in two lists.
     * Sum up the merge process and we can get: O(kN)
     * Space complexity : O(1)*/
    public static ListNode mergeKListsFour(ListNode[] lists){
        if(lists.length==1){
            return  lists[0];
        }if(lists.length == 0){
            return  null;
        }
        ListNode head = mergeTwoLists(lists[0],lists[1]);
        for(int i =2;i<lists.length;i++){
            head = mergeTwoLists(head,lists[i]);
        }
        return head;
    }
    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode result = new ListNode();
        ListNode handler = result;
        while(l1!=null && l2!=null) {
            if (l1.val < l2.val) {
                handler.next = l1;
                l1 = l1.next;
            } else {
                handler.next = l2;
                l2 = l2.next;
            }
            handler = handler.next;
        }
            if(l1 ==null){
                handler.next = l2;
            }
            if(l2==null){
                handler.next = l1;
            }
            return result.next;

    }

    /**Approach 5: Merge with Divide And Conquer
     * Intuition & Algorithm:
     * This approach walks alongside the one above but is improved a lot.
     * We don't need to traverse most nodes many times repeatedly
     *          Pair up k lists and merge each pair.
     *          After the first pairing, k lists are merged into k/2k/2 lists with average 2N/k2N/k length,
     *          then k/4k/4, k/8k/8 and so on.
     *          Repeat this procedure until we get the final sorted linked list.
     * Thus, we'll traverse almost NN nodes per pairing and merging,
     * and repeat this procedure about log2(k) times
     */
    public static ListNode mergeKListsFive(ListNode[] lists){
        if(lists.length==1){
            return  lists[0];
        }if(lists.length == 0){
            return  null;
        }
        int len = lists.length;

        while(len>1){
            len= (len+1)/2;
            for(int i = 0;i<len;i++){

                if((i+len)>=lists.length){
                    break;
                }else{
                    lists[i]= mergeTwoLists(lists[i],lists[i+len]);
                }
            }
        }
        return lists[0];
    }

    public static void main(String[] args) {
        ListNode result = new ListNode();
        ListNode[] lists = new ListNode[5];
        lists[0]=new ListNode(new int[]{1});
        lists[1]=null;
        lists[2]=null;
        //result  = mergeKListsTwo(lists);
        lists[0]=new ListNode(new int[]{-6,-3,-1,1,2,2,2});
        lists[1]=new ListNode(new int[]{-10,-8,-6,-2,4});
        lists[2]=new ListNode(new int[]{-2});
        //result  = mergeKListsTwo(lists);
        //[[-6,-3,-1,1,2,2,2],[-10,-8,-6,-2,4],[-2],[-8,-4,-3,-3,-2,-1,1,2,3],[-8,-6,-5,-4,-2,-2,2,4]]
        /**
        ListNode[] lists2 = new ListNode[1];
        lists2[0]=new ListNode(new int[]{1});
        result  = mergeKListsTwo(lists2);
        result.printList();
        ListNode[] lists3 = new ListNode[2];
        lists3[0]=null;
        lists3[1]=new ListNode(new int[]{1});
        result  = mergeKListsTwo(lists3);
*/
        lists[3]=new ListNode(new int[]{-8,-4,-3,-3,-2,-1,1,2,3});
        lists[4]=new ListNode(new int[]{-8,-6,-5,-4,-2,-2,2,4});
        result  = mergeKListsFive(lists);
        result.printList();



    }
}
