//create a functioni that reverses a string:
//input: 'Hi My name is Andrei'
//output: 'ierdnA si eman yM iH'
function reverseStrMy(str) {
	//check for valid input
	if (!str || typeof str != 'string' || str.length < 2) return str;
	//string to array
	const arrStr = str.split('');
	//index: 0 ---len-1
	let len = arrStr.length - 1;
	//0,1,2,3,4,5
	//mid = 2
	//0,1,2,3,4
	//mid =2
	let mid = len / 2;
	for (let i = 0; i <= mid; i++) {
		let temp = arrStr[i];
		arrStr[i] = arrStr[len - i];
		arrStr[len - i] = temp;
	}
	//array to string
	return arrStr.join('');
}

function reverse1(str) {
	//check input
	const backwards = [];
	for (let i = str.length - 1; i >= 0; i--) {
		backwards.push(str[i]);
	}
	return backwards.join('');
}

function reverse2(str) {
	//check input
	return str.split('').reverse().join('');
}

//new ES6
const reverse3 = (str) => str.split('').reverse().join('');
//using deconstruct
const reverse3 = (str) => [...str].reverse().join('');
