class MyHashTable {
	constructor(size) {
		this.data = new Array(size);
	}
	//_private function, generate a hash value based on key
	// the hash value is the address of the pair key-value
	//the address is the index of array data
	//data=[ , i , , , , ]
	_hash(key) {
		let hash = 0;
		for (let i = 0; i < key.length; i++) {
			hash = (hash + key.charCodeAt(i) * i) % this.data.length;
		}

		return hash;
	}

	set(key, value) {
		//get the hash address based on key
		let address = this._hash(key);
		//if there's no info in index address
		if (!this.data[address]) {
			//create an array and push key and value
			this.data[address] = [];
			//[   ,   ,    ,   ,[[key,value]],   ,   , ]
			this.data[address].push([key, value]);
			return this.data;
		}
		//if data[address] is not empty, push the array of key,value into index array
		//[  ,   ,   ,   , [[k1,v1], [k2,v2]]]
		this.data[address].push([key, value]);

		return this.data;
	} //O(1)

	get(key) {
		//get the address by key
		const address = this._hash(key);
		//index is address, get the data[address]
		const currentBucket = this.data[address];
		if (currentBucket) {
			//not empty, but an array
			//loop the array to find value
			for (let i = 0; i < currentBucket.length; i++) {
				if (currentBucket[i][0] === key) {
					return currentBucket[i][1];
				}
			}
		} //O(1)
		return undefined;
	}

	//get all keys
	keys() {
		const keysArray = [];
		for (let i = 0; i < this.data.length; i++) {
			if (this.data[i]) {
				keysArray.push(this.data[i][0][0]);
			}
		}
		return keysArray;
	}
	//including hash collision preventation
	allkeys() {
		if (!this.data.length) return undefined;
		let results = [];
		//loop through all the bucket elements
		for (let i = 0; i < this.data.length; i++) {
			//if the buckect is not empty
			if (this.data[i] && this.data[i].length) {
				//loop through all potential collisions
				if (this.data[i].length > 1) {
					for (let j = 0; j < this.data[i].length; j++) {
						results.push(this.data[i][j][0]);
					}
				} else {
					results.push(this.data[i][0][0]);
				}
			}
		}
		return results;
	}
}
const myhashtable = new MyHashTable(50);
myhashtable.set('grapes', 10000);
myhashtable.set('apples', 54);
myhashtable.set('oranges', 2);
myhashtable.get('apples');
myhashtable.keys();
