package linkedlist;

/**Definition for singly-linked list.*/
public class ListNode{
    public int val;
    //private int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**A constructor that takes in an array of integers*/
    public ListNode(int[] arr ){
        //ListNode nxxxx = new ListNode(arr[arr.length-1],null);
        //ListNode nxxx= new ListNode(arr[arr.length-2],nxxxx);
        //ListNode nxx= new ListNode(arr[arr.length-3],nxxx);
        //ListNode nx= new ListNode(arr[arr.length-4],nxx);
        //ListNode next= new ListNode(arr[arr.length-5],nx);
        //next = new ListNode(arr[arr.length -1], null);
        //val = arr[arr.length -1];
        for(int i = arr.length -1;i>0;i--) {
            next = new ListNode(arr[i], next);
        }
        val = arr[0];

    }

    public void printList(){
        System.out.print("{"+this.val+", ");
        ListNode p = new ListNode();
        for(p = this.next;p.next!=null;p=p.next){
            System.out.print(p.val + ", ");
        }
        System.out.println(p.val+ "}");
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,2};

        ListNode l1 = new ListNode(arr);
        //System.out.print(l1.val);
        l1.printList();
    }
}