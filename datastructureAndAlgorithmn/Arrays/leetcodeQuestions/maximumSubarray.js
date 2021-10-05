//53. Maximum Subarray
// Given an integer array nums,
// find the contiguous subarray (containing at least one number)
// which has the largest sum and return its sum.

// A subarray is a contiguous part of an array.
/**
 * @param {number[]} nums
 * @return {number}
 */
// Ideas: if nums[i]<0 the sum of subarray is smaller
//input: [-2,1,-3,4,-1,2,1,-5,4]
var maxSubArray = function (nums) {
	if (nums.length === 1) return nums[0];
};
