package Patterns.TwoPointers;
/**#83 Remove Duplicates from sorted linked list */
public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head ==null ||head.next ==null) return head;
        //The linked list is sorted.
        ListNode cur = head;    
        while(cur.next!=null){
            
            if(cur.val ==cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur= cur.next;
            }
        }
        return head;
    }


    /**
 * 删除排序数组中的重复项 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 输入：nums =
 * [0,0,1,1,1,2,2,3,3,4] 输出：5, nums = [0,1,2,3,4] tags: array, double pointers
 */

    // use two pointers, left points to the last unique one,
    // right points to next one to be compared
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // use two pointers, the left pointer starts from 0
        // the right pointer starts from 1 and traverse to the end
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            // if the right pointer points to an element different with left pointer points
            // to
            // the left pointer moves to next,exchange the element to the one right points
            // to
            // else just move the right to next element
            if (nums[left] != nums[right]) {
                left = left + 1;
                nums[left] = nums[right];
            }
            right = right + 1;
        }
        // the left points to the last different element, the lenght is left +1
        return left + 1;

    }

    
}
