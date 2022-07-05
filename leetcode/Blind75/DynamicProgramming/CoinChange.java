package Leetcodes.Blind75.DynamicProgramming;

public class CoinChange {
    //O(n*k), k is the length of coins array
    public int coinChange(int[] coins, int amount) {
        //initialize to 0
        int[] dp = new int[amount+1];
        //base case: dp[0]=0
        if(amount== 0) return 0;
        //    i:   1,2,3,.....amount
        //for dp[]: dp[i] is the least number of coins sum up to amount i
        for(int i=1;i<=amount; i++){//i is the amount
            int min = -1;//each dp[i], initialize min=-1
            //for each coin, to sum up to amount
            for(int coin: coins){
                //i-coin must >=0 , dp[i-coin]!=-1 means no such coins sums to amount
                if(i-coin>=0 && dp[i-coin]!=-1){
                    //calculate the temp and compare it with min
                    int temp = dp[i-coin]+1;
                    if(min==-1){//haven't find such coins
                        min = temp;
                    }else{//min!=-1, have find such coins, compare the temp with min
                        min = Math.min(min, temp);
                    }
                    //min = min==-1? temp: Math.min(min, temp);
                }
            }
            dp[i]=min;
        }
        return dp[amount];
    }
}
