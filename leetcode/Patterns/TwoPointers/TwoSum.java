//1. Two Sum, easy
//Using 2 Pointers O(NlogN) for sort and O(N) space
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

//You may assume that each input would have exactly one solution, and you may not use the same element twice.

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //step1: sort the array firstly
        //step2: since array is sorted, using 2 pointers,
        //       one at the head, one at the end
        //       add the nums they pointing to
        //step3: if the sum > target, end pointer move forward
        //       if the sum < target, head pointer move backward
        //step4: return requires the indexes, so we need to copy the original array to sort, and get the original indexes as results
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);
        int head = 0;
        int end =numsCopy.length-1;
        while(head<end){
            int sum = numsCopy[head]+numsCopy[end];
            if(sum > target){
                end --;
            }else if(sum < target){
                head ++;
            }else{
                break;
            }
        }
        //now get the original indexes.
        //for original array, traverse from start, if find the first responding element, break; traverse from the end again to find the second responding element position. ==> since the elements may be the same value with different position[3,3] target 6
        int[] result = new int[2];
        for(int i =0;i<nums.length;i++){
            if(nums[i]==numsCopy[head]){
                result[0]=i;
                break;
            }
        }
        for(int i =nums.length-1;i>=0;i--){
            if(nums[i]==numsCopy[end]){
                result[1]=i;
                break;
            }
        }

        return result;
    }
}
