class Node {
	constructor(value) {
		this.value = value;
		this.next = null;
	}
}
//using Linked List to build a stack
// o--->o--->o--->
//top----------->bottom
class Stack {
	constructor() {
		this.top = null;
		this.bottom = null;
		this.length = 0;
	}
	//get the top of stack
	//the head of linked list
	peek() {
		// if (this.isEmpty()) return null;
		return this.top;
	}

	//push one on the top ===> push at the head of the linked list
	push(value) {
		const newNode = new Node(value);
		if (this.isEmpty) {
			this.bottom = newNode;
			this.top = newNode;
		} else {
			let holdingPointer = this.top;
			this.top = newNode;
			this.top.next = holdingPointer;
		}

		this.length++;
		return this;
	}
	//pop on the top ===>remove the head of the linkedList
	pop() {
		if (this.isEmpty) return null;
		//if only one node and we remove it, need to reassgin the bottom to null
		if (this.top === this.bottom) {
			this.bottom = null;
		}
		// let holdingPointer = this.top;
		this.top = this.top.next;
		this.length--;
		return holdingPointer;
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
