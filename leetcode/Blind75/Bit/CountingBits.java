package Leetcodes.Blind75.Bit;

public class CountingBits {

        public int[] countBits(int n) {
            //0---  0000---- 0 dp[0]
            //1---  0001-----1+dp[n-1]
            //2---  0010-----1+dp[n-2]
            //3---  0011-----1+dp[n-2]
            
            //4---  0100-----1+dp[n-4]
            //5---- 0101-----1+dp[n-4]
            //6---- 0110-----1+dp[n-4]
            //7---- 0111-----2+dp[n-4]
            
            //8---- 1000-----1+dp[n-8]
            //offset:[1,2,4,8...2^x]
            int[] ans = new int[n+1];
            int offset =1;
            for(int i=1;i<=n;i++){
                if(offset*2 == i){
                    offset = offset*2;
                }
                ans[i]=ans[i-offset]+1;
                
            }
            return ans;
        }
    }
