package Leetcodes.Blind75.DynamicProgramming;

public class UniquePathII {
    // 63
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1) return 0;
        
        int[][] dp = new int[m][n];
        //base case
        dp[0][0]=1;
        //edge case: first row: can only from left 
        for(int i=0; i<m; i++){
            //if one space is 1, all remaining right space can't reach: dp=0
            if(obstacleGrid[i][0]==1){
                while(i<m){
                    dp[i][0]=0;
                    i=i+1;
                }
            }else{
                dp[i][0]=1;
            }
        }
        //edge case: first column: can only from top
        for(int j=0; j<n; j++){
            //if one space is 1, all remaining bottom space can't reach: dp=0
            if(obstacleGrid[0][j]==1){
                while(j<n){
                    dp[0][j]=0;
                    j=j+1;
                }
            }else{
                dp[0][j]=1;
            }
        }
        //ifobstacleGrid[i][j]==1, can't reach: set 0
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1 ){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
