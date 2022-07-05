package Leetcodes.Blind75.DynamicProgramming;
//64
public class MinimumPathSumGrid {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        //base case:
        dp[0][0]=grid[0][0];
        //first column
        for(int i = 1; i<m;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        //first row:
        for(int j=1;j<n;j++){
            dp[0][j] = dp[0][j-1]+grid[0][j];
        }
        //dp state: 
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
        
    }
}
