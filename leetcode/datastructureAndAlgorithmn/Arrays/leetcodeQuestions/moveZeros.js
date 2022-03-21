// 283 Move Zeros
//Given an integer array nums,
// move all 0's to the end of it
//while maintaining the relative order of the non-zero elements.
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function (nums) {
	//using 2 pointers, starts from index 0;
	//1 points to the first unswap 0;
	//1 points to the first non zero item;
	//encounter 0, swap it with next none-zero element
	let zeroPointer = 0;
	let nonZeroPointer = 0;
	for (let i = 0; i < nums.length; i++) {
		if (nums[i] === 0) {
			nonZeroPointer++;
		} else {
			if (nums[zeroPointer] === 0) {
				let temp = nums[zeroPointer];
				nums[zeroPointer] = nums[nonZeroPointer];
				nums[nonZeroPointer] = temp;
			}
			zeroPointer++;
			nonZeroPointer++;
		}
	}
};

var moveZeroes2 = function (nums) {
	let nzero = 0;
	for (let i = 0; i < nums.length; i++) {
		if (nums[i] != 0) {
			nums[nzero] = nums[i];
			nzero++;
		}
	}
	//fill the left elements with 0
	for (let j = nzero; j < nums.length; j++) {
		nums[j] = 0;
	}
};
