import java.security.DrbgParameters.Reseed;
import java.util.Dictionary;
import java.util.Vector;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

/**
 * #322 Coin Change[M] You are given an integer array coins representing coins
 * of different denominations and an integer amount representing a total amount
 * of money. Return the fewest number of coins that you need to make up that
 * amount. If that amount of money cannot be made up by any combination of the
 * coins, return -1. You may assume that you have an infinite number of each
 * kind of coin
 */
public class CoinChange {
    /**
     * @param coins  the amount of each coin
     * @param amount total targeted amount
     * @return the lowest number of coins needed method 1: force bruce step1: base
     *         case: amount =0, return 0 step2: the changed status: the amount of
     *         each coin is certain the total amount changed step3: choice: the
     *         behavior results in the change: every time choose a coin, the amount
     *         reduced step4: the dp function dp(n): given n, return the smallest
     *         number of coins sums to n source code: def coinChange(coins:
     *         List[int], amount: int){ def dp(n): for coin in coins: res = min(res,
     *         i + dp(n-coin)) return res return dp(amount) } every subproblem has a
     *         for loop: O(k*n^k)
     * 
     */
    public static int coinChange(int[] coins, int amount) {
        // base case
        if (amount < 0) {
            return -1;
        }
        if (amount == 0)
            return 0;
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int numOfCoins = coinChange(coins, amount - coin);
            if (numOfCoins == -1)
                continue;
            if ((numOfCoins + 1) < result) {
                result = numOfCoins + 1;
            }
        }
        if (result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }

    /** method 2: with memo */
    // public static int coinChangeWithMemo(int[] coins, int amount) {
    // memo = Dictionary();
    // // base case
    // if (amount < 0) {
    // memo[0]=-1;
    // return -1;
    // }
    // if (amount == 0)
    // return 0;
    // int result = Integer.MAX_VALUE;
    // for (int coin : coins) {
    // int numOfCoins = coinChange(coins, amount - coin);
    // if (numOfCoins == -1)
    // continue;
    // if ((numOfCoins + 1) < result) {
    // result = numOfCoins + 1;
    // }
    // }
    // if (result == Integer.MAX_VALUE) {
    // return -1;
    // } else {
    // return result;
    // }
    // }

    public static void main(String[] args) {
        int[] coins = new int[] { 1, 2, 5 };
        System.out.println(coinChange(coins, 100));
    }
}
