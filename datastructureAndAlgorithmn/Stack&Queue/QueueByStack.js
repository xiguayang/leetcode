// 232. Implement Queue using Stacks

// Implement a first in first out (FIFO) queue using only two stacks.
//The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

// Implement the MyQueue class:

// void push(int x) Pushes element x to the back of the queue.
// int pop() Removes the element from the front of the queue and returns it.
// int peek() Returns the element at the front of the queue.
// boolean empty() Returns true if the queue is empty, false otherwise.

// Notes:
// You must use only standard operations of a stack,
//which means only push to top, peek/pop from top, size, and is empty operations are valid.

var MyQueue = function () {};

/**
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function (x) {};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function () {};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function () {};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function () {};

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
class CrazyQueue {
	constructor() {}

	enqueue(value) {}

	dequeue() {}
	peek() {}
}

const myQueue = new CrazyQueue();
myQueue.peek();
myQueue.enqueue('Joy');
myQueue.enqueue('Matt');
myQueue.enqueue('Pavel');
myQueue.peek();
myQueue.dequeue();
myQueue.dequeue();
myQueue.dequeue();
myQueue.peek();
