const strings = ['a', 'b', 'c', 'd'];
//32 bit systerm: 4*4 bytes of storage

//push: adding element at the end
//return the length of array
strings.push('e'); //O(1)

//pop: remove element from the end
//return the popped element
strings.pop(); //O(1)

//unshift: adding element at the start
//return the length of array
strings.unshift('x'); //O(n)

//splice
//splice(indexOfStart, [deletedCount], [addingItem])
//return a array of deleletd Elements
strings.splice(2, 0, 'hello'); //O(n)
console.log(strings);
