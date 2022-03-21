// 10---->5----->16
// let myLinkedList = {
// 	head: {
// 		value: 10,
// 		next: {
// 			value: 5,
// 			next: {
// 				value: 15,
// 				next: null,
// 			},
// 		},
// 	},
// };
class Node {
	constructor(value) {
		this.value = value;
		this.next = null;
	}
}
class LinkedList {
	//consrtuctor only has one node, it's head and also tail;
	//also specify length
	constructor(value) {
		this.head = {
			value: value,
			next: null,
		};
		this.tail = this.head;
		this.length = 1;
	}
	//adding a value at the tail
	append(value) {
		//create a new node with value
		// const newNode = {
		// 	value: value,
		// 	next: null,
		// };
		const newNode = new Node(value);
		this.tail.next = newNode;
		this.tail = newNode;
		this.length++;
		return this;
	}
	//adding a value before the head
	prepend(value) {
		//create a new node
		const newNode = new Node(value);
		newNode.next = this.head;
		this.head = newNode;
		this.length++;
		return this;
	}

	//insert a value in specific index
	insert(index, value) {
		const newNode = new Node(value);
		if (index === 0) {
			newNode.next = this.head;
			this.head = newNode;
			this.length++;
			return this;
		}
		//get the node before insert location
		let pivot = this.head;
		while (index > 1 && pivot.next !== null) {
			pivot = pivot.next;
			index--;
		}
		newNode.next = pivot.next;
		pivot.next = newNode;
		this.length++;
		return this;
	}
	traverseToIndex(index) {
		//check params
		if (index < 0) return;
		let counter = 0;
		let currentNode = this.head;
		while (counter !== index) {
			currentNode = currentNode.next;
			counter++;
		}
		return currentNode;
	}
	insert2(index, value) {
		//check params
		if (index >= this.length) {
			return this.append(value);
		}
		const newNode = new Node(value);
		if (index === 0) {
			newNode.next = this.head;
			this.head = newNode;
			this.length++;
			return this;
		}
		//get the node previous the index of insert
		let leader = this.traverseToIndex(index - 1);
		newNode.next = leader.next;
		leader.next = newNode;
		this.length++;
		return this;
	}

	//delete the node in specific index
	//get the previous node
	//pre.next = deletedNode.next;
	delete(index) {
		//check params
		if (index < 0 || index >= this.length) return;
		if (index === 0) {
			this.head = this.head.next;
		} else {
			let leader = this.traverseToIndex(index - 1);
			let removedNode = leader.next;
			leader.next = removedNode.next;
		}

		this.length--;
		return this;
	}
	//print the linked list values like an array
	printList() {
		const array = [];
		let currentNode = this.head;
		while (currentNode !== null) {
			array.push(currentNode.value);
			currentNode = currentNode.next;
		}
		return array;
	}
}

const myLinkedList = new LinkedList(10);
myLinkedList.append(5);
myLinkedList.printList();
