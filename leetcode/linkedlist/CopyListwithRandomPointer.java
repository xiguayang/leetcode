package linkedlist;
/** #138. Copy List with Random Pointer
 * A linked list of length n is given
 * such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list.
 * The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes
 * in the copied list such that the pointers in the original list
 * and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 * The linked list is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to,
 * or null if it does not point to any node.
 *
 * Constraints:
 *
 * 0 <= n <= 1000
 * -10000 <= Node.val <= 10000
 * Node.random is null or is pointing to some node in the linked list.*/

/**The algorithm is composed of the follow three steps which are also 3 iteration rounds.

 1.    Iterate the original list and duplicate each node. The duplicate
 of each node follows its original immediately.
 2.    Iterate the new list and assign the random pointer for each
 duplicated node.
 3.    Restore the original list and extract the duplicated nodes.*/
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head){
        if(head == null) return head;
        RandomListNode iter = new RandomListNode();
        iter = head;
        RandomListNode nextNode = new RandomListNode();
        //1. Iterate the original list and duplicate each node.
        while(iter!=null){
            //next is the node after iter, iter starts from head
            nextNode = iter.next;
            //make a copy of iter
            RandomListNode copy = new RandomListNode(iter.val);
            //add the copy node between iter and next
            iter.next = copy;
            copy.next = nextNode;
            //iter move to next node
            iter = nextNode;
        }
        //2. Iterate the new list and assign the random pointer for each duplicated node.
        //move the iter node to the left head
        iter = head;
        while(iter !=null){
            if(iter.random !=null){
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        //3. restore the original list, and extract the copy list.
        iter = head;
        RandomListNode copyhead = iter.next;
        RandomListNode copy = copyhead;
        while(iter!=null){
            nextNode = iter.next.next;
            copy = iter.next;
            iter.next = nextNode;
            if (nextNode != null) {
                copy.next = nextNode.next;
            }
            iter = nextNode;
        }
        return copyhead;
    }
}
