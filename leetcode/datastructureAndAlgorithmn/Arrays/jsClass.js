//reference type: object and array
var object1 = { value: 10 };
var object2 = object1;
var object3 = { value: 10 };

//context vs scope
const object4 = {
	a: function () {
		console.log(this);
	},
};
//{a: f}

//instantiation
class Player {
	constructor(name, type) {
		console.log('player', this);
		this.name = name;
		this.type = type;
	}
	introduce() {
		console.log(`Hi I am ${this.name}, I am a ${this.type}`);
	}
}

class Wizard extends Player {
	constructor(name, type) {
		super(name, type); //must call super firstly
		console.log('wizard', this);
	}
	play() {
		console.log(`WEEEEEE I'm a ${this.type}`);
	}
}

const wizard1 = new Wizard('Shelly', 'Healer');
wizard1.introduce();
wizard1.play();
const wizard2 = new Wizard('Shawn', 'Dark Magic');
