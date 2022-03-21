//in JS, an object is a hash table
let user = {
	age: 54,
	name: 'Kylie',
	magic: true,
	scream: function () {
		console.log('ahhhhhhhhhhh');
	},
};

user.age; //O(1) loopup
user.spell = 'abra kadabra'; //O(1) inseart
user.scream(); //O(1)
