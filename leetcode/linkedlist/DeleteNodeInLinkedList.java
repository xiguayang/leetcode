package linkedlist;
/** #237 Delete the given node in linked list directly [E]
 * Write a function to delete a node in a singly-linked list.
 * You will not be given access to the head of the list,
 * instead you will be given access to the node to be deleted directly.
 * It is guaranteed that the node to be deleted is not a tail node in the list.
 * */
public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        //replace the value of the node with the next node's value
        //then remove the next node
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }
}
