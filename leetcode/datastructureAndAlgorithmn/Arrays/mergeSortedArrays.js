//given 2 sorted array, merge them into one sorted array
function mergeSortedArrays(arr1, arr2) {
	const result = [];
	//index i points to arr1
	//index j points to arr2
	let i = 0;
	let j = 0;
	let end1 = arr1.length - 1;
	let end2 = arr2.length - 1;
	while (i <= end1 && j <= end2) {
		if (arr1[i] <= arr2[j]) {
			result.push(arr1[i]);
			i++;
		} else {
			result.push(arr2[j]);
			j++;
		}
	}
	//adding the left items in arr2 into result
	if (i > end1) {
		while (j <= end2) {
			result.push(arr2[j]);
			j++;
		}
	}
	//adding the left items in arr1 into result
	if (j > end2) {
		while (i <= end1) {
			result.push(arr1[i]);
			i++;
		}
	}
	return result;
}
//given 2 sorted array, merge them into one sorted array
function mergeSortedArrays2(arr1, arr2) {
	//check if empty array
	if (arr1.length === 0) return arr2;
	if (arr2.length === 0) return arr1;

	const result = [];
	//index i points to arr1
	//index j points to arr2
	let i = 0;
	let j = 0;
	let end1 = arr1.length - 1;
	let end2 = arr2.length - 1;
	while (arr1[i] || arr2[j]) {
		if (arr1[i] <= arr2[j] || arr2[j] === undefined) {
			result.push(arr1[i]);
			i++;
		} else {
			result.push(arr2[j]);
			j++;
		}
		// //adding the left items in arr2 into result
		// if ((i > end1) & (j < end2)) {
		// 	result.push(arr2[j]);
		// 	j++;
		// }
		// //adding the left items in arr1 into result
		// if ((j > end2) & (i < end1)) {
		// 	result.push(arr1[i]);
		// 	i++;
		// }
	}
	return result;
}
