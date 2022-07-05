### 344. Reverse String
- Using 2 pointers, left and right until left>=right, swap chars
    Time: O(N)
### 205 isIsomorphic 2 Strings

### 1. Two Sum
-   Method1: 
    1. copy the array, 
    2. sort the copied array, 
    3. using 2 pointers to find target
    4. find the original index of numbers in original array(one from start to end, one verse vice)
    Time: O(nlogn), Memory: O(n)
-  Method2: Using HashMap
    1. use the HashMap to record the element as key and its index as value
    2. traverse the array, to find if remain has existed in the hashmap
    Time: O(n), Memory: O(n)
    
### 27. Remove Element (target, nums[])
- Using 2 pointers, fast and slow
- traverse the array by moving fast 
- only when nums[fast] != target: nums[slow]= nums[fast], move fast
    Time: O(N)

