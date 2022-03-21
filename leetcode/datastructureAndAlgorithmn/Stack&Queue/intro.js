//Stacks

//browser
//visit google.com
//visit udemy.com
//visit youtube.com

//browser history
//youtube
//udemy
//google

// push item at the end, poping item at the end, peeking at the end
// Implement Stacks using Array(technically faster next to each other)
// or Linked Lists(dynamic memory but tradeoff memory)

//Queues
//Matt -- Joy-- Samir ---Pavel
//enqueue at the end, dequeue at the start, peeking at the start
//Implement Queue with Linked List (remove from the header, adding at the tail)
//Do not use Arrays(inefficient!! everytime dequeue needs to shift all left elements)
const one = () => {
	const two = () => {
		console.log('4');
	};
};
//call stack
//one() ===> two()===>concole.log
//       <<---------execute
//stack overflow
function foo() {
	foo();
}
foo();

//call stack
console.log('1');
setTimeout(() => {
	console.log('2');
}, 2000);
console.log('3');

// setTimeout is called after console.log('1')
// it triggered WEB API: setTimeout
// pop from the stack
// console.log('3') runs
//CALL STACK

//setTimeout(), 2000
//waiting for 2 seconds and run setTimeout()
//setTimeout has a callback, join callback queque
//WEB API

//callback()
//CALLBACK QUEUE

//EVENT LOOP: keeps checking Call Stack, if Calll Stack is empty
//if empty, move from callback queue to CALL STACK
