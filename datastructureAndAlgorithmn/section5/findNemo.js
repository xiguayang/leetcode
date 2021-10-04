const nemo = ['nemo'];
const everyone = ['dory', 'bruce', 'marlin', 'dasga', 'nemo', 'hank', 'suirt'];
const large = new Array(100000).fill('nemo');

function findNemo(array) {
	for (let i = 0; i < array.length; i++) {
		if (array[i] === 'nemo') {
			console.log('found Nemo');
		}
	}
}
//ES6
const findNemo2 = (array) => {
	array.forEach((fish) => {
		if (fish === 'nemo') {
			console.log('fonud Nemo');
		}
	});
};

const findNemo3 = (array) => {
	for (let fish of array) {
		if (fish === 'nemo') {
			console.log('fonud Nemo');
		}
	}
};
findNemo(everyone);
findNemo2(everyone);
findNemo3(everyone);
