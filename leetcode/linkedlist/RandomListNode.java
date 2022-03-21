package linkedlist;

public class RandomListNode {
    public int val;
    public RandomListNode next;
    public RandomListNode random;
    public RandomListNode() {}
    public RandomListNode(int val) { this.val = val; this.next = null; this.random = null;}
    public RandomListNode(int val, RandomListNode next, RandomListNode random) { this.val = val; this.next = next;this.random= random; }

    public void add(RandomListNode x){
        this.next = x;
        x.next = null;

    }

    public void printList(){
        System.out.print("{"+this.val+", ");
        RandomListNode p = new RandomListNode();
        for(p = this.next;p.next!=null;p=p.next){
            System.out.print(p.val + ", ");
        }
        System.out.println(p.val+ "}");
    }
    public static void main(String[] args) {


        //RandomListNode l1 = new RandomListNode(arr);
        //System.out.print(l1.val);
       // l1.printList();
    }
}
