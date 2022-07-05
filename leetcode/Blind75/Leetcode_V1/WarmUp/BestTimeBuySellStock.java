package Leetcodes.Leetcode_V1.WarmUp;

//two pointers:
//initialize buy pointer points to 0; sell pointer points to 1;
//calculate profit = prices[sell]-prices[buy]
//  if profit <0, having lower buying price, move buy pointer to the sell position
//  if profit >0, compare with max
// move sell pointer to next
//O(N)
public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        //using 2 pointers, l and r
        // l -> the lowest price to buy
        // r -> the highest price
        int profit = 0;
        int l =0;
        int r = 0;
        while(r<prices.length){
            if(prices[r]<prices[l]){
                l=r;
            }else{
                profit = Math.max(profit, prices[r]-prices[l]);
            }
            r=r+1;
        }
        return profit;
    }
    
}
