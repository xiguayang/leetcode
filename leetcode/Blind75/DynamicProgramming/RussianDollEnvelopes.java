package Leetcodes.Blind75.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        //Step1: sort the envelops by the width
        // for envelops with same width: cannot fit into same width or same height
        // so sort height by des if have same width to avoid fit into it
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){//if same width, sort height by desc
                    return b[1]-a[1];
                }else{
                    return a[0]-b[0];
                }
            }
        });

        //Step2: after sorting the width, find the LIS of height
        //envelopes[i][1]
        int[] heights = new int[envelopes.length]; 
        for(int i=0;i<envelopes.length;i++){
            heights[i]=envelopes[i][1];
        }
        return findLIS(heights);

    }
    private int findLIS(int[] nums){
        int[] dp = new int[nums.length];
        //base case
        dp[0]=1;
        int res = 1;
        for(int i=1;i<nums.length;i++){
            int max =1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    max=Math.max(max,dp[j]+1);
                }
            }
            dp[i]=max;
            res=Math.max(res,dp[i]);
        }
        return res;
    }
    
}
