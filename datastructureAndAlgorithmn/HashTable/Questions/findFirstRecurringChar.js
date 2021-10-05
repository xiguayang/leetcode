//Given an array =[2,5,1,2,3,5,1,2,4]
//it should be 2
//Given an array=[2,3,4,5]
//it should be undefined

//if using 2 nested loops to compare ==> O(n^2)
function findFirstRecurringChar3(nums) {
	if (nums.length <= 1) {
		return undefined;
	}
	for (let i = 0; i < nums.length - 1; i++) {
		for (let j = i + 1; j < nums.length; j++) {
			if (nums[i] === nums[j]) return nums[i];
		}
	}
	return undefined;
}

//using Map or set hash table is O(1)
function findFirstRecurringChar(nums) {
	if (nums.length <= 1) {
		return undefined;
	}
	//using map
	let map = {};
	for (let i = 0; i < nums.length; i++) {
		//map[nums[i]] ===0 is also false, so specify undefined
		if (map[nums[i]] !== undefined) {
			return nums[i];
		} else {
			map[input[i]] = true;
		}
	}
	return undefined;
} //O(1)

function findFirstRecurringChar2(nums) {
	if (nums.length <= 1) {
		return undefined;
	}
	//using set
	let mySet = new Set();
	for (let i = 0; i < nums.length; i++) {
		if (mySet.has(nums[i])) {
			return nums[i];
		} else {
			mySet.add(nums[i]);
		}
	}
	return undefined;
}

//Given an array =[2,5,1,2,3,5,1,2,4]
//it should be 2
//Given an array=[2,3,4,5]
//it should be undefined

function findFirstRecurringChar(nums) {
	if (nums.length <= 1) {
		return undefined;
	}

	//using set
	let mySet = new Set();
	for (let i = 0; i < nums.length; i++) {
		if (mySet.has(nums[i])) {
			return nums[i];
		} else {
			mySet.add(nums[i]);
		}
	}
	return undefined;
}

//using Map or set hash table is O(1)
function findFirstRecurringChar2(nums) {
	if (nums.length <= 1) {
		return undefined;
	}
	//using map
	let map = {};
	for (let i = 0; i < nums.length; i++) {
		//map[nums[i]] ===0 is also false, so specify undefined
		if (map[nums[i]] !== undefined) {
			return nums[i];
		} else {
			map[nums[i]] = true;
		}
	}
	return undefined;
} //O(1)

function findFirstRecurringChar3(nums) {
	if (nums.length <= 1) {
		return undefined;
	}
	for (let i = 0; i < nums.length - 1; i++) {
		for (let j = i + 1; j < nums.length; j++) {
			if (nums[i] === nums[j]) return nums[i];
		}
	}
	return undefined;
}
arr1 = [2, 5, 5, 2, 3, 5, 1, 2, 4];
arr2 = [2, 3, 4, 5];
console.log(findFirstRecurringChar(arr1)); //5
console.log(findFirstRecurringChar2(arr1)); //5
console.log(findFirstRecurringChar3(arr1)); //2
