package GreedyAlgrithms;

import javax.naming.ldap.ManageReferralControl;

public class AssignCandies {
    /**
     * There are n children standing in a line. Each child is assigned a rating
     * value given in the integer array ratings. You are giving candies to these
     * children subjected to the following requirements. (1)Each child must have at
     * least one candy. (2)Children with a higher rating get more candies than their
     * neighbors. Return the minimum number of candies you need to have to
     * distribute the candies to the children.
     * 
     * @param ratings
     * @return
     */
    // 只需要简单的两次遍历即可：把所有孩子的糖果数初始化为 1；
    // 先从左往右遍历一遍，如果右边孩子的评分比左边的高，则右边孩子的糖果数更新为左边孩子的糖果数加 1；
    // 再从右往左遍历一遍，如果左边孩子的评分比右边的高，且左边孩子当前的糖果数不大于右边孩子的糖果数，
    // 则左边孩子的糖果数更新为右边孩子的糖果数加 1。
    // 通过这两次遍历，分配的糖果就可以满足题目要求了。
    // 这里的贪心策略即为，在每次遍历中，只考虑并更新相邻一侧的大小关系。

    public static int candy(int[] ratings) {
        int size = ratings.length;
        int[] candies = new int[size];
        int sum = size;
        if (ratings.length < 2) {
            return 1;
        }
        for (int i = 1; i < size; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int j = size - 1; j > 0; j--) {
            if (ratings[j] < ratings[j - 1]) {
                if (candies[j - 1] <= candies[j]) {
                    candies[j - 1] = candies[j] + 1;

                }

            }
            sum = sum + candies[j];
        }
        return sum + candies[0];
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2 };
        System.out.println(candy(arr));
    }
}
