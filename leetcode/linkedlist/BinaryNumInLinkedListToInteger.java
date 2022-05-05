package LinkedList;
/**#1290 Binary Number in Linked List to together [E]
 * Given head which is a reference node to a singly-linked list.
 * The value of each node in the linked list is either 0 or 1.
 * The linked list holds the binary representation of a number.
 * Return the decimal value of the number in the linked list.*/
/**Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 * Input: head = [0]
 * Output: 0
 * Example 3:
 * Input: head = [1]
 * Output: 1
 * Example 4:
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 *  Output: 18880
 * Example 5:
 * Input: head = [0,0]
 * Output: 0*/
public class BinaryNumInLinkedListToInteger {
    /**Approach 1*/
    public int getDecimalValue(ListNode head) {
        ListNode current = new ListNode();
        current = head;
        int[] values = new int[30];
        int i =0;

        while(current.next!=null){
            values[i] = current.val;
            current = current.next;
            i++;
        }
        values[i] = current.val;

        int result = 0;
        int j = 0;
        while(i>=0){
            result = result + values[j]*(int)Math.pow(2,i);
            j++;
            i--;
        }
        return result;
    }

    /**Approach 2*/
    public int getDecimalValue2(ListNode head) {
        //decimalvalue :parse the list node from left to right: num = num*2+x;
        int result = head.val;
        while(head.next !=null){
            result = result*2+head.next.val;
            head = head.next;
        }
        return result;
    }
}
