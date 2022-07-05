package Leetcodes.Blind75.DynamicProgramming;


//300
public class LongestIncreasingSubsequence {
        //Method1: DP: O(n^2)
        public int lengthOfLIS(int[] nums) {
            int res = 1;
            //base case
            int[] dp = new int[nums.length];
            //find the LIS for the subarray ends at nums[i]
            //dp[i] is the LIS for the subarray ends at nums[i]
            for(int i =0; i< dp.length; i++){
                //find all elements in nums[...i-1] that is < nums[i]
                int max=0;
                //==> get the max value of dp[j], j is between [0,i)
                for(int j=i-1;j>=0;j--){
                    if(nums[j]<nums[i]){
                        max=Math.max(dp[j],max);
                    }
                }
                //append nums[i] means length+1, dp[i]=max+1;
                dp[i]=max+1;
                //res is the max of the dp[i]
                res= Math.max(dp[i],res);
            }
            //return the max of dp[]
            return res;
        }

        //Method 2: using binarySearch
        public int lengthOfLISBinarySearch(int[] nums) {
            //patience sorting
            //each element in nums to be deal with
            //将元素看成纸牌，纸牌只能叠加在比他大堆纸牌上，如果没有就重新起一列
            //piles is the number of piles, 列数
            int piles = 0;
            //tops 是所有列上最顶端的纸牌点数
            int[] tops = new int[nums.length];
            for(int i=0;i<nums.length;i++){
                //the number to be dealed with
                int num = nums[i];
                //新一张纸牌选择比他大点大的列， 用二分法选择top点数最小的一列
                //top[i] >= num where i is the smallest
                int left = 0;
                int right = piles;
                while(left<right){
                    int mid = (left+right)/2;
                    if(tops[mid]<num){
                        left=mid+1;
                    }else if(tops[mid]>num){
                        right=mid;
                    }else{
                        //tops[mid]== num
                        right = mid;
                    }
                }
                //no top find to put num, add one more pile
                if(left>=piles) piles++;
                //tops[left] to put num
                tops[left]=num;
            }
            return piles;
        }
        
}
