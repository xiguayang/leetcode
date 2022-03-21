/**
 * 189 Rotate Array [M]
 * Given an array, rotate it to the right by k steps, k>0
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
// 0 ..........n=length-1
//
// 0 1 2 3 4 5 6
// 1. reverse left part: 3 2 1 0
// 2. reverse right part: 6 5 4
// 3. reverse whole array: 4 5 6 0 1 2 3
// k=3 length =7  [0....3, 4....6]
// part 1: from index [(length-k)...length-1] move to [0...k-1]
// part 2: from index [0....length-k-1] move to right part: [k...length-1]
// 4 5 6 0 1 2 3
// i=(i+k)%length
function reverse(arr, start, end) {
	while (start < end) {
		let temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		start++;
		end--;
	}
}
var rotate = function (nums, k) {
	//check input
	if (nums === null || nums.length < 2) return;
	k = k % nums.length;
	reverse(nums, 0, nums.length - k - 1);
	reverse(nums, nums.length - k, nums.length - 1);
	reverse(nums, 0, nums.length - 1);
};
