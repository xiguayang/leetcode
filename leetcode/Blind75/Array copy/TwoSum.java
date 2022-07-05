package Leetcodes.Blind75.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class TwoSum {
    //return all the pairs adding  to target, without duplicates
    public static List<List<Integer>> twoSum (int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        //Sort the array
        Arrays.sort(nums);
        // 1, 1, 1, 3, 4, 6, 6, 7, 8 
        //target: 7
        //==> (3, 4), (1, 6)
        //2 pointers 
        int left = 0;
        int right = nums.length-1;
        // start from 0, and length-1
        while(left<=right){
            if(nums[left]+nums[right]==target){
                res.add(new ArrayList<>( List.of(nums[left], nums[right])));
                //check if same to avoid duplicates
                while(nums[right-1]==nums[right] && left<right){
                    right=right-1;
                }
                right=right-1;
                while(nums[left+1]==nums[left] && left<right){
                    left=left+1;
                }
                left=left+1;
                
            }else if(nums[left]+nums[right]>target){
                right=right-1;
            }else{
                left=left+1;
            }
        }
        return res;
    }
    public static int[] twoSumHashMap(int[] nums, int target){
        //Time: O(N); Memory: O(N)
        if(nums.length<2) return new int[]{-1,-1};
        Map<Integer, Integer> preVMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(preVMap.containsKey(target - nums[i])){
                return new int[]{i,preVMap.get(target-nums[i])};
            }else{
                preVMap.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }
    public static List<List<Integer>> twoSumHashMapNoDuplicates(int[] nums, int target){
        //Time: O(N); Memory: O(N)
        if(nums.length<2) return null;
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> preVMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int remain = target-nums[i];
            if(preVMap.containsKey(remain)){
                if(preVMap.get(remain)==0){
                    res.add(Arrays.asList(nums[i], remain));
                    preVMap.put(nums[i], 1);
                    preVMap.put(remain, 1);
                }
            }else {
                preVMap.put(nums[i], 0);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,3,4,7 ,1,4,4,4, 7,7, 8  };
        int target = 8;
        //int [] res  = new int[2];
        //twoSum(nums, target);
       // List<List<Integer>> res= twoSum(nums, target);
        List<List<Integer>> res2=twoSumHashMapNoDuplicates(nums, target);
        for(List<Integer> l: res2){
            for(Integer i: l){
                System.out.print(i+" ,");
            }
            System.out.println();
        } 
    }
    
}
