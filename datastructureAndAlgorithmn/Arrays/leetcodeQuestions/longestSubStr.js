// Longest Word
// Have the function LongestWord(sen) take the sen parameter being passed and return the longest word in the string. If there are two or more words that are the same length, return the first word from the string with that length. Ignore punctuation and assume sen will not be empty. Words may also contain numbers, for example "Hello world123 567"

function LongestWord(sen) {
	// code goes here
	let longest = '';
	let result = '';

	for (let i = 0; i < sen.length; i++) {
		let char = sen.charAt(i);
		if (checkAlphaNumeric(char)) {
			result = result + char;
		} else {
			result = '';
		}
		if (longest.length < result.length) {
			longest = result;
		}
	}
	return longest;
}
//using regex to checking if number or alphabet
//only check alphabet: char.upperCase()!==char.lowerCase()
function checkAlphaNumeric(input) {
	var letterNumber = /^[0-9a-zA-Z]+$/;
	if (input.match(letterNumber)) return true;
	return false;
}

//other solutions
function LongestWord2(sen) {
	// we use the regex match function which searches the string for the
	// pattern and returns an array of strings it finds
	// in our case the pattern we define below returns words with
	// only the characters a through z and 0 through 9, stripping away punctuation
	// e.g. "hello$% ##all" becomes [hello, all]
	var arr = sen.match(/[a-z]+/gi);

	// the array sort function takes a function as a parameter
	// which is used to compare each element in the array to the
	// next element in the array
	var sorted = arr.sort(function (a, b) {
		return b.length - a.length;
	});

	// this array now contains all the words in the original
	// string but in order from longest to shortest length
	// so we simply return the first element
	return sorted[0];
}

// keep this function call here
LongestWord(readline());
