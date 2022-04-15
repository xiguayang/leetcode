package Patterns.Arrays.Medium;

/**
 * #283. Product of Array Except Self
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

*/
class ProductArrayExceptSelf {
/* Solution:
1. Given an array [2,3,4,5]
2. to each element in the array: product is its left* its rihgt(for 4, left is 2*3, rihgt is 5)
3. get the left product of each element ans store in a new array res(given 1 if no left/right)

Loop 1: calculate prefix(left)
nums:  [2,   3,  4,       5]
left:  
res:    1,   2,  2*3,  2*3*4
4. get the rihgt product of each element
Loop 2: calculate postfix(right)
nums:  [2,      3,     4,     5]
res:    1,      2,    2*3,  2*3*4
right:  3*4*5, 4*5,    5,     1

4. get the product of left product * right product of each element

*/
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        //get the left product of each num
        res[0]=1;
        for(int i=1;i<length;i++){//O(n)
            res[i]=nums[i-1]*res[i-1];
        }
        //get the right product of each num
        int right = 1;//Space O(1)
        for(int i = length-1;i>=0;i--){//O(N)
            res[i]=right*res[i];//left product * right
            right = nums[i]*right;//get the right of next element
        }
        return res;
    }
}
