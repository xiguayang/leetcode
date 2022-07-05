package Leetcodes.Blind75.Array;
import java.util.*;
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            //skip same element
            if(i>0 && nums[i]== nums[i-1]){
                continue;
            }
            int l = i+1;
            int r =nums.length-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r]>0){
                    r=r-1;
                }else if(nums[i]+nums[l]+nums[r]<0){
                    l=l+1;
                }else{//same to 0
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    //skip duplicates
                    while(nums[l]==nums[l-1] && l<r ){
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
