## BLIND 75 Questions
### Array
1. Two Sum
    - given an array + target, return indexes of num sum to target
    - using **HashMap** to record visited numbers in the array, check if the remain existed in the visited map
    - Time O(N), Memory O(N)
2. Best Time Buy and Sell Stock
    - given an array with prices, return maximun profit
    - using **Two Pointers**: one for buy(start 0), one for sell(start 1), calculate profit; if profit<0, move buy to sell; if profit >0, compare with max; move sell by 1;
    - Time O(N) Memory O(1)
3. Contains Duplicate 217
    - given an array, return true if contains duplicate
    - 1. **sort the array**, compare by 2 in linear time, Time O(NLogN) for sorting, no more extra memory
    - 2. using **HashSet** to record visited num, extra Memory O(N), Time O(N)
4. Product of Array Except Self 238
    - given an array, return an array answer such that answer[i] is the product of all other elements
    - O(N) time requirement
    - calculate **prefix** of each element: set prefix =1 for first num,  set result[i]= prefix, prefix = prefix*nums[i]
    - calculate **suffix** of each element from end: set suffix =1 for last num, set result[i]=result[i]*suffix, suffix = suffix * nums[i]
    - O(n) O(n)
5. Maximum Subarry 53
    - given an array, find the contiguous subarray(>=1) largest sum and return sum
    - **Siliding window**, if negative prefix, move the left pointer by 1, clear sum to 0; Or compare with max, move right pointer by 1 adding to prefix
    - O(N) Linear 
6. Maximum Product Subarray 152
    - given an array, find a contiguous non empty subarray that has the largest product, return product
    - patterns: linear traverse the array by keeping recording the max and min product.(compare with both product curMin*n and curMAX*N)
                if encounterrd with 0, set curMin and curMax to 1
7. Find Minimum in Rotated Sorted Array 153
    - Given an array of length n, sorted in ascnding order, rotated [1 - n] times, find the min
    - {0,1,2,3,4}, length 5, rotated 5 times is {0,1,2,3,4}, rotated 1 times is {4,0,1,2,3}
    - O(logN)
    - **Binary Search**: while(l<=r){l=mid+1, r=mid-1}
    - 1. find the mid
    - 2. compare nums[mid] >= nums[l] ==> left is ascending order, min is at the right partition {l=mid+1, r}
         else nums[mid] < nums[l] ==> left is not ascending order, min is at the partition {l, r=mid-1}
        always compare nums[mid] with min to get the min
8. Search in Rotated Sorted Array 33
    - Search in O(LogN) Time
    - find the min index of the array as the pivot, the left subarray and right subarray are both sorted
    - compare target with the nums[l] to make sure which part the target is at
    - **binary search** that part
15. 3 Sum 
    - Given an array, 3 elements sum to 0, all triplets without duplicates
    - Step1: Sort the array: O(nlogn)
    - Step2: traverse the array, nums[i], find 2 other elements sum to 0-nums[i]
        - Using **2 pointers** for the 2 sum problems
        O(N^2)
11. Container With Most Water 
    - given an array of heights, find most water it can contain
    - brute force: O(n^2)
    - **2 pointers**: l =0, r =length-1, calculate the area:(r-l)*min(height[r],height(l))
        - shift l or r by compare the height[l],height[r] untill l==r , compare with max  
209. Minimum Size Subarray Sum
    - **Sliding Window** O(N)


### Bit
268. Missing Number
    - an array nums contain n distinc numbers in range [0,n], actually n+1 numbers, find missing number
    - solution: 
    - 1. XOR: 2xor3: 10xor11==> 01 ==>1
            n xor n ==> 0
            0 xor n ==> n
            a xor b xor a ===> b
        nums XOR 0 XOR 1 XOR 2 XOR ...n====> the missing number

### Linked List
**check the list is one node or null**
141. Linked List Cycle
    - fast and slow pointer
206. Reverse Linked List
207. Reversed Linked List II (partial)
    - use prev Node and temp Node to record the previous and next position
21. Merge Two Sorted Lists
    - using dummy node to record the head of the new linked list
    - corner case: one list is null; reaching one list's end adding the other one's remaining nodes
23. Merge k Sorted Lists
    - Merge 2 sorted linked List, each merge takes O(N), do merge operations LogK times, k is the list numer
    -**Divide and Conquer**==> O(NlogK)
    - List1, List2, List3, List4, List5, List6  
    ==> List12, List34, List56
    ==> List1234, List56
    ==> List123456]
