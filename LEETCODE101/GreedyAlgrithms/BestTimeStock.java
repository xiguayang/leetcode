package GreedyAlgrithms;

/**
 * 122. Best Time to Buy and Sell Stock II[E] You are given an array prices
 * where prices[i] is the price of a given stock on the ith day. Find the
 * maximum profit you can achieve. You may complete as many transactions as you
 * like (i.e., buy one and sell one share of the stock multiple times).
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 */
// Input: prices = [7,1,5,3,6,4]
// Output: 7
// Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit =
// 5-1 = 4.
// Then buy on day 4 (price = 3) and sell on day 5(price = 6), profit = 6-3 =3.
public class BestTimeStock {
    // to get to most probfit, get all monotonically increasing intervals[单调递增区间]
    // buy the stock from the start of the interval and sell at the end of the
    // interval
    // buy at valley and sell at peak
    public static int maxProfit(int[] prices) {
        int i = 0;
        // initialize valley and peak as prices[0]
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        // traverse the array to the second last element
        while (i < prices.length - 1) {
            // if the next price is lower than previous one
            // keep move to get the valley
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            // if the next price is higher than previous one
            // keep move to get the peak
            // attention: not get out of the array
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            // each profit is the peak-valley
            maxprofit = maxprofit + peak - valley;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] price = new int[] { 7, 1, 3, 4, 2, 8 };
        System.out.println(maxProfit(price));
    }

}
