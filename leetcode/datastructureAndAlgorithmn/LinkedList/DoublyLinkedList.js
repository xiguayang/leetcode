class Node {
	constructor(value) {
		this.value = value;
		this.prev = null;
		this.next = null;
	}
}

class DoublyLinkedList {
	constructor(value) {
		this.head = {
			value: value,
			prev: null,
			next: null,
		};
		this.tail = this.head;
		this.length = 1;
	}

	append(value) {
		const newNode = new Node(value);
		//prev points to the previous tail
		newNode.prev = this.tail;
		this.tail.next = newNode;
		this.tail = newNode;
		this.length++;
		return this;
	}

	prepend(value) {
		const newNode = new Node(value);
		this.head.prev = newNode;
		newNode.next = this.head;
		this.head = newNode;
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
	insert(index, value) {
		//check param
		if (index === 0) {
			return this.prepend(value);
		}
		if (index >= this.length) {
			return this.append(value);
		}
		//get leader of the insert index node
		let leader = traverseToIndex(index - 1);
		let follower = leader.next;
		let newNode = new Node(value);
		leader.next = newNode;
		newNode.prev = leader;
		newNode.next = follower;
		follower.prev = newNode;
		this.length++;
		return this;
	}
	remove(index) {
		//check param
		if (index < 0 || index >= this.length) return;
		//remove header
		if (index === 0) {
			this.head.next.prev = null;
			this.head = this.head.next;
		} else if (index === this.length - 1) {
			//remove the tail
			this.tail = this.tail.prev;
			this.tail.next = null;
		} else {
			//get the node to be removed
			let removedNode = traverseToIndex(index);
			removedNode.prev.next = removedNode.next;
			removedNode.next.prev = removedNode.prev;
		}
		this.length--;
		return this;
	}
}
