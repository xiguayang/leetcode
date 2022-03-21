class Node {
	constructor(value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

class BinarySearchTree {
	constructor() {
		this.root = null;
	}
	insert(value) {
		const newNode = new Node(value);
		//tree is empty
		if (this.root === null) {
			this.root = newNode;
			return this;
		}
		let currentNode = this.root;
		while (true) {
			//go left
			if (value <= currentNode.value) {
				// if left is null, insert the new node
				if (!currentNode.left) {
					currentNode.left = newNode;
					//after inserting break loop and return
					return this;
				}
				//keep looping
				currentNode = currentNode.left;
				// go right
			} else {
				if (!currentNode.right) {
					currentNode.right = newNode;
					return this;
				}
				currentNode = currentNode.right;
			}
		}
	}
	//check if the value is in the tree
	lookup(value) {
		if (this.root === null) return false;
		let currentNode = this.root;
		//traverse the tree
		while (currentNode !== null) {
			if (currentNode.value === value) {
				return true;
			} else if (value < currentNode.value) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}
		return false;
	}
	//remove the value from the tree
	remove(value) {
		if (!this.root) {
			return false; //empty tree
		}
		let currentNode = this.root;
		let parentNode = null;
		//find the node to be removed firstly with its parent node
		while (currentNode !== null) {
			if (value < currentNode.value) {
				parentNode = currentNode;
				currentNode = currentNode.left;
			} else if (value > currentNode.value) {
				parentNode = currentNode;
				currentNode = currentNode.right;
			} else {
				//currentNode now is the node to be removed
				//Option 1: No right child [0 or 1 child]
				if (currentNode.right === null) {
					//Option 1.1: if the currentNode is the root
					if (parentNode === null) {
						this.root = currentNode.left;
					} else {
						//move the currentNode.left to be the child of it's parent
						//Option 1.2: parent > current, current is parent.left
						if (currentNode.value < parentNode.value) {
							parentNode.left = currentNode.left;
							//Option 1.3: parent < current, current is parent.right
						} else if (parentNode.value < currentNode.value) {
							parentNode.right = currentNode.left;
						}
					}
					//Option 2: Right child which doesn't have a left child
				} else if (currentNode.right.left === null) {
					//move currentNode.left to currentNode.right.left
					currentNode.right.left = current.left;
					//Option 2.1: if currentNode is the root,
					if (parentNode === null) {
						this.root = currentNode.right;
						//Option 2.2: compare parent value with current value
						// to decide move current.right child to parent's left or right
					} else {
						if (currentNode.value < parentNode.value) {
							parentNode.left = currentNode.right;
						} else if (parentNode.value < currentNode.value) {
							parentNode.right = currentNode.right;
						}
					}
					//option 3: Right child that has a left child
					//most difficult part: need to rebuid the subtree
				} else {
					//Step1: find the Right child's most left child
					let leftmost = currentNode.right.left;
					let letfmostParent = currentNode.right;
					while (leftmost.left !== null) {
						letfmostParent = leftmost;
						leftmost = leftmost.left;
					}
					//Step2: Move leftmost's Right child to be its parent's left(replaced leftmost)
					//leftmost now has no parent
					letfmostParent.left = leftmost.right;
					//Step3: move the removedNode's children to be  leftmost's children
					//===>replace leftmost's value with the removed Value
					leftmost.left = currentNode.left;
					leftmost.right = currentNode.right;

					//Option3.1: the removed node is root
					if (parentNode === null) {
						this.root = leftmost;
					} else {
						//Option 3.2: compare the currentNode with parent
						//to decide put leftmost to the left/right of ParentNode
						if (currentNode.value < parentNode.value) {
							parentNode.left = leftmost;
						} else if (currentNode.value > parentNode.value) {
							parentNode.right = leftmost;
						}
					}
				}
				return true;
			}
		}
	}
}
const bst = new BinarySearchTree();
bst.insert(9);
bst.insert(4);
bst.insert(1);
bst.insert(6);
bst.insert(15);
bst.insert(170);
bst.insert(20);
JSON.stringify(traverse(bst.root));
//    9
// 4     20
//1  6  15  170
function traverse(node) {
	const tree = { value: node.value };
	tree.left = node.left === null ? null : traverse(node.left);
	tree.right = node.right === null ? null : traverse(node.right);
	return tree;
}