143. Reorder List
    - reorder the list : l1 -> ln -> l2 -> ln-1 -> ....
    - Step1: using fast & slow pointers to find the middle of the list
            fast.next==null || fast.next.next==null ==>slow is now the last of left half
    - Step2: reverse the half after slow
    - Step3: start reorder one by one of the left and right half, remenber to set last one.next=null

86. Partition List: using 2 extra sublists

203. Remove Linked List Elements: make sure to record previous node
19. Remove Nth Node From End of List
    - remove the Nth node from end
    - Step1: 2 pointers: l starts from 0, r starts l+N
      Step2: move 2 pointers until r.next is null
      Step3: remove the nth node(now is l.next): l.next = l.next.next 
      - must have a dummyNode!!

234. Palindrome Linked List
148. Sort List: MergeSort(Recursion: O(nLogn))
    - 1. find the mid of the list: f,s= head, while(f.next!=null && f.next.next!=null)
    - 2. seperate the list to 2 sublists: [head -> ...-> mid ->null]
                                    [mid.next -> ... -> end-> null]
    - 3. recursively merge sort the sublists: base case is 1 node or node is null
    - 4. merge 2 sorted sublist: using dummynode

61. Rotate List
    - break the list into 2 sublist: left and right sublist(contains last k nodes)
    - swap right and left: connect the right sublist to the left sublist

### String
3. Longest Substring Without Repeating Characters
    - using sliding window: r moves 1 by one, check if the char is appeared before; shrink the window if l is at the left of the duplicated char
    - using a HashMap to record the last appeared char and its index
242. Valid Anagram
    - using HashMap to record all chars in t and times it appeard, check t's chars and minus times; check if all the times is 0
125. Valid Palindrome
    - two pointers(l, r) check if same


### Tree
100. Same Tree
    - given 2 BT, check if they are same
    - Recursion: check root, check root.left, check root.right
    - make sure edge case: p,q both null; p || q ==null 
    - O(p+q)
226. Invert Binary Tree
    - look the node, swap its left and right subtrees
    - Recursion: DFS: O(N)

104. Maximum Depth of Binary Tree
    - Recursion(DFS): Math.max(maxDepth(root.left), maxDepth(root.right))+1
    - O(N)
543. Diameter of Binary Tree
110. Balanced Binary Tree

572. Subtree of Another Tree
    - Recursion(DFS): check root.left and root.right to see if they are same tree
        - if same tree return true;
        - else recursion isSubtree of their children
    - O(N*M)
235. Lowest Common Ancestor of a Binary Search Tree(root, p, q)
    - it is a BST: if p<= root.val <=q --> return root
                if p < root.val && q < root.val ---> recursion function(root.left,p,q)
                if p, q > root.val ----> recursion function(root.right, p, q)
    - Time O(logN): only visite half part
    - Iteractive: root=root.left or root=root.right

98. Validate Binary Search Tree[m]
    - check if the tree is BST: all left< root < right
    - Method 1: Recursion Method: isValid(TreeNode root, long min, long max)
        - for root: MIN< root.val < Max
        - for root.left: min < root.left< root.val
        - for root.right: root.val < root.right.val < max
    - Method 2: Interactive inorder traversal sturcture
        - using Stack to store leftmost nodes
        - using preNode to store root.left node or root of current node
    - Method 3: Inorder Traversal Recursion: check if the array is sorted

230. Kth Smallest Element in a BST
        - Method1: using interactive inordertraversal to add nodes into arraylist inorder
        - get the k-1 index of the result list (not neccessary)
        - adding the nodes into list is inorder, the Kth means the kth time adding to list
        - ==> every time adding to list: k-1
        - the first adding to list is k =1
        - so when k-1 ==0, break the loop and return the root.val

102. Binary Tree Level Order Traversal
    - Method1: using a helper function to pass res, level number Recursion
    - Method2: using a queue to adding nodes at the same level
199. Binary Tree Right Side View: first right sub tree then left subtree
103. Binary Tree Zigzag Level Order Traversal: %2 !=0  ==> sublist.add(0,val)
107. Binary Tree Level Order Traversal II: buttonup==> res.get(res.size()-level-1).add(root.val);
637. Average of Levels in Binary Tree [BFS easier than Recursion]
515. Find Largest Value in Each Tree Row [BFS easier than Recursion]