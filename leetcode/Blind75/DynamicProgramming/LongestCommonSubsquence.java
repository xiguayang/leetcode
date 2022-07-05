package Leetcodes.Blind75.DynamicProgramming;

public class LongestCommonSubsquence {
    public int longestCommonSubsequence(String text1, String text2) {
        //buttom up
        int m = text1.length();
        int n = text2.length();
        //2-d array dp
        //dp array is a 2-d array with size m+1,n+1
        int[][] dp = new int[m+1][n+1];
        //last row and last column is 0: dp[m][...]=1; dp[..][n] =0
        //starts from dp[m-1][n-1] to dp[0][0]
        for(int i =m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1+dp[i+1][j+1];
                }else{
                    dp[i][j]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[0][0];        
    }
    /**
     *      a     c         e
     *  a                                           0
     *  b                                           0
     *  c                                           0
     *  d               max(dp[][],dp[][])          0
     *  e  0      0     1+dp[m][n]                  0
     *     0      0        0                        0 
     * 
     * 
     * max(dp[i+1][j],dp[i][j+1])  or 1+dp[i+1][j+1]
     */
}
