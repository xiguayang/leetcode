//Build Queue by Linked List
//  O--->O--->O--->O--->O--->O
// first                    last
//enqueue(value): adding at the last(tail)
//dequeue(): removing at the first(head)
//peek(): getting the first(head)
class Node {
	constructor(value) {
		this.value = value;
		this.next = null;
	}
}
class Queue {
	constructor() {
		this.first = null;
		this.last = null;
		this.length = 0;
	}
	//get the first of the queue
	//the head of linked list
	peek() {
		return this.first;
	}

	//adding one after the last===> push at the tail of the linked list
	enqueue(value) {
		const newNode = new Node(value);
		if (this.isEmpty) {
			this.first = newNode;
			this.last = newNode;
		} else {
			this.last.next = newNode;
			this.last = newNode;
		}

		this.length++;
		return this;
	}
	//removing the first one of the queue===>remove the head of the linkedList
	dequeue() {
		if (this.isEmpty) return null;
		//if only one node and we remove it, need to reassgin the last to null
		if (this.first === this.last) {
			this.last = null;
		}
		// let holdingPointer = this.first;
		this.first = this.first.next;
		this.length--;
		return this;
	}
	isEmpty() {
		if (this.length === 0) return true;
		return false;
	}
}

const myQueue = new Queue();
myQueue.enqueue('Joy');
myQueue.enqueue('Matt');
myQueue.enqueue('Pavel');
myQueue.enqueue('Amy');
myQueue.peek();
myQueue.dequeue();
