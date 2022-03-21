/**Given a int array and a number,
 * find if there's a pair of items in array sum to the number
 * return a boolean;
 * no repeat of an item
 */

//method1: native
//Time Complexity: O(n^2)
function hasPairWithSum(arr, sum) {
	for (let i = 0; i < arr.length - 1; i++) {
		for (let j = i + 1; j < arr.length; j++) {
			if (arr[i] + arr[j] === sum) {
				return true;
			}
		}
	}
	return false;
}

//method2: O(NlogN)
//sort the array first(O(NlogN))
//left and right pointer starts from 0 and the end dividly
//if(l+r > sum), r --> r-1
//if(l+r <sum), l-->l+1
//return true, if (l+r===sum)
//return false if r<=l
function sortArray(arr);
function hasPairWithSum2(arr, sum) {
	if (arr === null || arr.length <= 1) return false;
    let arr1 = sortArray(arr);
	let l = 0;
	let r = arr1.length - 1;
	while (l < r) {
		if (arr1[l] + arr1[r] > sum) {
			r--;
		}
        else if(arr1[l]+arr1[r]<sum){
            l++;
        }
        else if(arr1[l]+arr1[r]===sum){
            return true;
        }
	}
    return false;
}
//method3: better O(N)==> using Set() to check needed sum-arr[i]
//for every item in array, calculate sum-arr[i], and put the value to set
//check the set to see if it is the remaining value 
function hasPairWithSum3(arr, sum){
    const mySet = new Set();//set element is unique
    const len = arr.length;
    for(let i=0;i<len;i++){
        if(mySet.has(arr[i])){
            return true
        }
        mySet.add(sum-arr[i]);
    }
    return false;
}
hasPairWithSum3([6,4,3,2,1,7], 9)

var twoSum = function(nums, target) {
    const result =[];
    let myMap = new Map();
    for(let i =0;i<nums.length;i++){
        if(myMap.has(nums[i])){
            result.push(myMap.get(nums[i]));
            result.push(i);
        }
        myMap.set(target-nums[i],i);
    }
return result;
};
