package Blind75.array;

import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
//Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K
public class MaxSumSubArraySizeK {
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        //Using a sliding window which is size K
        // subSum is the sum of the most left K element
        int subSum = 0;
        for(int j=0;j<K;j++){
            subSum+=Arr.get(j);
        }
        int max = subSum;
        for(int i =K;i<Arr.size();i++){
            //moving the slide window to next element
            //add the next element, and remove the element at position(i-K) to keep the window size
            subSum = subSum + Arr.get(i)- Arr.get(i-K);
            max = Math.max(max, subSum);
        }
        return max;
    }
}
