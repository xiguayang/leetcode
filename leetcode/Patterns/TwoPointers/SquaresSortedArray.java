/**
 * 977. Squares of a Sorted Array[E]
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * the given array is sorete but may has negtive num
 * [-4, 1, 3, 5] ==> [16, 1, 9, 25] ===> [1,9,16,25]
 * need sorted again
 * Follow up: O(N) using 2 pointers
 */
public class SquaresSortedArray {
    //Using 2 Pointers, one at the start and one at the end
    //put them into result from the end(sorted, so the larger one is at then end)
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[] result = new int[nums.length];
        int index = right;
        while(left<=right){
            if(Math.abs(nums[right])>Math.abs(nums[left])){
                result[index] =(int)Math.pow(nums[right],2);
                
                right --;
            }else{
                result[index]=(int)Math.pow(nums[left],2);
                left ++;
            }
            //System.out.println(result[index]+" "+left+" "+ right);
            index --;
        }
        return result;
        
    }
    
}
