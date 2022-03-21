//using Array to build a stack
// x  x  x  x   x
// 0  1  2  3   4
//bottom........top
//bottom is index 0
//top is index: array.length-1
class Stack {
	constructor() {
		this.array = [];
	}
	//get the top of stack
	//the last element of the array
	peek() {
		return this.array[this.array.length - 1];
	}

	//push one on the top ===> push at the end of the array
	push(value) {
		this.array.push(value);
		return this;
	}
	//pop on the top ===>remove the last element of the array
	pop() {
		this.array.pop();
		return this;
	}
	isEmpty() {
		if (this.length === 0) return true;
		return false;
	}
}
const myStack = new Stack();
myStack.push('google');
myStack.push('udemy');
myStack.push('discord');
myStack.peek();
myStack.pop();
myStack.pop();
myStack.pop();
