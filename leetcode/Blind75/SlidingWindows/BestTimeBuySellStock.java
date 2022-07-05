package Leetcodes.Blind75.SlidingWindows;

//two pointers:
//initialize buy pointer points to 0; sell pointer points to 1;
//calculate profit = prices[sell]-prices[buy]
//  if profit <0, having lower buying price, move buy pointer to the sell position
//  if profit >0, compare with max
// move sell pointer to next
//O(N)
public class BestTimeBuySellStock {
    public static int maxBenifit(int[] prices){
        int max = 0;
        int buy = 0;
        int sell = 1;
        while(sell<prices.length){
            int profit = prices[sell]-prices[buy];
            if(profit<0){
                buy = sell;
            }else{
                if(profit>max){
                    max = profit;
                }
            }
            sell++;
        }
        return max;
    }
    
}
