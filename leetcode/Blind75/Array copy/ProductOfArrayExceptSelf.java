package Leetcodes.Blind75.Array;

public class ProductOfArrayExceptSelf {

    // 1, 2, 3, 4
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        //first loop: caculate prefix of each element 
        int prefix =1;
        for(int i =0;i<nums.length;i++){
            result[i]=prefix;
            prefix = prefix*nums[i];
        }
        // 1, 1, 2, 6
        //second loop from end, calculate suffix and multiply with the corresponding prefix
        int suffix = 1;
        //4*3*2*1 4*3*1, 4*2, 1*6
        for(int i=nums.length-1;i>=0;i--){
            result[i]= result[i]*suffix;
            suffix=suffix*nums[i];
        }
        return result;

    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        productExceptSelf(nums);
    }
    
}
