package Leetcodes.Blind75.Bit;

public class MissingNum {
    public int missingNumber(int[] nums) {
        // //using XOR
        // int res =0;
        // for(int i=0;i<nums.length;i++){
        //     res = res ^ i ^ nums[i];
        // }
        // return res^nums.length;
        
        //using sum
        int res =0;
        for(int i=0;i<nums.length;i++){
            res =res+i-nums[i];
        }
        return res+nums.length;
    }
}
