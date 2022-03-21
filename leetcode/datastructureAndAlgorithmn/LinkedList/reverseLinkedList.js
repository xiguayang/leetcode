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
	//insert a value in specific index
	insert(index, value) {
		if (index >= this.length) {
			return this.append(value).printList();
		}
		if (index === 0) {
			return this.prepend(value).printList();
		}
		const newNode = new Node(value);
		let leader = this.traverseToIndex(index - 1);
		newNode.next = leader.next;
		leader.next = newNode;
		this.length++;
		return this.printList();
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
		return this.printList();
	}
	//reverse the single linked list
	reverse() {
		if (this.length === 1) return this.printList();
		let first = this.head;
		//specify tail is head now. tail.next is still null
		this.tail = this.head;
		let second = first.next;
		while (second) {
			let temp = second.next; //temp is the 3th
			second.next = first;
			first = second;
			second = temp;
		}
		//cannot change the order of next 2 lines
		//this.head.next set to null and then make head equals to first
		this.head.next = null;
		this.head = first;
		return this.printList();
	}
}
const myLinkedList = new LinkedList(10);
myLinkedList.append(5);
myLinkedList.append(15);
myLinkedList.prepend(20);
myLinkedList.prepend(30);
myLinkedList.insert(1, 4);
myLinkedList.delete(5);
