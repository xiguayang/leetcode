package Array;
/**
 * Deleting the last element of the Array: as a queue;
 *      Deleting from the end of an Array is the least time consuming of the three cases.
 *      Recall that insertion at the end of an Array was also the least time-consuming case for insertion.
 *
 * Deleting the first element of the Array: create a vacant spot at the 0th index.
 *      To fill that spot, we will shift the element at index 1 one step to the left.(o(n))
 *
 * Deletion at any given index:the empty space created by the deleted item will need to be filled.
 *      Each of the elements to the right of the index we're deleting at will get shifted to the left by one. (o(k)~~o(N))*/
public class ArrayDeletion {
    /**Given an array nums and a value val,
     * remove all instances of that value in-place
     * and return the new length.
     *
     * Constraints:
     *
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 50
     * 0 <= val <= 100*/
    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        for(int i=0;i<length; i++){
            if(nums[i]==val){
                //shift left all elements right behind x
                for(int j = i+1;j<length;j++){
                    nums[j-1]=nums[j];
                }
                length--;
                i--;
            }
        }
        return length;
    }
    /** move all the occurrences of this element to the end of the array. Use two pointers!*/
    public static int removeElementWithTwoPointers(int[] nums, int val) {
        int length = nums.length;
        int tail = length-1;
        for(int i = 0; i<length;i++){
            if(nums[i]==val){
                int temp = nums[i];
                //swap the element with the tail element
                nums[i]=nums[tail];
                nums[tail]=temp;

                tail--;
                length--;
                i--;
            }
        }
        return length;
    }

    /**Given a sorted array nums,
     * remove the duplicates in-place such that each element appears only once
     * and returns the new length.
     */
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        //the unique index points to every unique element
        int unique = 0;
        //bypass records the number of duplicated elements that unique needs to jump
        int bypass=1;
        //j is the index that unique element should be put into
        int j = 1;
        for(int i = 1;i<nums.length;i++){
            //if the element is duplicated, move on
            if(nums[i]==nums[unique]){
                bypass++;
                length--;
            }else{
                //swap the unique element with the duplicated element
                int temp = nums[j];
                nums[j]=nums[i];
                nums[i]=nums[j];
                //unique pointer jump to next unique element
                unique=unique+bypass;
                //restore bypass to 1
                bypass=1;
                j++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,2,3,0,4,5,0};
        int result = removeElement(nums,0);
        System.out.println(result);
    }
}
