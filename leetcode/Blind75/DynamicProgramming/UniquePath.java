package Leetcodes.Blind75.DynamicProgramming;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        //grid starts from [0][0] to [m-1][n-1]
        //there're 2 ways to [m-1][n-1]: [m-2][n-1] + [m-1][n-2]
        int[][] dp = new int[m][n];
        //base case
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //i=0 or j = 0: only 1 way to go there
                if(i==0||j==0){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
