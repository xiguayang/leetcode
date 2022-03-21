// Given 2 arrays, create a function that let's a user know (true/false) whether these two arrays contain any common items
//For Example:
//const array1 = ['a', 'b', 'c', 'x'];//const array2 = ['z', 'y', 'i'];
//should return false.
//-----------
//const array1 = ['a', 'b', 'c', 'x'];//const array2 = ['z', 'y', 'x'];
//should return true.

// 2 parameters - arrays - no size limit
// return true or false
const array1 = ['a', 'b', 'c', 'x'];
const array2 = ['z', 'y', 's'];
function containsCommonItems(arr1, arr2) {
	//#1 brute force
	//iterate every element of arr1
	//to check if arr2 has this element
	//2 nested for loops O(a*b)
	for (let i = 0; i < arr1.length; i++) {
		for (let j = 0; j < arr2.length; j++) {
			if (arr1[i] === arr2[j]) {
				return true;
			}
		}
	}
	return false;
}
//O(a*b)
//O(1) - Space Complexity
containsCommonItems(array1, array2);

//using hashmap for better effiency
// array1 ===> obj{
//  a: true,
//  b: true,
//  c: true,
//  x: true
// }
// array2[index] === obj.properties
//loop through first array and create an object
//where properties === items in the array
function mapArray(arr) {
	let map = {};
	for (let i = 0; i < arr.length; i++) {
		if (!map[arr[i]]) {
			//check if the item has existed in map
			const item = arr[i];
			map[item] = true;
		}
	}
	return map;
}
function containsCommonItems2(arr1, arr2) {
	//can we assume alwarys 2 params?
	//check the input
	let map = mapArray(arr1);
	//console.log(map)
	//loop through seconde array and check if item in //second array existes on created object
	for (let j = 0; j < arr2.length; j++) {
		if (map[arr2[j]]) {
			return true;
		}
	}
	return false;
	//O(a + b) Time Complexity if better
	//O(a) space complexity
}
containsCommonItems2(array1, array2);
