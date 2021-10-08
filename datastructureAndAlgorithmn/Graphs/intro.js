//Edge List: each element is the edge with 2 nodes
const graph1 = [
	[0, 2],
	[2, 3],
	[2, 1],
	[1, 3],
];
//Adjacent List: index is the value of node, and each element is the neighbors of the node
//if the node is not a number, actually using object key-value to present it
const graph2 = [[2], [2, 3], [0, 1, 3], [1, 2]];
//Adjacent Matrix: index/key is also the value of the node
//using matrix to represent the node connected
const graph3 = {
	0: [0, 0, 1, 0],
	1: [0, 0, 1, 1],
	2: [1, 1, 0, 1],
	3: [0, 1, 1, 0],
};
